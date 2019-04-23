package com.sfguru.spring5webapp.controller;

import com.sfguru.spring5webapp.repositories.AuthorRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepo ar;

    public AuthorController(AuthorRepo ar) {
        this.ar = ar;
    }

    @RequestMapping("/authors")
    public String getAllAuthors(Model model){

        model.addAttribute("authors",ar.findAll());
        return "authors";
    }
}
