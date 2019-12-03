package com.example.demo.service;

import com.example.demo.dto.Groups;

public interface GroupsService {
    public Groups readGroupByName(String groupName);
    public Groups readGroupByidx (int idx);
}
