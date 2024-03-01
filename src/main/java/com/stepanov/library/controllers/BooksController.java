package com.stepanov.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {

    @GetMapping()
    public String showAllBooks() {
        return null;
    }

    @GetMapping("/{id}")
    public String showBook() {
        return null;
    }

    @GetMapping("/new")
    public String newBook() {
        return null;
    }
}
