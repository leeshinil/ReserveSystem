package com.example.demo.dao;

import com.example.demo.dto.Authority;

public interface AuthorityMapper {
    public void createAuthority(Authority authority);
    public Authority readAuthority(String fk_userid);
}
