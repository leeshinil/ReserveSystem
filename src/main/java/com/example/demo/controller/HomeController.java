package com.example.demo.controller;

import org.apache.maven.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model, HttpSession session ){
        return "home";
    }



}