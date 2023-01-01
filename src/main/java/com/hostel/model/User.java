package com.hostel.model;

import java.io.Serializable;

public class User implements Serializable{
    
    //attributes
    private String email;
    private String password;
    
    //default constructor
    //public User(){
    //    email = "";
    //    password = "";
    //}
    
    //normal constructor
    //public User(String email, String password){
    //    this.email = email;
    //    this.password = password;
    //}
    
    //mutator @ setter
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    //accessor @ getter
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    
}
