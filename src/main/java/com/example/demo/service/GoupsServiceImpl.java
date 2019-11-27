package com.example.demo.service;

import com.example.demo.dao.GroupsMapper;
import com.example.demo.dto.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoupsServiceImpl implements GroupsService {

    @Autowired
    GroupsMapper groupMapper;

    @Override
    public Groups readGroupByName(String groupName) {
        return groupMapper.readGroupByName(groupName);
    }
}
