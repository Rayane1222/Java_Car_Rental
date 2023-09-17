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
public class Booking {
    
    int id;
    int car_id;
    int customer_id;
    String pickup_city ;
    String pickup_address;
    String pickup_date ;
    String pickup_time ;
    String dropoff_city ;
    String dropoff_address;
    String dropoff_date ;
    String dropoff_time ;
    int total_price ;

    public Booking() {
    }

    public Booking(int id, int car_id, int customer_id, String pickup_city, String pickup_address, String pickup_date, String pickup_time, String dropoff_city, String dropoff_address, String dropoff_date, String dropoff_time, int total_price) {
        this.id = id;
        this.car_id = car_id;
        this.customer_id = customer_id;
        this.pickup_city = pickup_city;
        this.pickup_address = pickup_address;
        this.pickup_date = pickup_date;
        this.pickup_time = pickup_time;
        this.dropoff_city = dropoff_city;
        this.dropoff_address = dropoff_address;
        this.dropoff_date = dropoff_date;
        this.dropoff_time = dropoff_time;
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getPickup_city() {
        return pickup_city;
    }

    public void setPickup_city(String pickup_city) {
        this.pickup_city = pickup_city;
    }

    public String getPickup_address() {
        return pickup_address;
    }

    public void setPickup_address(String pickup_address) {
        this.pickup_address = pickup_address;
    }

    public String getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(String pickup_date) {
        this.pickup_date = pickup_date;
    }

    public String getPickup_time() {
        return pickup_time;
    }

    public void setPickup_time(String pickup_time) {
        this.pickup_time = pickup_time;
    }

    public String getDropoff_city() {
        return dropoff_city;
    }

    public void setDropoff_city(String dropoff_city) {
        this.dropoff_city = dropoff_city;
    }

    public String getDropoff_address() {
        return dropoff_address;
    }

    public void setDropoff_address(String dropoff_address) {
        this.dropoff_address = dropoff_address;
    }

    public String getDropoff_date() {
        return dropoff_date;
    }

    public void setDropoff_date(String dropoff_date) {
        this.dropoff_date = dropoff_date;
    }

    public String getDropoff_time() {
        return dropoff_time;
    }

    public void setDropoff_time(String dropoff_time) {
        this.dropoff_time = dropoff_time;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    
    
    
    //create a function to add new car
    public void addNewBooking(int _car_id,int _customer_id , String _pickup_city ,String _pickup_address ,String _pickup_date ,String _pickup_time ,
            String _dropoff_city ,String _dropoff_address,String _dropoff_date ,String _dropoff_time ,int _total_price)
    {
        String insertQuery = "INSERT INTO `reservation`(`car_id`,`customer_id`,`pickup_city`,`pickup_address`,`pickup_date`,`pickup_time`,`dropoff_city`,"
            + "`dropoff_address`,`dropoff_date`,`dropoff_time`,`total_price`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement ps;
        try {
            
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setInt(1, _car_id);
            ps.setInt(2, _customer_id);
            ps.setString(3, _pickup_city);
            ps.setString(4, _pickup_address);
            ps.setString(5, _pickup_date);
            ps.setString(6, _pickup_time);
            ps.setString(7, _dropoff_city);
            ps.setString(8, _dropoff_address);
            ps.setString(9, _dropoff_date);
            ps.setString(10, _dropoff_time);
            ps.setInt(11, _total_price);
            
            
            
            
            if(ps.executeUpdate() != 0 ){
                JOptionPane.showMessageDialog(null , "The New Reservation Has Been Added","ADD Reservation ",1);
               
            }else{
                JOptionPane.showMessageDialog(null , "Reservation Not Added","ADD Reservation ",2);
                 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred while adding the reservation", "Error", 2);
        }
        
        
    }
    
    //create a function to add new car
    public void editBooking(int _id,int _car_id,int _customer_id , String _pickup_city ,String _pickup_address ,String _pickup_date ,String _pickup_time ,
            String _dropoff_city ,String _dropoff_address,String _dropoff_date ,String _dropoff_time ,int _total_price)
    {
        String editQuery = "UPDATE `reservation` SET `car_id`=?,`customer_id`=?,`pickup_city`=?,`pickup_address`=?,`pickup_date`=?,`pickup_time`=?,`dropoff_city`=?,"
            + "`dropoff_address`=?,`dropoff_date`=?,`dropoff_time`=?,`total_price`=? WHERE `id`=?";
        
        PreparedStatement ps;
        try {
            
            ps = DB.getConnection().prepareStatement(editQuery);
            ps.setInt(1, _car_id);
            ps.setInt(2, _customer_id);
            ps.setString(3, _pickup_city);
            ps.setString(4, _pickup_address);
            ps.setString(5, _pickup_date);
            ps.setString(6, _pickup_time);
            ps.setString(7, _dropoff_city);
            ps.setString(8, _dropoff_address);
            ps.setString(9, _dropoff_date);
            ps.setString(10, _dropoff_time);
            ps.setInt(11, _total_price);
            ps.setInt(12, _id);
            
            
            
            
            if(ps.executeUpdate() != 0 ){
                JOptionPane.showMessageDialog(null , "Edited","Edit Reservation ",1);
               
            }else{
                JOptionPane.showMessageDialog(null , "Not Edited","Edit Reservation ",2);
                 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "An error occurred while adding the reservation", "Error", 2);
        }
        
    }
    
            // create a function to remove a booking/reservation
            public void removeBooking(int _id) {
            String deleteQuery = "DELETE FROM `reservation` WHERE `id`=?";

            PreparedStatement ps;
            try {
                ps = DB.getConnection().prepareStatement(deleteQuery);
                ps.setInt(1, _id); // Set the value of the first parameter to _id

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null , "The Reservation Has Been removed","Delete Reservation ",1);

                } else {
                    JOptionPane.showMessageDialog(null , "Reservation Not removed","Delete Reservation ",2);

                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();   
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    // create a function to get all brands and return  an arraylist
    
    public ArrayList<Booking> BookingList()
    {
        ArrayList<Booking> bokList = new ArrayList<>();
        
        ResultSet rs= getData("SELECT * FROM `reservation`");
        
        try {
            while(rs.next())
            {
             
                Booking booking =new Booking(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
                        rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getInt(12));
                bokList.add(booking);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bokList;
    }
    
}
