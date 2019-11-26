package com.example.demo.dto;

public class GroupMember {
    int idx;
    String fk_groupname;
    String fk_userid;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getFk_groupname() {
        return fk_groupname;
    }

    public void setFk_groupname(String fk_groupname) {
        this.fk_groupname = fk_groupname;
    }

    public String getFk_userid() {
        return fk_userid;
    }

    public void setFk_userid(String fk_userid) {
        this.fk_userid = fk_userid;
    }
}
