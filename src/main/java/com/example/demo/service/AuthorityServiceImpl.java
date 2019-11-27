package com.example.demo.service;

import com.example.demo.dao.AuthorityMapper;
import com.example.demo.dto.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    AuthorityMapper authorityMapper;

    @Override
    public void createAuthority(Authority authority) {
        authorityMapper.createAuthority(authority);
    }
}
