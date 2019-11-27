package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SignService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RestController
@RequestMapping("/signRest")
public class SignRestController {
    @Autowired
    SignService signService;


    String success = " {\"result\":\"success\"} "; // 성공시 string 반환 값
    String fail = " {\"result\":\"fail\"} ";

    @RequestMapping("/signin")
    @PostMapping
    public String getSigninCheck(@RequestBody String signData) {
        System.out.println("signData : " + signData);
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj;

        String id;
        String pw;
        try {
            jsonObj = (JSONObject) jsonParser.parse(signData);
            id = (String) jsonObj.get("id");
            pw = (String) jsonObj.get("pw");

            if (signService.signin(id, pw) != null) {
                return success;
            }
            return fail;

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fail;
    }


    @RequestMapping("/signup_id")
    @PostMapping
    public String stu_noCheck(@RequestBody String idjson) {
        JSONParser jsonParser = new JSONParser();
        System.out.println(idjson);
        JSONObject jsonObj;
        String id;
        try {
            jsonObj = (JSONObject) jsonParser.parse(idjson);
            id = String.valueOf(jsonObj.get("id"));
            System.out.println(id);
            if(signService.getUsersbyId(id)!= null) {
                return fail;
            }
            return success;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fail;
    }

}