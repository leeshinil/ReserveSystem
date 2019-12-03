package com.example.demo.dao;

import com.example.demo.dto.GroupMember;

public interface GroupMemberMapper {
    public void createGroupMember(GroupMember groupMember);
    public GroupMember readGroupMember (String fk_userid);
}
