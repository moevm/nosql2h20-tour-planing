package com.nosql2h20.tourplaning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping
    public String HelloWorld() {
        return "public/pages/homePage.html";
    }
}
