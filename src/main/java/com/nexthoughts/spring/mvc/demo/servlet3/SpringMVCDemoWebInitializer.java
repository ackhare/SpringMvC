package com.nexthoughts.spring.mvc.demo.servlet3;


import com.nexthoughts.spring.mvc.demo.config.HibernateConfig;
import com.nexthoughts.spring.mvc.demo.config.SpringRootConfig;
import com.nexthoughts.spring.mvc.demo.config.SpringWebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//This is the entry point of this application
public class SpringMVCDemoWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*

    Abstract class

    Base class for org.springframework.web.WebApplicationInitializer implementations that register a
    DispatcherServlet configured with annotated classes, e.g. Spring's @Configuration classes.
    Concrete implementations are required to implement getRootConfigClasses() and
    getServletConfigClasses() as well as getServletMappings().
    Further template and customization methods are provided by AbstractDispatcherServletInitializer.


    Concrete implementations are required to implement getRootConfigClasses() and getServletConfigClasses()
    as well as
    getServletMappings(). Further template and customization methods are provided by
     AbstractDispatcherServletInitializer.



     //Whatever operation we r doing we are doing for the dispatcher servlet
      that DispatcherServlet configured with annotated classes, e.g. Spring's @Configuration classes.
     */
    //Specify the servlet mapping(s) for the DispatcherServlet
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //In this we will put things which are not part of web like services , hiberenate configuration s and blah blah
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringRootConfig.class, HibernateConfig.class};
    }

    ////Here all web component will be kept like jsp rtesources , controleers , images etc
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebConfig.class};
    }
}
