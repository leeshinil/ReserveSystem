package com.example.demo.controller;

import org.apache.maven.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class MenuController {
    @RequestMapping("/menu")
    public String home(Model model, HttpSession session ){
        return "menu";
    }

}
