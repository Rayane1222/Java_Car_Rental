/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java_car_rental;

import java.awt.Color;
import java.awt.Image;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java_car_rental.classes.Booking;
import java_car_rental.classes.Car;
import java_car_rental.classes.Customer;
import java_car_rental.classes.Location;
import java_car_rental.classes.brand_Cls;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author mac
 */
public class Form_Booking_Edit_Remove extends javax.swing.JFrame {

    /**
     * Creates new form Form_BookingEditRemove
     */
    
    Border border = BorderFactory.createMatteBorder(0,0,2,0, Color.white);
    Border panel_border = BorderFactory.createMatteBorder(1,1,1,1, Color.darkGray);
    brand_Cls brand = new brand_Cls();
    Car car = new Car();
    Location location =new Location();
    Booking booking = new Booking();
    HashMap<Integer, String> map= brand.brandsHashMap();
    
    public Form_Booking_Edit_Remove() 
    {
        initComponents();
        
        //center form
        this.setLocationRelativeTo(null) ;
       
        //set border 
        jLabel_selec_car.setBorder(border);
        jLabel_selecte_customer.setBorder(border);
        jLabel_pickup.setBorder(border);
        jLabel_dropoff.setBorder(border);
        
        jPanel_select_car.setBorder(panel_border);
        jPanel_select_customer.setBorder(panel_border);
        jPanel_pickup.setBorder(panel_border);
        jPanel_dropoff.setBorder(panel_border);
        
        populateComboboxBrands();
        
        displayImage(jLabel_book_logo.getWidth(),jLabel_book_logo.getHeight(),getClass().getResource("images/calendar1.png").getFile(),jLabel_book_logo);
        
    }
        
    //create a static function to display customer id and name
    public static void  displayCustomer(String id , String name)
    {
        jTextField_customer.setText(name);
        jLabel_customer_id.setText(id);
    }
    
    //create a static function to display customer id and name
    public static void  displayCarInfo(String id , String model , String price)
    {
        jTextField_Cars_Model.setText(model);
        jLabel_car_id.setText(id);
        jLabel_car_price.setText(price);
    }
    
    //create a static function to display customer id and name
    public static void  displayBooking(String id, String car_id , String customer_id ,String pickup_city, String pickup_address , String pickup_date ,
            String pickup_time , String dropoff_city , String dropoff_address ,String dropoff_date , String dropoff_time , String total_price)
    {
        jLabel_booking_id.setText(id);
        jLabel_car_id.setText(car_id);
        
        jTextField_Cars_Model.setText(new Car().getCarById(Integer.parseInt(car_id)).getModel());
        jLabel_car_price.setText(String.valueOf(new Car().getCarById(Integer.parseInt(car_id)).getPrice()));
        jLabel_brand_id.setText(String.valueOf(new Car().getCarById(Integer.parseInt(car_id)).getBrand()));
        
        jComboBox_Brands.setSelectedItem(new brand_Cls().getBrandById(new Car().getCarById(Integer.parseInt(car_id)).getBrand()).getName());
        
        jTextField_customer.setText(new Customer().getCustomerById(Integer.parseInt(customer_id)).getFullname());
        
        
        jLabel_customer_id.setText(customer_id);
        jLabel_car_totalprice.setText(total_price);
        
        //pickup
        jComboBox_PickUp_City.setSelectedItem(pickup_city);
        jComboBox_PickUp_Address.setSelectedItem(pickup_address);
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            jDateChooser_PickUp.setDate(dateformat.parse(pickup_date));
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Form_Booking_Edit_Remove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        timePicker_PickUp.setText(pickup_time);
                
        //dropoff
        jComboBox_DropOff_City.setSelectedItem(dropoff_city);
        jComboBox_DropOff_Address.setSelectedItem(dropoff_address);
        try {
            jDateChooser_DropOff.setDate(dateformat.parse(dropoff_date));
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Form_Booking_Edit_Remove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        timePicker_DropOff.setText(dropoff_time);
         
    }
    
    //create a function to populate the jcombobox with address   
        //and to do that we will use a ***hashmap*** 
    
    public void  populateComboboxAddress(String pickup_or_dropoff ,String city)
    {
        if (pickup_or_dropoff.equals("pickup"))
        {
            //clear combobox
            jComboBox_PickUp_Address.removeAllItems();
            //populate combobox
            for(Location l : location.locationListByCity(city))
                {
                    jComboBox_PickUp_Address.addItem(l.getAddress());
                }
        }
        else if(pickup_or_dropoff.equals("dropoff"))
        {
            //clear combobox
            jComboBox_DropOff_Address.removeAllItems();
            //populate combobox
            for(Location l : location.locationListByCity(city))
                {
                    jComboBox_DropOff_Address.addItem(l.getAddress());
                }
        }
    }
    
    //create a function to populate the jcombobox with brands   
    //and to do that we will use a ***hashmap*** 
        public void  populateComboboxBrands()
        {

            for(String s : map.values())
            {
                jComboBox_Brands.addItem(s);
            }
        }
        
        
        public void displayImage (int width, int height, String image_path, JLabel label){
        //get the image
        ImageIcon imageIco = new ImageIcon(image_path);
        //resize the image
        Image image = imageIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        //set the image into the jlabel
        label.setIcon(new ImageIcon(image));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel_book_logo = new javax.swing.JLabel();
        jLabel_close2 = new javax.swing.JLabel();
        jPanel_select_car = new javax.swing.JPanel();
        jLabel_selec_car = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_Brands = new javax.swing.JComboBox<>();
        jLabel_brand_id = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel_car_id = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton_select_car = new javax.swing.JButton();
        jTextField_Cars_Model = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel_car_price = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel_select_customer = new javax.swing.JPanel();
        jLabel_selecte_customer = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_customer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel_customer_id = new javax.swing.JLabel();
        jButton_select_customer = new javax.swing.JButton();
        jPanel_pickup = new javax.swing.JPanel();
        jLabel_pickup = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox_PickUp_Address = new javax.swing.JComboBox<>();
        jComboBox_PickUp_City = new javax.swing.JComboBox<>();
        jDateChooser_PickUp = new com.toedter.calendar.JDateChooser();
        timePicker_PickUp = new com.github.lgooddatepicker.components.TimePicker();
        jPanel_dropoff = new javax.swing.JPanel();
        jLabel_dropoff = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jComboBox_DropOff_Address = new javax.swing.JComboBox<>();
        jComboBox_DropOff_City = new javax.swing.JComboBox<>();
        jDateChooser_DropOff = new com.toedter.calendar.JDateChooser();
        timePicker_DropOff = new com.github.lgooddatepicker.components.TimePicker();
        jButton_Remove_Booking = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel_price_text = new javax.swing.JLabel();
        jLabel_car_totalprice = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_price_text1 = new javax.swing.JLabel();
        jButton_BookingList = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel_booking_id = new javax.swing.JLabel();
        jButton_Edit_Booking = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(230, 126, 34));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Booking  Edit / Remove");
        jLabel9.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel_close2.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N
        jLabel_close2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_close2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_close2.setText("X");
        jLabel_close2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_close2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_close2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel_book_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_close2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel_close2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_book_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel_selec_car.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_selec_car.setText("Select a Car");
        jLabel_selec_car.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_selec_car.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Brand :");
        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel2.setText("Car :");
        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jComboBox_Brands.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jComboBox_Brands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_BrandsActionPerformed(evt);
            }
        });

        jLabel_brand_id.setText("000");
        jLabel_brand_id.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel6.setText("ID:");
        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel_car_id.setText("000");
        jLabel_car_id.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel7.setText("ID:");
        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jButton_select_car.setText("Select Car");
        jButton_select_car.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_select_carActionPerformed(evt);
            }
        });

        jLabel13.setText("Price :");
        jLabel13.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel_car_price.setText("000");
        jLabel_car_price.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel18.setText("Dhs");
        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel_select_carLayout = new javax.swing.GroupLayout(jPanel_select_car);
        jPanel_select_car.setLayout(jPanel_select_carLayout);
        jPanel_select_carLayout.setHorizontalGroup(
            jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_select_carLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_selec_car, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_select_carLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox_Brands, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_select_carLayout.createSequentialGroup()
                                .addGroup(jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_Cars_Model)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_select_carLayout.createSequentialGroup()
                                        .addComponent(jLabel_car_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18))
                                    .addComponent(jButton_select_car, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_select_carLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_car_id))
                            .addGroup(jPanel_select_carLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_brand_id)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_select_carLayout.setVerticalGroup(
            jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_select_carLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel_selec_car)
                .addGap(18, 18, 18)
                .addGroup(jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox_Brands, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel_brand_id))
                .addGap(18, 18, 18)
                .addGroup(jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_select_car, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addGroup(jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel7)
                        .addComponent(jLabel_car_id)
                        .addComponent(jTextField_Cars_Model, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel_select_carLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_car_price)
                    .addComponent(jLabel13)
                    .addComponent(jLabel18))
                .addContainerGap())
        );

        jLabel_selecte_customer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_selecte_customer.setText("Select a Customer");
        jLabel_selecte_customer.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_selecte_customer.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Customer :");
        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jTextField_customer.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel5.setText("ID:");
        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel_customer_id.setText("000");
        jLabel_customer_id.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jButton_select_customer.setText("Select Customer");
        jButton_select_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_select_customerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_select_customerLayout = new javax.swing.GroupLayout(jPanel_select_customer);
        jPanel_select_customer.setLayout(jPanel_select_customerLayout);
        jPanel_select_customerLayout.setHorizontalGroup(
            jPanel_select_customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_select_customerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_select_customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_selecte_customer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_select_customerLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_select_customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_select_customerLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_customer_id)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel_select_customerLayout.createSequentialGroup()
                                .addComponent(jTextField_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jButton_select_customer)
                        .addGap(47, 47, 47)))
                .addContainerGap())
        );
        jPanel_select_customerLayout.setVerticalGroup(
            jPanel_select_customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_select_customerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel_selecte_customer)
                .addGap(28, 28, 28)
                .addGroup(jPanel_select_customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_select_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_select_customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel_customer_id))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel_pickup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_pickup.setText("Pick Up Location & Date");
        jLabel_pickup.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_pickup.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("City :");
        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel10.setText("Address :");
        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel11.setText("Date :");
        jLabel11.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel12.setText("Time :");
        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jComboBox_PickUp_City.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "City 1", "City 2", "City 3", "City 4" }));
        jComboBox_PickUp_City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_PickUp_CityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_pickupLayout = new javax.swing.GroupLayout(jPanel_pickup);
        jPanel_pickup.setLayout(jPanel_pickupLayout);
        jPanel_pickupLayout.setHorizontalGroup(
            jPanel_pickupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pickupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_pickupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_pickup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_pickupLayout.createSequentialGroup()
                        .addGroup(jPanel_pickupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_pickupLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(54, 54, 54)
                                .addComponent(jComboBox_PickUp_City, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_pickupLayout.createSequentialGroup()
                                .addGroup(jPanel_pickupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_pickupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox_PickUp_Address, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser_PickUp, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                    .addComponent(timePicker_PickUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_pickupLayout.setVerticalGroup(
            jPanel_pickupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_pickupLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel_pickup)
                .addGap(18, 18, 18)
                .addGroup(jPanel_pickupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox_PickUp_City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_pickupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox_PickUp_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_pickupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11)
                    .addComponent(jDateChooser_PickUp, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_pickupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(timePicker_PickUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel_dropoff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_dropoff.setText("Drop Off Location & Date");
        jLabel_dropoff.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel_dropoff.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setText("City :");
        jLabel14.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel15.setText("Address :");
        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel16.setText("Date :");
        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel17.setText("Time :");
        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jComboBox_DropOff_City.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "City 1", "City 2", "City 3", "City 4" }));
        jComboBox_DropOff_City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_DropOff_CityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_dropoffLayout = new javax.swing.GroupLayout(jPanel_dropoff);
        jPanel_dropoff.setLayout(jPanel_dropoffLayout);
        jPanel_dropoffLayout.setHorizontalGroup(
            jPanel_dropoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_dropoffLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_dropoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_dropoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel_dropoffLayout.createSequentialGroup()
                        .addGroup(jPanel_dropoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_dropoffLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(54, 54, 54)
                                .addComponent(jComboBox_DropOff_City, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_dropoffLayout.createSequentialGroup()
                                .addGroup(jPanel_dropoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_dropoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox_DropOff_Address, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser_DropOff, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                    .addComponent(timePicker_DropOff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel_dropoffLayout.setVerticalGroup(
            jPanel_dropoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_dropoffLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel_dropoff)
                .addGap(18, 18, 18)
                .addGroup(jPanel_dropoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox_DropOff_City, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_dropoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBox_DropOff_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_dropoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jDateChooser_DropOff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_dropoffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(timePicker_DropOff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jButton_Remove_Booking.setText("Remove / Cancel Booking");
        jButton_Remove_Booking.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton_Remove_Booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Remove_BookingActionPerformed(evt);
            }
        });

        jLabel_price_text.setText("Total Price :");
        jLabel_price_text.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel_car_totalprice.setText("000");
        jLabel_car_totalprice.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel20.setText("Dhs");
        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel_price_text)
                .addGap(18, 18, 18)
                .addComponent(jLabel_car_totalprice, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel_car_totalprice)
                    .addComponent(jLabel_price_text))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel_price_text1.setText("Select Booking:");
        jLabel_price_text1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jButton_BookingList.setText("Booking List");
        jButton_BookingList.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton_BookingList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BookingListActionPerformed(evt);
            }
        });

        jLabel19.setText("ID:");
        jLabel19.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jLabel_booking_id.setText("000");
        jLabel_booking_id.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel_price_text1)
                .addGap(39, 39, 39)
                .addComponent(jButton_BookingList, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(jLabel_booking_id)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(jLabel_booking_id))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel_price_text1)
                        .addComponent(jButton_BookingList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_Edit_Booking.setText("Edit Booking");
        jButton_Edit_Booking.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton_Edit_Booking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Edit_BookingActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel_select_car, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel_select_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jButton_Remove_Booking)
                        .addGap(88, 88, 88)
                        .addComponent(jButton_Edit_Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(93, 93, 93)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_pickup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel_dropoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel_pickup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jPanel_dropoff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel_select_car, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel_select_customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton_Remove_Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_Edit_Booking, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_close2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_close2MouseClicked
        Form_BookCar Book_brd = new Form_BookCar();
         Book_brd.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jLabel_close2MouseClicked

    private void jComboBox_BrandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_BrandsActionPerformed
        // Get the Selected brand id
        int brand_id=0;
        for(Map.Entry<Integer, String> entry : map.entrySet())
        {
            if(entry.getValue().equals(jComboBox_Brands.getSelectedItem().toString()))
            {
                brand_id = entry.getKey();
            }

        }
        jLabel_brand_id.setText(String.valueOf(brand_id));
    }//GEN-LAST:event_jComboBox_BrandsActionPerformed

    private void jButton_select_carActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_select_carActionPerformed
        //get the brand id
        int brand_id = Integer.valueOf(jLabel_brand_id.getText());

        // show the car list form
        Form_CarListByBrands frm_car_lst = new Form_CarListByBrands(brand_id,"edit");
        frm_car_lst.setVisible(true);
    }//GEN-LAST:event_jButton_select_carActionPerformed

    private void jButton_select_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_select_customerActionPerformed
        // show the customers list
        Form_CustomerList frm_cst_lst = new Form_CustomerList("edit");
        frm_cst_lst.setVisible(true);

    }//GEN-LAST:event_jButton_select_customerActionPerformed

    private void jComboBox_PickUp_CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_PickUp_CityActionPerformed
        //populate jcombox address depending on the city  combobox
        populateComboboxAddress("pickup",jComboBox_PickUp_City.getSelectedItem().toString());

    }//GEN-LAST:event_jComboBox_PickUp_CityActionPerformed

    private void jComboBox_DropOff_CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_DropOff_CityActionPerformed
        //populate jcombox address depending on the city  combobox
        populateComboboxAddress("dropoff",jComboBox_DropOff_City.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox_DropOff_CityActionPerformed

    private void jButton_Remove_BookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Remove_BookingActionPerformed
        
        //remove / cancel booking
        // Booking id
        
        int id = Integer.parseInt(jLabel_booking_id.getText());
        
        int confirm = JOptionPane.showConfirmDialog(null,"Are You Sure You Want To Delete This Reservation","confirm",JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION)
        {
            booking.removeBooking(id);
        }
        
       
    }//GEN-LAST:event_jButton_Remove_BookingActionPerformed

    private void jButton_BookingListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BookingListActionPerformed
        // Display the booking List

        Form_BookingList bookingList = new Form_BookingList("edit");
        bookingList.setVisible(true);

    }//GEN-LAST:event_jButton_BookingListActionPerformed

    private void jButton_Edit_BookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Edit_BookingActionPerformed
       //edit booking
        
         try{

            // Booking id
            int id = Integer.parseInt(jLabel_booking_id.getText());
            //get the car info Ps: its too hard for me GRR
            int car_id = Integer.parseInt(jLabel_car_id.getText());
            //get the customer info
            int customer_id  = Integer.parseInt(jLabel_customer_id.getText());
            //get the pickup info
            String  pickup_city = jComboBox_PickUp_City.getSelectedItem().toString();
            String pickup_address = jComboBox_PickUp_Address.getSelectedItem().toString();

            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String pickup_date = dateformat.format(jDateChooser_PickUp.getDate());
            Date pickup_date_ = dateformat.parse(pickup_date);
            String pickup_time = timePicker_PickUp.getText();

            //get the dropoff info
            String  dropoff_city = jComboBox_DropOff_City.getSelectedItem().toString();
            String dropoff_address = jComboBox_DropOff_Address.getSelectedItem().toString();

            String dropoff_date = dateformat.format(jDateChooser_DropOff.getDate());
            Date dropoff_date_ = dateformat.parse(dropoff_date);
            String dropoff_time = timePicker_DropOff.getText();

            //get date difference in days
            long diff = dropoff_date_.getTime() - pickup_date_.getTime();
            //System.out.println("diff -"+diff);

            int diff_days = (int) ( diff / 1000 / 60 / 60 / 24 );
            //System.out.println("diff_days -"+diff_days);

            //
            int price = Integer.valueOf(jLabel_car_price.getText());
            int total_price = diff_days * price;

            jLabel_price_text.setText("Total Price ( "+String.valueOf(  price)+" x "+String.valueOf(diff_days)+") :");
            jLabel_car_totalprice.setText(String.valueOf(total_price));

            //check  if the dopoff date is before pick up date
            if(dropoff_date_.before(pickup_date_))
            {

                JOptionPane.showMessageDialog(null,"The drop Off Date Or Time Must Be After The Pickup Date","invalid Date ",2);

            }
            //check if the drop off date is equal to pick off date
            else if(dropoff_date_.equals(pickup_date_))
            {
                //checkif the drop off time is before the puck date time
                if(timePicker_DropOff.getTime().isBefore(timePicker_PickUp.getTime()))
                {
                    JOptionPane.showMessageDialog(null,"The drop Off Date Or Time Must Be After The Pickup Date","invalid Date ",2);
                }
                else
                {
                    booking.editBooking( id , car_id, customer_id, pickup_city, pickup_address, pickup_date,
                        pickup_time, dropoff_city, dropoff_address, dropoff_date, dropoff_time, total_price);
                }
            }
            else
            {
                booking.editBooking( id ,car_id, customer_id, pickup_city, pickup_address, pickup_date,
                    pickup_time, dropoff_city, dropoff_address, dropoff_date, dropoff_time, total_price);
            }

        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null,"Enter a Valid Model and Class - Make sure to Enter all the info","invalid info ",2);
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Form_Booking_Edit_Remove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton_Edit_BookingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Booking_Edit_Remove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Booking_Edit_Remove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Booking_Edit_Remove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Booking_Edit_Remove.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_Booking_Edit_Remove().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_BookingList;
    private javax.swing.JButton jButton_Edit_Booking;
    private javax.swing.JButton jButton_Remove_Booking;
    private javax.swing.JButton jButton_select_car;
    private javax.swing.JButton jButton_select_customer;
    public static javax.swing.JComboBox<String> jComboBox_Brands;
    public static javax.swing.JComboBox<String> jComboBox_DropOff_Address;
    public static javax.swing.JComboBox<String> jComboBox_DropOff_City;
    public static javax.swing.JComboBox<String> jComboBox_PickUp_Address;
    public static javax.swing.JComboBox<String> jComboBox_PickUp_City;
    public static com.toedter.calendar.JDateChooser jDateChooser_DropOff;
    public static com.toedter.calendar.JDateChooser jDateChooser_PickUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_book_logo;
    private static javax.swing.JLabel jLabel_booking_id;
    private static javax.swing.JLabel jLabel_brand_id;
    private static javax.swing.JLabel jLabel_car_id;
    private static javax.swing.JLabel jLabel_car_price;
    private static javax.swing.JLabel jLabel_car_totalprice;
    private javax.swing.JLabel jLabel_close2;
    private static javax.swing.JLabel jLabel_customer_id;
    private javax.swing.JLabel jLabel_dropoff;
    private javax.swing.JLabel jLabel_pickup;
    private javax.swing.JLabel jLabel_price_text;
    private javax.swing.JLabel jLabel_price_text1;
    private javax.swing.JLabel jLabel_selec_car;
    private javax.swing.JLabel jLabel_selecte_customer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_dropoff;
    private javax.swing.JPanel jPanel_pickup;
    private javax.swing.JPanel jPanel_select_car;
    private javax.swing.JPanel jPanel_select_customer;
    private static javax.swing.JTextField jTextField_Cars_Model;
    private static javax.swing.JTextField jTextField_customer;
    public static com.github.lgooddatepicker.components.TimePicker timePicker_DropOff;
    public static com.github.lgooddatepicker.components.TimePicker timePicker_PickUp;
    // End of variables declaration//GEN-END:variables
}
