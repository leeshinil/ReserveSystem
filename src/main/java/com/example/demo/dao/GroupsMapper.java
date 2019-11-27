package com.example.demo.dao;

import com.example.demo.dto.Groups;

public interface GroupsMapper {
    public Groups readGroupByName(String groupName);
}
