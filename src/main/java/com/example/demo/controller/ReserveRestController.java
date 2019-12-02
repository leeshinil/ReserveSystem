package com.example.demo.controller;

import com.example.demo.dto.Reserve;
import com.example.demo.service.ReserveService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@RestController
@RequestMapping("/reserveRest")
public class ReserveRestController{

    @Autowired
    ReserveService reserveService;

    @RequestMapping("/readReserveTable")
    public List<Reserve> readReserveTable (HttpSession session, @RequestBody String jsonData){
        System.out.println(jsonData);
        String date;
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj;
        try {
            jsonObj = (JSONObject) jsonParser.parse(jsonData);
            date = (String) jsonObj.get("date");
            System.out.println("date: "+date);
            List<Reserve> reserveList = reserveService.readReserveList(date);
            if(reserveList==null) {
                System.out.println("예약데이터가 없습니다.");
                return null;
            }else {
                return reserveList;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
