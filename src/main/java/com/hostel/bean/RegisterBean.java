package com.hostel.bean;

import java.io.Serializable;

public class RegisterBean implements Serializable {
    
    //attributes
    private String username;
    private String email;
    private String password;
    
    //bean does not have constructor
    
    //mutator @ setter
    public void setUsername(String username){
        this.username = username;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    //setter @ accessor
    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    
}
