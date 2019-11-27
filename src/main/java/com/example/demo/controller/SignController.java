package com.example.demo.controller;


import com.example.demo.dto.Authority;
import com.example.demo.dto.GroupMember;
import com.example.demo.dto.User;
import com.example.demo.service.AuthorityService;
import com.example.demo.service.GroupMemberService;
import com.example.demo.service.GroupsService;
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
    GroupsService groupsService;
    @Autowired
    GroupMemberService groupMemberService;
    @Autowired
    AuthorityService authorityService;
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
                             @RequestParam(value = "email", required = true) String email,
                             @RequestParam(value = "authority", required = true)String auth,
                             @RequestParam(value = "group", required = true)String group
    ) {
        System.out.println("a" +auth);
        System.out.println("g"+ group);
        User user = new User();
        user.setId(id);
        user.setPw(pw);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        signService.creatUser(user);

        Authority authority = new Authority();
        authority.setFk_userid(id);
        authority.setAuthority(auth);
        authorityService.createAuthority(authority);

        GroupMember groupMember = new GroupMember();
        groupMember.setFk_userid(id);
        System.out.println("here : " + groupsService.readGroupByName(group).getIdx());
        groupMember.setFk_groupidx(groupsService.readGroupByName(group).getIdx());
        System.out.println(groupMember.getFk_groupidx());
        groupMemberService.createGroupMember(groupMember);

        return "sign/signin";
    }
}