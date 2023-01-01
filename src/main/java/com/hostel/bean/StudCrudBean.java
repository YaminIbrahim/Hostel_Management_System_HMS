package com.hostel.bean;

import java.io.Serializable;

public class StudCrudBean implements Serializable{
    
    //attributes
    //studID, studUserName, studEmail, studFirstName, studLastName, studAddress, studPhoneNum, studRoomNum, studCheckIn, studCheckOut, studRoomType
    private int id;
    private String email;
    private String fname;
    private String lname;
    private String address;
    private String phoneNum;
    private String roomNum;
    private String checkIn;
    private String checkOut;
    private String roomType;
    
    public StudCrudBean(int id, String email, String fname, String lname, String address, String phoneNum, String roomNum, String checkIn, String checkOut, String roomType) {
        this.id = id;
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phoneNum = phoneNum;
        this.roomNum = roomNum;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
    }

    public StudCrudBean(String email, String fname, String lname, String address, String phoneNum, String roomNum, String checkIn, String checkOut, String roomType) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.phoneNum = phoneNum;
        this.roomNum = roomNum;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomType = roomType;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
}
