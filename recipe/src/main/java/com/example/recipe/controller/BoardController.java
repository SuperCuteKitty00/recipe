package com.example.recipe.controller;


import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public void list(Locale locale, Model model) {

    }
}
