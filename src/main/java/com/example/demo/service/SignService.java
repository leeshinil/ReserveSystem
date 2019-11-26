package com.example.demo.service;

import com.example.demo.dto.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface SignService {
    //signup
    public User getUsersbyId(String id);

    public void registUser(User user);

    //signin
    public User signin(String id, String pw);



}
