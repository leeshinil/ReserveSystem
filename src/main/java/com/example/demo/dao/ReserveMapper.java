package com.example.demo.dao;

import com.example.demo.dto.Reserve;

import java.util.List;

public interface ReserveMapper {
    public List<Reserve> readReserveList(String date);
}
