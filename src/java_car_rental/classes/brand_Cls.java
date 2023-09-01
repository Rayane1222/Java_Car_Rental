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





/**
 *
 * @author mac
 */
public class brand_Cls {
    
    private int id;
    private String name;
    private byte[] logo;
    
    public brand_Cls() {}

    public brand_Cls(int _id, String _name, byte[] _logo) {
        this.id = _id;
        this.name = _name;
        this.logo = _logo;
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
                System.out.println("Brand Added");
            }else{
                 System.out.println("Brand Not Added");
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
                    System.out.println("Brand Edited");
                } else {
                    System.out.println("Brand Not Edited");
                }
            } catch (SQLException ex) {
                Logger.getLogger(brand_Cls.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error: " + ex.getMessage()); // Print the error message
            }


        
      
    }
    
    
    public void removeBrand(int _id) {
    String deleteQuery = "DELETE FROM `brands` WHERE `id`=?";
    
    PreparedStatement ps;
    try {
        ps = DB.getConnection().prepareStatement(deleteQuery);
        ps.setInt(1, _id); // Set the value of the first parameter to _id
    
        if (ps.executeUpdate() != 0) {
            System.out.println("Brand removed");
        } else {
            System.out.println("Brand Not removed");
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
    
}