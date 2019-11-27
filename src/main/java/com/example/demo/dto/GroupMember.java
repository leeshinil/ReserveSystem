package com.example.demo.dto;

public class GroupMember {
    int idx;
    int fk_groupidx;
    String fk_userid;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getFk_groupidx() {
        return fk_groupidx;
    }

    public void setFk_groupidx(int fk_groupidx) {
        this.fk_groupidx = fk_groupidx;
    }

    public String getFk_userid() {
        return fk_userid;
    }

    public void setFk_userid(String fk_userid) {
        this.fk_userid = fk_userid;
    }
}
