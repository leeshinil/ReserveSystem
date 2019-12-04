package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.MeetingRoomService;
import com.example.demo.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ReserveController {
    @Autowired
    ReserveService reserveService;
    @Autowired
    MeetingRoomService meetingRoomService;

    @RequestMapping("/reservetable")
    public String reservetable(Model model, HttpSession session){

        return "reserve/reservetable";
    }

    @RequestMapping("/reserve")
    public String reserve(Model model, HttpSession session){
        return "/reserve/reserve";
    }
    @RequestMapping("/reservedo")
    public String reservedo(Model model, HttpSession session,
                            @RequestParam(value = "title", required = true) String title,
                            @RequestParam(value = "roomname", required = true) String roomname,
                            @RequestParam(value = "date", required = true) String date,
                            @RequestParam(value = "start", required = true) String start,
                            @RequestParam(value = "end", required = true) String end,
                            @RequestParam(value = "content", required = true) String content){
        User user = (User) session.getAttribute("user");
        Authority authority = (Authority) session.getAttribute("authority");
        Groups groups = (Groups) session.getAttribute("group");

        if(user == null){
            return "redirect:/signin";
        }

        Reserve reserve = new Reserve();
        System.out.println("roomidx: "+meetingRoomService.readMeetingRoomByRoomname(roomname).getIdx());
        reserve.setFk_roomidx(meetingRoomService.readMeetingRoomByRoomname(roomname).getIdx());
        reserve.setDate(date);
        reserve.setStart(start);
        reserve.setFk_useridx(user.getUserIdx());
        reserve.setContent(content);
        reserve.setTitle(title);
        reserve.setRoomname(roomname);
        reserve.setCount(Integer.parseInt(end.split(":")[0])-Integer.parseInt(start.split(":")[0]));
        reserve.setUsername(user.getName());
        try {
            reserveService.createReserve(reserve);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/reservetable";
    }
}
