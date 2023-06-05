package carlos.projects.apps.mooc.command;

import carlos.projects.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import carlos.projects.shared.infrastructure.cli.ConsoleCommand;

public class ConsumeMySqlDomainEventsCommand extends ConsoleCommand {
    private MySqlDomainEventsConsumer consumer;

    public ConsumeMySqlDomainEventsCommand(MySqlDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void execute(String[] args) {
        consumer.consume();
    }
}
