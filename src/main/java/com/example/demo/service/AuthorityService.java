package com.example.demo.service;


import com.example.demo.dto.Authority;

public interface AuthorityService {
    public void createAuthority (Authority authority);
    public Authority readAuthority(String fk_userid);
}
