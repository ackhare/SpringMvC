package com.nexthoughts.spring.mvc.demo.web.controller;

import com.nexthoughts.spring.mvc.demo.services.WelcomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class WelcomeController {
    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    /*

    @Autowired

    * Marks a constructor, field, setter method or config method as to be
     * autowired by Spring's dependency injection facilities.
     *
     */
    @Autowired
    private WelcomeService welcomeService;


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView index() {
        logger.info("Index executed");
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("title", welcomeService.getTitle());
        model.addObject("message", welcomeService.getMessage());
        return model;
    }
}
