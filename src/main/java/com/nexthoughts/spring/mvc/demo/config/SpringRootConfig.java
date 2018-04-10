package com.nexthoughts.spring.mvc.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Annotating a class with the @Configuration indicates that the class c
// an be used by the Spring IoC container as a source of bean definitions.
@Configuration
@ComponentScan("com.nexthoughts.spring.mvc.demo.services")
//// search the com.nexthoughts.spring.mvc.demo.services for @Component classes
//ComponentScan--->Configures component scanning directives for use with @Configuration classes.
// Provides support parallel with Spring XML's <context:component-scan> element.
public class SpringRootConfig {
}
