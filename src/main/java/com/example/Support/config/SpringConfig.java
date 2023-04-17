package com.example.Support.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@ComponentScan("com.example.Support")
@PropertySource("classpath:app.properties")
public class SpringConfig {
    private final Environment environment;

    @Autowired
    public SpringConfig( Environment environment){
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(Objects.requireNonNull(environment.getProperty("driver")));
        dataSource.setUrl("url");
        dataSource.setUsername("username");
        dataSource.setPassword("password");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return  new JdbcTemplate(dataSource());
    }

}
