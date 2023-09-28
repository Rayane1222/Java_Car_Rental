/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_car_rental.classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mac
 */
public class User {
    
    private int id;
    private String fullname ;
    private String username ;
    private String password ;
    private String user_type ;
    private byte[] picture ;
    private String phone ;
    private String email ;

    /*
    +Id:int
    +Fullname:string
    +Username:string
    +Password:string
    +User_type:string
    +Picture:byte
    +Phone:string
    +Email:string
    */
    
    public User() {
    }

    public User(int id, String fullname, String username, String password, String user_type, byte[] picture, String phone, String email) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        this.picture = picture;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

            public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    //create a function to add new user
    public void addUser(String fullname ,String username,String password,String user_type,byte[]img,String phone,String email){
        String insertQuery = "INSERT INTO 'users'('fullname','username','password','user_type','image','phone','email') VALUES (?,?,?,?,?,?,?)";
        
        PreparedStatement ps;
        try {
            
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, fullname);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setString(4, user_type);
            ps.setBytes(5, img);
            ps.setString(6, phone);
            ps.setString(7, email);
        
            if(ps.executeUpdate() != 0 ){
                JOptionPane.showMessageDialog(null , "The New user Has Been Added","ADD user ",1);
               
            }else{
                JOptionPane.showMessageDialog(null , "user Not Added","ADD user ",2);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //create a function to edit user 
    public void editUser (int _id ,String fullname ,String username,String password,String user_type,byte[]img,String phone,String email){
        String editQuery = "UPDATE `users` SET `fullname`=?, `username`=? , `password`=? , `user_type`=? , `image`=?, `phone`=?, `email`=? WHERE `id` = ?";

            PreparedStatement ps;
            try {
                ps = DB.getConnection().prepareStatement(editQuery);
                ps.setString(1, fullname);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setString(4, user_type);
                ps.setBytes(5, img);
                ps.setString(6, phone);
                ps.setString(7, email);
                ps.setInt(8, _id);

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null , "The user Has Been Edited","Edit user ",1);
                 //System.out.println("Locations Edited");
                } else {
                    JOptionPane.showMessageDialog(null , "user Not Edited","Edit user ",2);
                    //System.out.println("Locations Not Edited");
                }
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error: " + ex.getMessage()); // Print the error message
            }
    }
    
    //create a function to remove locationn 
    public void removeUser (int _id ){
        String deleteQuery = "DELETE FROM `users` WHERE `id`=?";
    
    PreparedStatement ps;
    try {
        ps = DB.getConnection().prepareStatement(deleteQuery);
        ps.setInt(1, _id); // Set the value of the first parameter to _id
    
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null , "The user Has Been removed","Delete user ",1);
            
        } else {
            JOptionPane.showMessageDialog(null , "user Not removed","Delete user ",2);
            
        }
    } catch (SQLException ex) {
        ex.printStackTrace();   
        Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    //create a function to return a result set 
    
    public ResultSet getData(String query)
    {
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            
            
            ps = DB.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    // create a function to get all Location and return  an arraylist
    
    public ArrayList<User> userList()
    {
        ArrayList<User> userList = new ArrayList<>();
        
        ResultSet rs= getData("SELECT * FROM `users`");
        
        try {
            while(rs.next())
            {
             
                User user =new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getBytes(6),rs.getString(7),rs.getString(8));
                userList.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }
    
     //cretae a function to get user by id 
    public User getUserById(int user_id)
    {
            String query = "SELECT * FROM `users` WHERE `id`=?";
            ResultSet rs = null;
            User user = null;

            try (PreparedStatement ps = DB.getConnection().prepareStatement(query)) {
                ps.setInt(1, user_id);
                rs = ps.executeQuery();

                if (rs.next()) {
                    user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getBytes(6),rs.getString(7),rs.getString(8));
                } else {
                    System.out.println("User not found for ID: " + user_id);
                }
            } catch (SQLException ex) {
                // Log the exception
                ex.printStackTrace();
                System.out.println("Error: " + ex.getMessage());
            } finally {
                // Close the ResultSet and PreparedStatement
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            return user;
    }
    
}
