package com.stepanov.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @GetMapping()
    public String showAllPeople() {
        return null;
    }

    @GetMapping("/{id}")
    public String showPerson() {
        return null;
    }

    @GetMapping("/new")
    public String newPerson() {
        return null;
    }



}
