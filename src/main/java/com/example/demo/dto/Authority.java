package com.example.demo.dto;

public class Authority {
    int idx;
    String fk_userid;
    String authority;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getFk_userid() {
        return fk_userid;
    }

    public void setFk_userid(String fk_userid) {
        this.fk_userid = fk_userid;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
