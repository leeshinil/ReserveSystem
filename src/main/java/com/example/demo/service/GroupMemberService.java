package com.example.demo.service;

import com.example.demo.dto.GroupMember;

public interface GroupMemberService {
    public void createGroupMember(GroupMember groupMember);
    public GroupMember readGroupMember (String fk_userid);
}
