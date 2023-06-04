package carlos.projects.apps;
import carlos.projects.shared.infrastructure.cli.ConsoleCommand;
import carlos.projects.apps.mooc.MoocBackendApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


import java.util.Arrays;
import java.util.HashMap;

// As we are doing custom savings, we don't want to Hibernate autoconfiguration class to act, so we exclude it.
public class Starter {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new RuntimeException("There are not enough arguments");
        }

        String  applicationName = args[0];
        String  commandName     = args[1];
        boolean isApiCommand = commandName.equals("api");

        ensureApplicationExist(applicationName);
        ensureCommandExist(applicationName, commandName);

        Class<?> applicationClass = applications().get(applicationName);

        SpringApplication app = new SpringApplication(applicationClass);

        // Springboot by default runs the webServer, if, in our case, with the commands we dont want to run the
        // api we force spring to disable the ApplicationWeb
        if (!isApiCommand) {
            app.setWebApplicationType(WebApplicationType.NONE);
        }

        ConfigurableApplicationContext context = app.run(args);

        if (!isApiCommand) {
            ConsoleCommand command = (ConsoleCommand) context.getBean(
                    commands().get(applicationName).get(commandName)
            );

            command.execute(Arrays.copyOfRange(args, 2, args.length));
        }

    }

    private static void ensureApplicationExist(String applicationName) {
        if (!applications().containsKey(applicationName)) {
            throw new RuntimeException(String.format(
                    "The application <%s> doesn't exist. Valids:\n- %s",
                    applicationName,
                    String.join("\n- ", applications().keySet())
            ));
        }
    }

    private static void ensureCommandExist(String applicationName, String commandName) {
        if (!"api".equals(commandName) && !existCommand(applicationName, commandName)) {
            throw new RuntimeException(String.format(
                    "The command <%s> for application <%s> doesn't exist. Valids (application.command):\n- api\n- %s",
                    commandName,
                    applicationName,
                    String.join("\n- ", commands().get(applicationName).keySet())
            ));
        }
    }

    private static HashMap<String, Class<?>> applications() {
        HashMap<String, Class<?>> applications = new HashMap<>();

        applications.put("mooc_backend", MoocBackendApplication.class);

        return applications;
    }

    private static HashMap<String, HashMap<String, Class<?>>> commands() {
        // <name_application, <name_command, class_command>>
        HashMap<String, HashMap<String, Class<?>>> commands = new HashMap<>();

        commands.put("mooc_backend", MoocBackendApplication.commands());

        return commands;
    }

    private static Boolean existCommand(String applicationName, String commandName) {
        HashMap<String, HashMap<String, Class<?>>> commands = commands();

        return commands.containsKey(applicationName) && commands.get(applicationName).containsKey(commandName);
    }

    @Bean
    public CommandLineRunner commandLineRunner (ApplicationContext ctx) {
        return args -> {
            System.out.println("Let´s inspect the beans provided by Spring Boot");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);

            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
