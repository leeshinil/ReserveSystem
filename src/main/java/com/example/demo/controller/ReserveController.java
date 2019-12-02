package com.example.demo.controller;

import com.example.demo.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ReserveController {
    @Autowired
    ReserveService reserveService;

    @RequestMapping("/reservetable")
    public String reservetable(Model model, HttpSession session){

        return "reserve/reservetable";
    }
}
