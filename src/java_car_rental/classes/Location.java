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
public class Location {
    
    private int id;
    private String city;
    private String address;

    public Location() { }
    
    public Location(int _id, String _city, String _address) {
        this.id = _id;
        this.city = _city;
        this.address = _address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //create a function to add new location
    public void addLocation(String _city , String _address){
        String insertQuery = "INSERT INTO 'locations'('city','location') VALUES (?,?)";
        
        PreparedStatement ps;
        try {
            
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, _city);
            ps.setString(2, _address);
        
            if(ps.executeUpdate() != 0 ){
                JOptionPane.showMessageDialog(null , "The New Location Has Been Added","ADD Location ",1);
               // System.out.println("Locations Added");
            }else{
                JOptionPane.showMessageDialog(null , "Location Not Added","ADD Location ",2);
                 //System.out.println("Locations Not Added");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //create a function to edit locationn 
    public void editLocation (int _id , String _city ,String _address){
        String editQuery = "UPDATE `locations` SET `city`=?, `location`=? WHERE `id` = ?";

            PreparedStatement ps;
            try {
                ps = DB.getConnection().prepareStatement(editQuery);
                ps.setString(1, _city);
                ps.setString(2, _address);
                ps.setInt(3, _id);

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null , "The Location Has Been Edited","Edit Location ",1);
                 //System.out.println("Locations Edited");
                } else {
                    JOptionPane.showMessageDialog(null , "Location Not Edited","Edit Location ",2);
                    //System.out.println("Locations Not Edited");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error: " + ex.getMessage()); // Print the error message
            }
    }
    
    //create a function to remove locationn 
    public void removeLocation (int _id ){
        String deleteQuery = "DELETE FROM `locations` WHERE `id`=?";
    
    PreparedStatement ps;
    try {
        ps = DB.getConnection().prepareStatement(deleteQuery);
        ps.setInt(1, _id); // Set the value of the first parameter to _id
    
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null , "The Location Has Been removed","Delete Location ",1);
            //System.out.println("Locations removed");
        } else {
            JOptionPane.showMessageDialog(null , "Location Not removed","Delete Location ",2);
            //System.out.println("Locations Not removed");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();   
        Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    // create a function to get all Location and return  an arraylist
    
    public ArrayList<Location> locationList()
    {
        ArrayList<Location> locationList = new ArrayList<>();
        
        ResultSet rs= getData("SELECT * FROM `locations`");
        
        try {
            while(rs.next())
            {
             
                Location location =new Location(rs.getInt(1),rs.getString(2),rs.getString(3));
                locationList.add(location);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locationList;
    }
    
     //cretae a function to get Location by id 
    public Location getBrandById(int location_id)
    {
            String query = "SELECT * FROM `locations` WHERE `id`=?";
            ResultSet rs = null;
            Location location = null;

            try (PreparedStatement ps = DB.getConnection().prepareStatement(query)) {
                ps.setInt(1, location_id);
                rs = ps.executeQuery();

                if (rs.next()) {
                    location = new Location(rs.getInt(1), rs.getString(2), rs.getString(3));
                } else {
                    System.out.println("Location not found for ID: " + location_id);
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

            return location;
    }
    
    
    // create a function to get all Location depending of the city param and return  an arraylist
    
    public ArrayList<Location> locationListByCity(String city)
    {
        ArrayList<Location> locList = new ArrayList<>();
        
        ResultSet rs = getData("SELECT * FROM `locations` WHERE `city` = '" + city + "'");
        
        try {
            while(rs.next())
            {
             
                Location location =new Location(rs.getInt(1),rs.getString(2),rs.getString(3));
                locList.add(location);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Location.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locList;
    }
    
}
