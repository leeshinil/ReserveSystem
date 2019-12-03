package com.example.demo.service;

import com.example.demo.dao.ReserveMapper;
import com.example.demo.dto.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService{
    @Autowired
    ReserveMapper reserveMapper;

    @Override
    public List<Reserve> readReserveList(String date, String roomName) {
        return reserveMapper.readReserveList(date, roomName);
    }

    @Override
    public void createReserve(Reserve reserve) {
        reserveMapper.createReserve(reserve);
    }

}
