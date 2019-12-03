package com.example.demo.service;

import com.example.demo.dao.MeetingRoomMapper;
import com.example.demo.dto.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

    @Autowired
    MeetingRoomMapper meetingRoomMapper;

    @Override
    public MeetingRoom readMeetingRoomByRoomname(String roomname) {
        return meetingRoomMapper.readMeetingRoomByRoomname(roomname);
    }
}
