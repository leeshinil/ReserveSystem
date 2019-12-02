package com.example.demo.dto;

public class Reserve {
    int idx;
    int fk_roomidx;
    String date;
    String start;
    int fk_useridx;
    boolean confirm;
    String content;
    String title;
    String roomname;
    String username;
    int count;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getFk_roomidx() {
        return fk_roomidx;
    }

    public void setFk_roomidx(int fk_roomidx) {
        this.fk_roomidx = fk_roomidx;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getFk_useridx() {
        return fk_useridx;
    }

    public void setFk_useridx(int fk_useridx) {
        this.fk_useridx = fk_useridx;
    }

    public boolean isConfirm() {
        return confirm;
    }

    public void setConfirm(boolean confirm) {
        this.confirm = confirm;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
