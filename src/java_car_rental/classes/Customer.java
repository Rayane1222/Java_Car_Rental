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
public class Customer {
    
    private int id;
    private String fullname ; 
    private String birthdate ;
    private String phone ;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(int id, String fullname, String birthdate, String phone, String email, String address) {
        this.id = id;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.phone = phone;
        this.email = email;
        this.address = address;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //create a function to add new location
    public void addCustomer(String fullname , String birthdate ,String phone,String email,String address){
        String insertQuery = "INSERT INTO 'Customer'('fullname','birth_date','phone','email','address') VALUES (?,?,?,?,?)";
        
        PreparedStatement ps;
        try {
            
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, fullname);
            ps.setString(2, birthdate);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, address);
        
            if(ps.executeUpdate() != 0 ){
                JOptionPane.showMessageDialog(null , "The New Customer Has Been Added","ADD Customer ",1);
               
            }else{
                JOptionPane.showMessageDialog(null , "Customer Not Added","ADD Customer ",2);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //create a function to edit locationn 
    public void editCustomer (int _id ,String fullname , String birthdate ,String phone,String email,String address){
        String editQuery = "UPDATE `Customer` SET `fullname`=?, `birth_date`=? , `phone`=? , `email`=? , `address`=? WHERE `id` = ?";

            PreparedStatement ps;
            try {
                ps = DB.getConnection().prepareStatement(editQuery);
                ps.setString(1, fullname);
                ps.setString(2, birthdate);
                ps.setString(3, phone);
                ps.setString(4, email);
                ps.setString(5, address);
                ps.setInt(6, _id);

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null , "The Customer Has Been Edited","Edit Customer ",1);
                 //System.out.println("Locations Edited");
                } else {
                    JOptionPane.showMessageDialog(null , "Customer Not Edited","Edit Customer ",2);
                    //System.out.println("Locations Not Edited");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error: " + ex.getMessage()); // Print the error message
            }
    }
    
    //create a function to remove locationn 
    public void removeCustomer (int _id ){
        String deleteQuery = "DELETE FROM `Customer` WHERE `id`=?";
    
    PreparedStatement ps;
    try {
        ps = DB.getConnection().prepareStatement(deleteQuery);
        ps.setInt(1, _id); // Set the value of the first parameter to _id
    
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null , "The Customer Has Been removed","Delete Customer ",1);
            //System.out.println("Locations removed");
        } else {
            JOptionPane.showMessageDialog(null , "Customer Not removed","Delete Customer ",2);
            //System.out.println("Locations Not removed");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();   
        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    // create a function to get all Location and return  an arraylist
    
    public ArrayList<Customer> CustomerList()
    {
        ArrayList<Customer> customerList = new ArrayList<>();
        
        ResultSet rs= getData("SELECT * FROM `Customer`");
        
        try {
            while(rs.next())
            {
             
                Customer customer =new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6));
                customerList.add(customer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerList;
    }
    
    
    //cretae a function to get Customer by id 
    public Customer getCustomerById(int customer_id)
    {
            String query = "SELECT * FROM `Customer` WHERE `id`=?";
            ResultSet rs = null;
            Customer customer = null;

            try (PreparedStatement ps = DB.getConnection().prepareStatement(query)) {
                ps.setInt(1, customer_id);
                rs = ps.executeQuery();

                if (rs.next()) {
                    customer = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6));
                } else {
                    System.out.println("Customer not found for ID: " + customer_id);
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

            return customer;
    }
    
}
