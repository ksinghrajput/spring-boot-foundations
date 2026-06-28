package com.codewithkishan.onlinestore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/")
    public String index(){

        String viewName = getViewName();
        System.out.println(viewName);
        return viewName;
    }

    private String getViewName(){
        System.out.println(appName);
        return "index.html";
    }

}
