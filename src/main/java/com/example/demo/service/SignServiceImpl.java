package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignServiceImpl implements SignService {

    @Autowired
    UserMapper usersDao;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    //signin
    @Override
    public User signin(String id, String pw) {
        User tmpUser = getUsersbyId(id);
        if(tmpUser == null)
            return null;
        String encodedPassword =tmpUser.getPw();
        if (passwordEncoder.matches(pw,encodedPassword))
            return usersDao.signin(id, encodedPassword);
        else
            return null;
    }

    //signup
    @Override
    public User getUsersbyId(String id) {
        return usersDao.getUsersbyId(id);
    }

    @Override
    public void registUser(User user) {
        String rawPassword = user.getPw();

        System.out.println("@@@@@@@@@@@" + user.getPw());

        String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        user.setPw(encodedPassword);
        System.out.println("!!!!!!!!!" + user.getPw());
        try {
            usersDao.registUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
