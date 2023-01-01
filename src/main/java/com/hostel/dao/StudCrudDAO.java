package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.hostel.bean.StudCrudBean;

//this DAO class provide CRUD database operation for the student table in the database
public class StudCrudDAO {
    
    private String dbURL = "jdbc:mysql://localhost:3306/hostel";
    private String dbUsername = "root";
    private String dbPassword = "1234";
    
    //studID, studUserName, studEmail, studPassword, studFirstName, studLastName, studAddress, studPhoneNum, studRoomNum, studCheckIn, studCheckOut, studRoomType, regisID
    
    private static final String insert = "INSERT INTO student (studEmail, studFirstName, studLastName, studAddress, studPhoneNum, studRoomNum, studCheckIn, studCheckOut, studRoomType) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private static final String selectID = "SELECT studID, studEmail, studFirstName, studLastName, studAddress, studPhoneNum, studRoomNum, studCheckIn, studCheckOut, studRoomType FROM student WHERE studID = ?";
    private static final String selectAll = "SELECT studID, studEmail, studFirstName, studLastName, studAddress, studPhoneNum, studRoomNum, studCheckIn, studCheckOut, studRoomType FROM student";
    private static final String delete = "DELETE FROM student WHERE studID = ?;";
    private static final String update = "UPDATE student SET studEmail=?, studFirstName=?, studLastName=?, studAddress=?, studPhoneNum=?, studRoomNum?, studCheckIn=?, studCheckOut=?, studRoomType=? WHERE studID=?;";
    
    public StudCrudDAO(){
        
    }
    
    //get connection
    protected Connection getConnection() {
        
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        }catch(SQLException | ClassNotFoundException sqle) {
            System.out.println(sqle.getMessage());
        }
        //close catch
        //close catch
        
        return connection;
    }//close getConnection
    
    //create or insert student
    public void insertStudent(StudCrudBean stud) throws SQLException{
        try(Connection connection = getConnection(); 
            
            PreparedStatement preparedStatement = connection.prepareStatement(insert)){
            
            //preparedStatement.setString(1, stud.getUsername());
            preparedStatement.setString(2, stud.getEmail());
            preparedStatement.setString(3, stud.getFname());
            preparedStatement.setString(4, stud.getLname());
            preparedStatement.setString(5, stud.getAddress());
            preparedStatement.setString(6, stud.getPhoneNum());
            preparedStatement.setString(7, stud.getPhoneNum());
            preparedStatement.setString(8, stud.getPhoneNum());
            preparedStatement.setString(9, stud.getCheckIn());
            preparedStatement.setString(10, stud.getCheckOut());
            
            preparedStatement.executeUpdate();
            
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }//close catch
    }//close insertStudent
    
    //update student record
    public boolean updateStudent(StudCrudBean stud) throws SQLException {
        
        boolean rowUpdated;
        
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(update);) {
            //statement.setString(1, stud.getUsername());
            statement.setString(2, stud.getEmail());
            statement.setString(3, stud.getFname());
            statement.setString(4, stud.getLname());
            statement.setString(5, stud.getAddress());
            statement.setString(6, stud.getPhoneNum());
            statement.setString(7, stud.getPhoneNum());
            statement.setString(8, stud.getPhoneNum());
            statement.setString(9, stud.getCheckIn());
            statement.setString(10, stud.getCheckOut());
            
            statement.setInt(11, stud.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }//close updateStudent
    
    //select student by id
    public StudCrudBean selectStudent(int id) {
            
        StudCrudBean stud = null;
        
        //Establishing a Connection
        try (Connection connection = getConnection();
            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(selectID);) {
            preparedStatement.setInt(1, id);
            
            //Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            
            //Process the ResultSet object.
            while (rs.next()) {
                
                //String username = rs.getString("studUserName");
                String email = rs.getString("studEmail");
                String fname = rs.getString("studFirstName");
                String lname = rs.getString("studLastName");
                String address = rs.getString("studAddress");
                String phoneNum = rs.getString("studPhoneNum");
                String roomNum = rs.getString("studRoomNum");
                String checkIn = rs.getString("studCheckIn");
                String checkOut = rs.getString("studCheckOut");
                String roomType = rs.getString("studRoomType");
                
                stud = new StudCrudBean (id, email, fname, lname, address, phoneNum, roomNum, checkIn, checkOut, roomType);
                
            }//close while
            
        }catch(SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return stud;
    }//close selectStudent
    
    //select all student
    public List < StudCrudBean > selectAllStudent() {
        
        List < StudCrudBean > allStud = new ArrayList < > ();
        
        // Establishing a Connection
        try (Connection connection = getConnection();

            //Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(selectAll);) {
            
            //Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            //Process the ResultSet object.
            while (rs.next()) {
                
                int id = rs.getInt("studID");
                //String username = rs.getString("studUserName");
                String email = rs.getString("studEmail");
                String fname = rs.getString("studFirstName");
                String lname = rs.getString("studLastName");
                String address = rs.getString("studAddress");
                String phoneNum = rs.getString("studPhoneNum");
                String roomNum = rs.getString("studRoomNum");
                String checkIn = rs.getString("studCheckIn");
                String checkOut = rs.getString("studCheckOut");
                String roomType = rs.getString("studRoomType");
                
                allStud.add(new StudCrudBean(id, email, fname, lname, address, phoneNum, roomNum, checkIn, checkOut, roomType));
                
            }//close while
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return allStud;
    }//close selectAllUsers
    
    //delete student record
    public boolean deleteStud(int id) throws SQLException {
        
        boolean rowDeleted;
        
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(delete);) {
            
            statement.setInt(1, id);
            
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }//close deleteStud
    
}//close class
