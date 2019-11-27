package com.example.demo.service;

import com.example.demo.dao.GroupMemberMapper;
import com.example.demo.dto.GroupMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupMemberServiceImpl implements GroupMemberService {

    @Autowired
    GroupMemberMapper groupMemberMapper;

    @Override
    public void createGroupMember(GroupMember groupMember) {
        groupMemberMapper.createGroupMember(groupMember);
    }
}
