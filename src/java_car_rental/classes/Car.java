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
public class Car {
    
    private int id;
    private int brand;
    private String model;
    private String fuel;
    private String color;
    private String _class_;
    private int passengers;
    private String gearbox;
    private int price;
     //car features
    private String air_cond;
    private String airbag;
    private String sunroof;
    private String heated_seats;
    private String nav_sys;
    private String bluetooth;
    private String elec_window;
    private String gps;

    public Car() {
    }

    public Car(int id, int brand, String model, String fuel, String color, String _class_, int passengers, String gearbox, int price, String air_cond, String airbag, String sunroof, String heated_seats, String nav_sys, String bluetooth, String elec_window, String gps) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
        this.color = color;
        this._class_ = _class_;
        this.passengers = passengers;
        this.gearbox = gearbox;
        this.price = price;
        this.air_cond = air_cond;
        this.airbag = airbag;
        this.sunroof = sunroof;
        this.heated_seats = heated_seats;
        this.nav_sys = nav_sys;
        this.bluetooth = bluetooth;
        this.elec_window = elec_window;
        this.gps = gps;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClass_() {
        return _class_;
    }

    public void setClass_(String _class_) {
        this._class_ = _class_;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAir_cond() {
        return air_cond;
    }

    public void setAir_cond(String air_cond) {
        this.air_cond = air_cond;
    }

    public String getAirbag() {
        return airbag;
    }

    public void setAirbag(String airbag) {
        this.airbag = airbag;
    }

    public String getSunroof() {
        return sunroof;
    }

    public void setSunroof(String sunroof) {
        this.sunroof = sunroof;
    }

    public String getHeated_seats() {
        return heated_seats;
    }

    public void setHeated_seats(String heated_seats) {
        this.heated_seats = heated_seats;
    }

    public String getNav_sys() {
        return nav_sys;
    }

    public void setNav_sys(String nav_sys) {
        this.nav_sys = nav_sys;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getElec_window() {
        return elec_window;
    }

    public void setElec_window(String elec_window) {
        this.elec_window = elec_window;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
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
            Logger.getLogger(brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    // create a function to get all cars and return  an arraylist
    
    public ArrayList<Car> carsList()
    {
        ArrayList<Car> carList = new ArrayList<>();
        
        ResultSet rs= getData("SELECT * FROM `cars`");
        
        try {
            while(rs.next())
            {
             
                Car car =new Car(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),
                        rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),
                        rs.getString(15),rs.getString(16),rs.getString(17));
                carList.add(car);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carList;
    }
    
    //create a function to add new car
    public void addCar( int _brand, String _model, String _fuel, String _color, String _class, int _passengers, String _gearbox, int _price, String _air_cond,
                        String _airbag, String _sunroof, String _heated_seats, String _nav_sys, String _bluetooth, String _elec_window, String _gps)
    {
        String insertQuery = "INSERT INTO 'cars'('brand','model','fuel','color','class','passengers','gearbox','price','air_conditioning','airbags','sunroof','heated_seats','navigation_sytems','Bluetooth','elecric_windows','GPS') VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement ps;
        try {
            
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setInt(1, _brand);
            ps.setString(2, _model);
            ps.setString(3, _fuel);
            ps.setString(4, _color);
            ps.setString(5, _class);
            ps.setInt(6, _passengers);
            ps.setString(7, _gearbox);
            ps.setInt(8, _price);
             //car features 
            ps.setString(9, _air_cond);
            ps.setString(10, _airbag);
            ps.setString(11, _sunroof);
            ps.setString(12, _heated_seats);
            ps.setString(13, _nav_sys);
            ps.setString(14, _bluetooth);
            ps.setString(15, _elec_window);
            ps.setString(16, _gps);
            
            
            
            
            if(ps.executeUpdate() != 0 ){
                JOptionPane.showMessageDialog(null , "The New Car Has Been Added","ADD Car ",1);
               
            }else{
                JOptionPane.showMessageDialog(null , "Car Not Added","ADD Car ",2);
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
      public void editCar (int _brand, String _model, String _fuel, String _color, String _class, int _passengers, String _gearbox, int _price, String _air_cond,
                        String _airbag, String _sunroof, String _heated_seats, String _nav_sys, String _bluetooth, String _elec_window, String _gps,int id ) {
       
            String editQuery = "UPDATE `cars` SET `brand`=?, `model`=?, `fuel`=?, `color`=?, `class`=?, `passengers`=?, `gearbox`=?, `price`=?, `air_conditioning`=?,"
                    + " `airbags`=?, `sunroof`=?, `heated_seats`=?, `navigation_sytems`=?, `Bluetooth`=?, `elecric_windows`=?, `GPS`=? WHERE `id` = ?";

            PreparedStatement ps;
            ResultSet rs;
            try {
                ps = DB.getConnection().prepareStatement(editQuery);
                
                ps.setInt(1, _brand);
                ps.setString(2, _model);
                ps.setString(3, _fuel);
                ps.setString(4, _color);
                ps.setString(5, _class);
                ps.setInt(6, _passengers);
                ps.setString(7, _gearbox);
                ps.setInt(8, _price);
                 //car features 
                ps.setString(9, _air_cond);
                ps.setString(10, _airbag);
                ps.setString(11, _sunroof);
                ps.setString(12, _heated_seats);
                ps.setString(13, _nav_sys);
                ps.setString(14, _bluetooth);
                ps.setString(15, _elec_window);
                ps.setString(16, _gps);
                ps.setInt(17, id);
                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null , "The Car Has Been Edited","Edit Car ",1);
                 
                } else {
                    JOptionPane.showMessageDialog(null , "Car Not Edited","Edit Car ",2);
                    
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error: " + ex.getMessage()); // Print the error message
            }
    }
    
    
    public void removeCar(int _id) {
    String deleteQuery = "DELETE FROM `cars` WHERE `id`=?";
    
    PreparedStatement ps;
    try {
        ps = DB.getConnection().prepareStatement(deleteQuery);
        ps.setInt(1, _id); // Set the value of the first parameter to _id
    
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null , "The Car Has Been removed","Delete Car ",1);
           
        } else {
            JOptionPane.showMessageDialog(null , "Car Not removed","Delete Car ",2);
           
        }
    } catch (SQLException ex) {
        ex.printStackTrace();   
        Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    
    // create function to add new cars 
    
    public void addCarImage (int car_id, byte[] car_image) {
        String insertQuery = "INSERT INTO 'car_images'('car_id','c_image') VALUES (?,?)";
        
        PreparedStatement ps;
        ResultSet rs;
        try {
            
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setInt(1, car_id);
            ps.setBytes(2, car_image);
        
            if(ps.executeUpdate() != 0 ){
                JOptionPane.showMessageDialog(null , "The New Car Image Has Been Added","ADD Car Image ",1);
               // System.out.println("Locations Added");
            }else{
                JOptionPane.showMessageDialog(null , "Car Image Not Added","ADD Car Image ",2);
                 //System.out.println("Locations Not Added");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }
    
    
    
    // create a function to get car images and return  an arraylist
    
    public ArrayList<Integer> carImagesList(int car_id)
    {
        ArrayList<Integer> images = new ArrayList<>();
        
        ResultSet rs= getData("SELECT `id`,`car_id`,`c_image` FROM `car_images` WHERE `car_id` = "+car_id);
        
        try {
            while(rs.next())
            {
             
                
                images.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        return images;
    }
    
    
    //create a function to search car by id 

    /**
     *
     * @param car_id
     * @return
     */
     public Car getCarById(int car_id)
    {
            String query = "SELECT * FROM `cars` WHERE `id`=?";
            ResultSet rs = null;
            Car car = null;

            try (PreparedStatement ps = DB.getConnection().prepareStatement(query)) {
                ps.setInt(1, car_id);
                rs = ps.executeQuery();

                if (rs.next()) {
                    car = new Car(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),
                        rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),
                        rs.getString(15),rs.getString(16),rs.getString(17));
                } else {
                    System.out.println("Car not found for ID: " + car_id);
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

            return car;
    }
    
    
    
    
    
    
    
    
}
