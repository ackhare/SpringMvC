package com.nexthoughts.spring.mvc.demo.services;

import com.nexthoughts.spring.mvc.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WelcomeService {
    private final Logger log = LoggerFactory.getLogger(WelcomeService.class);
    private SessionFactory sessionFactory;

    /*

@Autowired

* Marks a constructor, field, setter method or config method as to be
 * autowired by Spring's dependency injection facilities.
 *
 */
    @Autowired
    public WelcomeService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {

        // log.info(sessionFactory.getCurrentSession().getClass().toString());
        return sessionFactory.getCurrentSession();
    }

    public String getTitle() {
        getSession();
        return "Spring MVC 4.3.4 + gradle 3.2.1 + Hibernate 4.3.6";
    }

    public String getMessage() {
        return "My SQL Connector 5.1.29";
    }


    public void saveOrUpdateStudent(Student student) {
        sessionFactory.openSession().saveOrUpdate(student);
    }
}
