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
    
    //create a function to add new car
    public void addCar( int _brand, String _model, String _fuel, String _color, String _class, int _passengers, String _gearbox, int _price, String _air_cond,
                        String _airbag, String _sunroof, String _heated_seats, String _nav_sys, String _bluetooth, String _elec_window, String _gps)
    {
        String insertQuery = "INSERT INTO 'cars'('brand','model','fuel','color','class','passengers','gearbox','price','air_conditioning','airbags','sunroof','heated_seats','nav_sytems','Bluetooth','elecric_windows','GPS') VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
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
               // System.out.println("Locations Added");
            }else{
                JOptionPane.showMessageDialog(null , "Car Not Added","ADD Car ",2);
                 //System.out.println("Locations Not Added");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
