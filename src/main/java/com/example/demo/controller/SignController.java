package com.example.demo.controller;


import com.example.demo.dto.User;
import com.example.demo.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class SignController {
    @Autowired
    SignService signService;


    @RequestMapping("/signin")
    public String signin(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "sign/signin";
        } else {
            model.addAttribute("msg", "이미 로그인 되어있습니다.");
            model.addAttribute("url", "/home");
            return "redirect";
        }
    }

    @RequestMapping("/signinpost")
    public String signinpost(Model model, HttpSession session,
                             @RequestParam(value = "id", required = true) String id,
                             @RequestParam(value = "pw", required = true) String pw) {

        User user = signService.signin(id, pw); // users객체 호출


        if (user != null) {
            session.setAttribute("user", user); // user
            System.out.println("세션생성!!");
            return "redirect:/home";
        }

        return "sign/signin";
    }

    @RequestMapping("/signup")
    public String signup(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "sign/signup";
        } else {
            model.addAttribute("msg", "로그아웃 후, 회원가입을 해 주십시오.");
            model.addAttribute("url", "/home");
            return "redirect";
        }
    }


    @RequestMapping("/signuppost")
    public String signuppost(Model model,
                             @RequestParam(value = "id", required = true) String id,
                             @RequestParam(value = "pw", required = true) String pw,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "phone", required = true) String phone,
                             @RequestParam(value = "email", required = true) String email

    ) {



        User user = new User();
        user.setId(id);
        user.setPw(pw);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);

        System.out.println("siguppost");
        signService.registUser(user);

        return "sign/signin";
    }


}