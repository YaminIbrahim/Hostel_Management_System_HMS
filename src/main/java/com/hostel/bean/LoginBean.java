package com.hostel.bean;

import java.io.Serializable;

public class LoginBean implements Serializable{
    
    //attributes
    private String email;
    private String password;
    
    //mutator @ setter
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    //getter @ accessor
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
}
