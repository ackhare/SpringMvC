package com.nexthoughts.spring.mvc.demo.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
/*
Enables Spring's annotation-driven transaction management capability,
 similar to the support found in Spring's <tx:*> XML namespace.
 To be used on @Configuration classes as follows:
   @Configuration
   @EnableTransactionManagement
 */
@PropertySource(value = {"classpath:application.properties"})
/*
Annotation providing a convenient and declarative mechanism for adding a PropertySource
to Spring's Environment. To be
used in conjunction with @Configuration classes.
 */
public class HibernateConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;

    @Value("${hibernate.format_sql}")
    private String hibernateFormatSql;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateHbm2ddlAuto;

    @Value("${hibernate.current_session_context_class}")
    private String currentSessionContextClass;

    @Value("${hibernate.autocommit}")
    private String connectionAutoCommit;

    //The @Bean annotation tells Spring that a method annotated with
// @Bean will return an object that should be registered as a bean in the Spring application context.

    //so now spring factory will be present in to be autowired as we can see in student servicv
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        //dtasource defined below
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.nexthoughts.spring.mvc.demo.model"});
        //defined below
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    //The @Bean annotation tells Spring that a method annotated with
// @Bean will return an object that should be registered as a bean in the Spring application context.

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
    //The @Bean annotation tells Spring that a method annotated with
// @Bean will return an object that should be registered as a bean in the Spring application context.

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", hibernateDialect);
        properties.put("hibernate.show_sql", hibernateShowSql);
        properties.put("hibernate.format_sql", hibernateFormatSql);
        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        properties.put("hibernate.current_session_context_class", currentSessionContextClass);
        properties.put("hibernate.connection.autocommit", connectionAutoCommit);
        return properties;
    }

    /*
    @Autowired
    Marks a constructor, field, setter method or config method as to be autowired by Spring's
    dependency injection facilities.

Only one constructor (at max) of any given bean class may carry this annotation, indicating the constructor
 to autowire when used as a Spring bean.



Fields are injected right after construction of a bean,before any config methods are invoked.


Config methods may have an arbitrary name and any number of arguments;
 each of those arguments will be autowired with a matching bean in the Spring container.
 Bean property setter methods are effectively just a special case of such a general config method.
 */
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }

}
