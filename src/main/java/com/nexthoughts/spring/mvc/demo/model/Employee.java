package com.nexthoughts.spring.mvc.demo.model;

/**
 * Created by chetan on 10/4/18.
 */
public class Employee {

    private long id;
    private String name;

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // standard getters and setters removed
}
