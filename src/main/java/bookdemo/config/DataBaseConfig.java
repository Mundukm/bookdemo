package bookdemo.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Created by Kolja on 28.06.2017.
 */
@Configuration
@PropertySources({
        @PropertySource("config/jdbc.properties"),
        @PropertySource("config/hibernate.properties")})
public class DataBaseConfig {

    @Autowired
    private Environment env;

    /**
     * Spring bean of database setting.
     * All properties are from config/jdbc.properties
     *
     * @return new configured data source
     */

    @Bean(name = "dataSource")
    @Profile("mysql")
    public DataSource dataSourceMySQL() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driverClassNameMySQL"));
        ds.setUrl(env.getProperty("jdbc.urlMySQL"));
        ds.setUsername(env.getProperty("jdbc.usernameMySQL"));
        ds.setPassword(env.getProperty("jdbc.passwordMySQL"));
        return ds;
    }

    @Bean(name = "dataSource")
    @Profile("h2")
    public DataSource dataSourceH2() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driverClassNameH2"));
        ds.setUrl(env.getProperty("jdbc.urlH2"));
        ds.setUsername(env.getProperty("jdbc.usernameH2"));
        ds.setPassword(env.getProperty("jdbc.passwordH2"));
        return ds;
    }

}
