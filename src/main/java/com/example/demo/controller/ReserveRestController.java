package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/signRest")
public class ReserveRestController{

    @RequestMapping("/readReserveTable")
    public String readReserveTable (HttpSession session, @RequestBody String date){

        return "" ;
    }
}
