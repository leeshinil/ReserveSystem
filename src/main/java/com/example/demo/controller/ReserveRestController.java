package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.MeetingRoomService;
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
public class ReserveRestController {

    String success = " {\"result\":\"success\"} "; // 성공시 string 반환 값
    String fail = " {\"result\":\"fail\"} ";

    @Autowired
    ReserveService reserveService;
    @Autowired
    MeetingRoomService meetingRoomService;

    @RequestMapping("/readReserveTable")
    public List<Reserve> readReserveTable(HttpSession session, @RequestBody String jsonData) {
        Authority authority = (Authority) session.getAttribute("authority");
        Groups groups = (Groups) session.getAttribute("group");

        System.out.println(jsonData);
        String date;
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj;
        try {
            jsonObj = (JSONObject) jsonParser.parse(jsonData);
            date = (String) jsonObj.get("date");
            System.out.println("date: " + date);
            List<Reserve> reserveList;
            if(authority.getAuthority().equals("bon")){
                reserveList = reserveService.readReserveList(date,"A회의실");
                reserveList.addAll(reserveService.readReserveList(date,"B회의실"));
            }else {
                System.out.println("그룹:"+groups.getGroupname());
                reserveList = reserveService.readReserveList(date,groups.getGroupname()+"회의실");
            }
            if (reserveList == null) {
                System.out.println("예약데이터가 없습니다.");
                return null;
            } else {
                return reserveList;
            }
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/reserveCheck")
    public String reserveCheck(HttpSession session, Model model, @RequestBody String jsonData) {
        String date;
        String start;
        String end;
        String roomName;

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj;
        try {
            jsonObj = (JSONObject) jsonParser.parse(jsonData);
            date = (String) jsonObj.get("date");
            start = (String) jsonObj.get("start");
            end = (String) jsonObj.get("end");
            roomName = (String) jsonObj.get("roomname");
            List<Reserve> reserveList = reserveService.readReserveList(date, roomName);
            boolean timecheck[] = {false, false, false, false, false, false, false, false, false, false};
            for (Reserve reserve : reserveList) {
                int bufStart = Integer.parseInt(reserve.getStart().split(":")[0]);
                System.out.println("버퍼 스타트 : "+bufStart+" getcount :"+reserve.getCount());
                for (int i = bufStart - 8; i < (reserve.getCount()+bufStart-8); i++) {
                    timecheck[i] = true;
                }
            }

            for(int i=0; i<10 ; i++){
                System.out.println("time["+i+"]= "+timecheck[i]);
            }
            int startInt = Integer.parseInt(start.split(":")[0]);
            int count = Integer.parseInt(end.split(":")[0]) - Integer.parseInt(start.split(":")[0]);
            for (int i = startInt - 8; i < count; i++) {
                if (timecheck[i] == true) {
                    return fail;
                }
            }
            return success;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return fail;
    }
}
