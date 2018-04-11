package com.nexthoughts.spring.mvc.demo.web.controller;

import com.nexthoughts.spring.mvc.demo.model.Employee;
import com.nexthoughts.spring.mvc.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chetan on 10/4/18.
 */
@Controller
//@ControllerAdvice
@RequestMapping(value = "/employee")
public class EmployeeController {

    private Map<Long, Employee> employeeMap = new HashMap<>();

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(
            @ModelAttribute("employee") Employee employee,
            BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", employee.getName());
        model.addAttribute("id", employee.getId());

        employeeMap.put(employee.getId(), employee);

        return "employeeView";
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public ModelAndView user() {
        return new ModelAndView("user", "user", new User());
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String createUser(@ModelAttribute("user") User user, BindingResult result, ModelMap model)
            throws FileNotFoundException {
        if (result.hasErrors()) {
            return "user";
        }
        if (user.getName().equals("exception")) {
            throw new FileNotFoundException("Error found.");
        }
        System.out.println("Name:" + user.getName());
        System.out.println("Date of Birth:" + user.getDob());
        return "success";
    }



    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }
}
