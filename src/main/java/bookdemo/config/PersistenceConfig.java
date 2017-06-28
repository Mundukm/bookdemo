package bookdemo.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Persistence configuration.
 * Annotation Configuration to make this class configuration class
 * Annotation EnableTransactionManagement to use transactions
 * Annotation EnableJpaRepositories to use JPA repository
 * Annotation PropertySources to define additional properties
 * @author Myndyk Mykola
 * @version 1.0
 * @since 24.06.2017
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"bookdemo.repository"})
@PropertySources({
        @PropertySource("config/jdbc.properties"),
        @PropertySource("config/hibernate.properties")})
@ComponentScan(
        basePackages = {"bookdemo"}, excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Configuration.class) })
public class PersistenceConfig {

    /**
     * Auto created instance of environment.
     */
    @Autowired
    private Environment env;
    @Autowired
    private DataSource dataSource;

    /**
     * Packages spring to scan with session factory.
     */
    private String[] packages = {"bookdemo"};

    @Bean(initMethod="start",destroyMethod="stop")
    public org.h2.tools.Server h2WebConsonleServer () throws SQLException {
        return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8082");
    }

    /**
     * Method that initialize all properties for hibernate from environment.
     *
     * @return instance of properties.class with properties
     */
    private Properties getHibernateProperties() {
        Properties props = new Properties();
        props.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        return props;
    }




    /**
     * Spring bean for session factory.
     * Scanning "packages" from packages variable
     *
     * @param ds data source to use
     * @return configured session factory
     */
    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory(DataSource ds) {
        LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
        sf.setDataSource(ds);
        sf.setPackagesToScan(packages);
        sf.setHibernateProperties(getHibernateProperties());
        return sf;
    }

    /**
     * Spring bean for entity manager factory.
     * Setting new jpa vendor adapter,
     * setting packages to scan for factory,
     * setting data source
     *
     * @return instance of factory
     */
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("bookdemo");
        factory.setDataSource(dataSource);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    /**
     * Spring bean for jpa transactions.
     * Setting up entity manager factory
     *
     * @return new instance of transaction manager
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }
}
