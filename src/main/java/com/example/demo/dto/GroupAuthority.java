package com.example.demo.dto;

public class GroupAuthority {
    int idx;
    String fk_groupname;
    String authority;

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

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
