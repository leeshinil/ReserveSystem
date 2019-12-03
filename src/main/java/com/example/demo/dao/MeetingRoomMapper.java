package com.example.demo.dao;

import com.example.demo.dto.MeetingRoom;

public interface MeetingRoomMapper {
    public MeetingRoom readMeetingRoomByRoomname(String roomname);
}
