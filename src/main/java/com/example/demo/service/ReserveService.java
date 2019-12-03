package com.example.demo.service;

import com.example.demo.dao.ReserveMapper;
import com.example.demo.dto.Reserve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReserveService {

    public List<Reserve> readReserveList (String date, String roomName);
    public void createReserve(Reserve reserve);
}
