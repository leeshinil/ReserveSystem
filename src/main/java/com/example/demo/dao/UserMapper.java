package com.example.demo.dao;

import com.example.demo.dto.User;

public interface UserMapper {
    public User signin(String id, String pw);

    public User getUsersbyId(String id);

    public void registUser(User user);
}
