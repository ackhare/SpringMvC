package com.nexthoughts.spring.mvc.demo.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;

@ControllerAdvice(basePackages = {"com.nexthoughts.spring.mvc.demo.web.controller"})
public class GlobalControllerAdvice {
//	@InitBinder
//	public void dataBinding(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		dateFormat.setLenient(false);
//		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
//	}

    @ModelAttribute
    public void globalAttributes(Model model) {
        model.addAttribute("msg", "Welcome to My World!");
    }


    //    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="IOException occured")
    @ExceptionHandler(FileNotFoundException.class)
    public ModelAndView myError(Exception exception) {
        ModelAndView mav = new ModelAndView();
        System.out.println("This is an exception");
        System.out.println(exception);
        mav.addObject("exception", exception);
        mav.setViewName("error");
        return mav;
    }
}
