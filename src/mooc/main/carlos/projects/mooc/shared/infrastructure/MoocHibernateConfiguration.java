package carlos.projects.mooc.shared.infrastructure;


import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import org.springframework.transaction.annotation.EnableTransactionManagement;



import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
@EnableTransactionManagement
public class MoocHibernateConfiguration {

    @Bean("mooc-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException  {
       LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
       sessionFactory.setDataSource(dataSource());
       sessionFactory.setHibernateProperties(hibernateProperties());

       List<Resource> mappingFiles = searchMappingFiles();

        // When im saving a course this must search a course from this path.
       sessionFactory.setMappingLocations(mappingFiles.toArray(new Resource[mappingFiles.size()]));

       return sessionFactory;
    }

    private List<Resource> searchMappingFiles() {
        String path = "./src/mooc/main/carlos/projects/mooc/";

        String[] modules = subdirectoriesFor(path);
        List<String> goodPaths = new ArrayList<>();

        for (String module : modules) {
            String[] files = mappingFilesIn(path + module + "/infrastructure/persistence/hibernate/");

            for (String file : files) {
                goodPaths.add(path + module + "/infrastructure/persistence/hibernate/" + file);
            }
        }
        return goodPaths.stream().map(FileSystemResource::new).collect(Collectors.toList());
    }

    private String[] subdirectoriesFor(String path) {

        String[] files = new File(path).list((current, name) -> new File(current, name).isDirectory());

        if (null == files) {
           return new String[0];
        }

        return files;
    }

    private String[] mappingFilesIn(String path) {
        String[] files = new File(path).list((current, name) -> new File(current, name).getName().contains(".hbm.xml"));

        if (null == files) {
            return new String[0];
        }

        return files;
    }
    @Bean
    public DataSource dataSource() throws IOException {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://mysql.db.server:3306/my_database?useSSL=false&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    /**
     * Propperties of hibernate.
     * Spring recommends to not config nothing via xml, it is considered as an anti-patron.
     * @return Object {hibernateProperties}
     */
    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        // none because we don't delegate the creation of the tables to hibernate,
        // we do it manually
        hibernateProperties.put(AvailableSettings.HBM2DDL_AUTO, "none");

        // We don't want to show the sql, set to true if you would like to debug.
        hibernateProperties.put(AvailableSettings.SHOW_SQL, "false");
        hibernateProperties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL8Dialect");

        return hibernateProperties;
    }


}