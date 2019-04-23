package com.sfguru.spring5webapp.controller;

import com.sfguru.spring5webapp.repositories.BookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepo br;

    public BookController(BookRepo br) {
        this.br = br;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", br.findAll());
        return "books";
    }
}
