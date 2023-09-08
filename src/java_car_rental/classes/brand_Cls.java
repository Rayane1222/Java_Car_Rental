/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_car_rental.classes;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;





/**
 *
 * @author mac
 */
public class brand_Cls {
    
    private int id;
    private String name;
    private byte[] logo;

    public brand_Cls() {
    }

    public brand_Cls(int id, String name, byte[] logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    
    
    
    // create function to add, edit, remove 
    
    public void addBrand (String _name, byte[] _logo) {
        String insertQuery = "INSERT INTO 'brands'('name','logo') VALUES (?,?)";
        
        PreparedStatement ps;
        ResultSet rs;
        try {
            
            ps = DB.getConnection().prepareStatement(insertQuery);
            ps.setString(1, _name);
            ps.setBytes(2, _logo);
        
            if(ps.executeUpdate() != 0 ){
                JOptionPane.showMessageDialog(null , "The New Brand Has Been Added","ADD Brand ",1);
               // System.out.println("Locations Added");
            }else{
                JOptionPane.showMessageDialog(null , "Brand Not Added","ADD Brand ",2);
                 //System.out.println("Locations Not Added");
            }
        } catch (SQLException ex) {
            Logger.getLogger(brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }
    
    
    
    public void editBrand (int _id ,String _name, byte[] _logo) {
       
            String editQuery = "UPDATE `brands` SET `name`=?, `logo`=? WHERE `id` = ?";

            PreparedStatement ps;
            ResultSet rs;
            try {
                ps = DB.getConnection().prepareStatement(editQuery);
                ps.setString(1, _name);
                ps.setBytes(2, _logo);
                ps.setInt(3, _id);

                if (ps.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null , "The Brand Has Been Edited","Edit Brand ",1);
                 //System.out.println("Locations Edited");
                } else {
                    JOptionPane.showMessageDialog(null , "Brand Not Edited","Edit Brand ",2);
                    //System.out.println("Locations Not Edited");
                }
            } catch (Exception ex) {
            //Logger.getLogger(Form_Brands.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null , "Select the brand Logo [ "+ex.getMessage()+"]"," Brand Logo",1);
        }


        
      
    }
    
    
    public void removeBrand(int _id) {
    String deleteQuery = "DELETE FROM `brands` WHERE `id`=?";
    
    PreparedStatement ps;
    try {
        ps = DB.getConnection().prepareStatement(deleteQuery);
        ps.setInt(1, _id); // Set the value of the first parameter to _id
    
        if (ps.executeUpdate() != 0) {
            JOptionPane.showMessageDialog(null , "The Brand Has Been removed","Delete Brand ",1);
            //System.out.println("Locations removed");
        } else {
            JOptionPane.showMessageDialog(null , "Brand Not removed","Delete Brand ",2);
            //System.out.println("Locations Not removed");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();   
        Logger.getLogger(brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    // create a function to get all brands and return  an arraylist
    
    public ArrayList<brand_Cls> brandsList()
    {
        ArrayList<brand_Cls> brdList = new ArrayList<>();
        
        ResultSet rs= getData("SELECT * FROM `brands`");
        
        try {
            while(rs.next())
            {
             
                brand_Cls brand =new brand_Cls(rs.getInt(1),rs.getString(2),rs.getBytes(3));
                brdList.add(brand);
            }
        } catch (SQLException ex) {
            Logger.getLogger(brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brdList;
    }
    
     //cretae a function to get brand by id 
    public brand_Cls getBrandById(int brand_id)
    {
            String query = "SELECT * FROM `brands` WHERE `id`=?";
            ResultSet rs = null;
            brand_Cls brand = null;

            try (PreparedStatement ps = DB.getConnection().prepareStatement(query)) {
                ps.setInt(1, brand_id);
                rs = ps.executeQuery();

                if (rs.next()) {
                    brand = new brand_Cls(rs.getInt(1), rs.getString(2), rs.getBytes(3));
                } else {
                    System.out.println("Brand not found for ID: " + brand_id);
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

            return brand;
    }
    
    // create  a function to poplate a hashmap with brands ( id and name)
    public HashMap< Integer, String > brandsHashMap()
    {
        HashMap<Integer, String> brands_map = new HashMap<Integer, String>();
        
        ResultSet rs= getData("SELECT * FROM `brands`");
        
        try {
            while(rs.next())
            {
                brands_map.put(rs.getInt(1),rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brands_map;
        
    }
    
}
