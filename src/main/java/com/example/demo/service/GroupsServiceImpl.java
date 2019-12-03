package com.example.demo.service;

import com.example.demo.dao.GroupsMapper;
import com.example.demo.dto.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupsServiceImpl implements GroupsService {

    @Autowired
    GroupsMapper groupMapper;

    @Override
    public Groups readGroupByName(String groupName) {
        return groupMapper.readGroupByName(groupName);
    }

    @Override
    public Groups readGroupByidx(int idx) {
        return groupMapper.readGroupByidx(idx);
    }
}
