package com.nosql2h20.tourplaning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sample")
public class FrontController {

    @GetMapping
    public String GetHomePage() {
        return "public/pages/homePage.html";
    }
}
