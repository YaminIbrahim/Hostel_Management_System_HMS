package com.hostel.model;

//to recreate object into its original state
//convert object to stream of bytes for easy shipment of information
//saves the state of the object for recreation without having to reprocess them in different platform 
//integration between JVM
import java.io.Serializable;

//Provides the API for accessing and processing data stored in a data source
//This API includes a framework whereby different drivers can be installed dynamically to access different data sources.
import java.sql.*;

public class DBConnection implements Serializable{
    
    //attributes
    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbURL = "jdbc:mysql://localhost:3306/hostel";
    private String dbUsername = "root";
    private String dbPassword = "1234";
    Connection con = null;
    Statement statement = null;
    
    //constructor
    public DBConnection (String dbUsername, String dbPassword){
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
    }
    
    //create connection
    public void connect() throws SQLException, Exception{
        
        Class.forName(dbDriver);
        
        con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        statement = con.createStatement();
    }
    
    //get connection result
    public String connectionResult(){
        if(con != null){
            return "Database successfully connected!";
        }
        else{
            return "Database failed to connect";
        }
    }
    
    //close connection
    public void closeConnection() throws SQLException, Exception{
        statement.close();
        con.close();
    }
    
    //getter
    public Statement getStatement(){
        return statement;
    }
    public Connection getConnection(){
        return con;
    }
}//close class DBConnection
