/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package java_car_rental;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java_car_rental.classes.Car;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mac
 */
public class Form_CarsImages extends javax.swing.JFrame {

    /**
     * Creates new form Form_CarsImages
     */
    
    Car car = new Car();
    ArrayList<Car> cars_list = car.carsList();
    ArrayList<Car.CarImage> carImages;
   
    
    public Form_CarsImages() {
        initComponents();
        
         //center the form
        this.setLocationRelativeTo(null) ;
        
        //populate Jtable With Cars
        populateJtableWithCars();
    }
    
     public void displayImage (int width, int height, String image_path, JLabel label){
        //get the image
        ImageIcon imageIco = new ImageIcon(image_path);
        //resize the image
        Image image = imageIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        //set the image into the jlabel
        label.setIcon(new ImageIcon(image));
    }
     
      public void displayByteImage(int width, int height, byte[] image_byte, JLabel label) {
    if (image_byte != null) { // Check if the image_byte is not null
        // Get the image
        ImageIcon imageIco = new ImageIcon(image_byte);

        // Resize the image
        Image image = imageIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Set the image into the JLabel
        label.setIcon(new ImageIcon(image));
    } else {
        // Handle the case where image_byte is null (e.g., display a default image)
        label.setIcon(null); // Clear the label's icon
    }
}
     
     //create a function to select an image 
    //the function will return the image path
    //use image with a low size 
    public String selectImage ()
    {
            
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Picture");
        
        fileChooser.setCurrentDirectory(new File("/Users/mac/Desktop/stage/Java_Car_Rental/src/java_car_rental/images"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("image",".png",".jpg");
        fileChooser.addChoosableFileFilter(filter);
        
        int state = fileChooser.showSaveDialog(null);
        String path = "";
        
        if(state == JFileChooser.APPROVE_OPTION)
        {
            path =fileChooser.getSelectedFile().getAbsolutePath();
        }
        
        return path;
    }
    
     //create a function to populate the jtable whith brand(id & name )
    
    public void populateJtableWithCars()
    {
        //clear array list 
        cars_list.clear();
        //populate arraylist
        cars_list = car.carsList();   
        //jtable columns
        String[] columnsName = {"ID","Model","Class"};
        
        //jtable rows 
        Object[][] rows = new Object[cars_list.size()][columnsName.length];
        
        for(int i=0;i<cars_list.size();i++)
        {
            rows[i][0]  =cars_list.get(i).getId();
            rows[i][1]  =cars_list.get(i).getModel(); 
            rows[i][2]  =cars_list.get(i).getClass_();
            
        }
        
        DefaultTableModel model = new DefaultTableModel(rows,columnsName);
        jTable_Cars.setModel(model);
        
    }
    
    //create a function to populate the jtable whith car images (id  )
    
    public void populateJtableWithCarImages(int car_id)
    {
        
         ArrayList<Car.CarImage> imagesList = car.carImagesList(car_id);
        
        //jtable columns
        String[] columnsName = {"Image ID"};
        
        //jtable rows 
        Object[][] rows = new Object[imagesList.size()][columnsName.length];
        
        for(int i=0;i<imagesList.size();i++)
        {
            rows[i][0]  =imagesList.get(i).getImg_id();
            
            
        }
        
        DefaultTableModel model = new DefaultTableModel(rows,columnsName);
        jTable_Car_Images.setModel(model);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel_brands_logo = new javax.swing.JLabel();
        jLabel_close = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Cars = new javax.swing.JTable();
        jButton_Select_Image = new javax.swing.JButton();
        jLabel_CarImage = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Car_Images = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_Remove_Image = new javax.swing.JButton();
        jButton_images_Sliders = new javax.swing.JButton();
        jButton_Add_Image = new javax.swing.JButton();
        jLabel_imagePath = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(26, 188, 156));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Car Images");

        jLabel_close.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N
        jLabel_close.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_close.setText("X");
        jLabel_close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_brands_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(440, 440, 440)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 475, Short.MAX_VALUE)
                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel_brands_logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel_close, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTable_Cars.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTable_Cars.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_Cars.setRowHeight(50);
        jTable_Cars.setSelectionBackground(new java.awt.Color(0, 204, 153));
        jTable_Cars.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_CarsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Cars);

        jButton_Select_Image.setBackground(new java.awt.Color(22, 160, 133));
        jButton_Select_Image.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton_Select_Image.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Select_Image.setText("Selected Images");
        jButton_Select_Image.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Select_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Select_ImageActionPerformed(evt);
            }
        });

        jLabel_CarImage.setBackground(new java.awt.Color(204, 204, 204));
        jLabel_CarImage.setOpaque(true);

        jTable_Car_Images.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jTable_Car_Images.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_Car_Images.setSelectionBackground(new java.awt.Color(0, 204, 153));
        jTable_Car_Images.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Car_ImagesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_Car_Images);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cars");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Selected Car Images");
        jLabel2.setToolTipText("");

        jButton_Remove_Image.setBackground(new java.awt.Color(22, 160, 133));
        jButton_Remove_Image.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton_Remove_Image.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Remove_Image.setText("Remove Image");
        jButton_Remove_Image.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Remove_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Remove_ImageActionPerformed(evt);
            }
        });

        jButton_images_Sliders.setBackground(new java.awt.Color(22, 160, 133));
        jButton_images_Sliders.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton_images_Sliders.setForeground(new java.awt.Color(255, 255, 255));
        jButton_images_Sliders.setText("Images Slider");
        jButton_images_Sliders.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_images_Sliders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_images_SlidersActionPerformed(evt);
            }
        });

        jButton_Add_Image.setBackground(new java.awt.Color(22, 160, 133));
        jButton_Add_Image.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jButton_Add_Image.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Add_Image.setText("Add Image");
        jButton_Add_Image.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Add_Image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Add_ImageActionPerformed(evt);
            }
        });

        jLabel_imagePath.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_imagePath.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        jLabel_imagePath.setForeground(new java.awt.Color(0, 0, 0));
        jLabel_imagePath.setText("#");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Remove_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Select_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_images_Sliders, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Add_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_CarImage, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel_imagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGap(33, 33, 33)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel_CarImage, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel_imagePath)
                        .addGap(14, 14, 14)
                        .addComponent(jButton_Select_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Add_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Remove_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_images_Sliders, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMouseClicked
        Form_Cars frm_crs = new Form_Cars();
         frm_crs.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_jLabel_closeMouseClicked

    private void jTable_CarsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CarsMouseClicked

        // get the selected car
        //display the selected car images
        int index = jTable_Cars.getSelectedRow();
        int id =Integer.parseInt(jTable_Cars.getValueAt(index, 0).toString());
        System.out.println(id);
        populateJtableWithCarImages( id);
        carImages = car.carImagesList(id);

    }//GEN-LAST:event_jTable_CarsMouseClicked

    private void jButton_Select_ImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Select_ImageActionPerformed
        // browse and display image 
        String imagePath = selectImage();
        displayImage(jLabel_CarImage.getWidth(),jLabel_CarImage.getHeight(),imagePath,jLabel_CarImage);
        //display the image path 
        jLabel_imagePath.setText(imagePath);

    }//GEN-LAST:event_jButton_Select_ImageActionPerformed

    private void jTable_Car_ImagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Car_ImagesMouseClicked
        // Display the selected image 
        //get image id from the jtable 
        
            int index=jTable_Car_Images.getSelectedRow();
            int image_id = Integer.parseInt(jTable_Car_Images.getValueAt(index,0).toString());
            
            byte[] img = null;
            
            for(Car.CarImage cimg : carImages)
            {
                if(cimg.getImg_id() == image_id)
                {
                    img = cimg.getCar_img();
                }
            }
            
        displayByteImage(jLabel_CarImage.getWidth(),jLabel_CarImage.getHeight(),img,jLabel_CarImage);
        
    }//GEN-LAST:event_jTable_Car_ImagesMouseClicked

    private void jButton_Remove_ImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Remove_ImageActionPerformed
        // delete image 
        //get selected image id
        try{
            int index=jTable_Car_Images.getSelectedRow();
            int image_id = Integer.parseInt(jTable_Car_Images.getValueAt(index,0).toString());
            int confirm = JOptionPane.showConfirmDialog(null,"Are You Sure You Want To Delete This Image","confirm",JOptionPane.YES_NO_OPTION);
            if(confirm == JOptionPane.YES_OPTION)
            {

                    car.removeCarImage(image_id);
                    jTable_Car_ImagesMouseClicked(null);

            }
        }catch (Exception ex) 
        {  
            JOptionPane.showMessageDialog(null , "Select the Car Image","Delete Car Image ",2);
        }
    }//GEN-LAST:event_jButton_Remove_ImageActionPerformed

    private void jButton_images_SlidersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_images_SlidersActionPerformed
        
        try {
        
        // Show images (for the selected car ) slider :
        // get the selected car Image
        int index = jTable_Cars.getSelectedRow();
        int id =Integer.parseInt(jTable_Cars.getValueAt(index, 0).toString());//car id
        Form_CarImages_Slider slider = new Form_CarImages_Slider(id);
        slider.setVisible(true);
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null , "Select the Car"," Car Image ",2);
        }
    }//GEN-LAST:event_jButton_images_SlidersActionPerformed

    private void jButton_Add_ImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Add_ImageActionPerformed
            // Add image:
        try {
            
            //get car id from the jtable 
            int index=jTable_Cars.getSelectedRow();
            int car_id = Integer.parseInt(jTable_Cars.getValueAt(index,0).toString());
            byte[] image = Files.readAllBytes(Paths.get(jLabel_imagePath.getText()));
            
            car.addCarImage(car_id,image);
            
                    
        } catch (Exception ex) {
            //Logger.getLogger(Form_Brands.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null , "Select the Car Image Logo [ "+ex.getMessage()+"]"," Car Image",1);
        }
    }//GEN-LAST:event_jButton_Add_ImageActionPerformed

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
            java.util.logging.Logger.getLogger(Form_CarsImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_CarsImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_CarsImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_CarsImages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_CarsImages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Add_Image;
    private javax.swing.JButton jButton_Remove_Image;
    private javax.swing.JButton jButton_Select_Image;
    private javax.swing.JButton jButton_images_Sliders;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_CarImage;
    private javax.swing.JLabel jLabel_brands_logo;
    private javax.swing.JLabel jLabel_close;
    private javax.swing.JLabel jLabel_imagePath;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_Car_Images;
    private javax.swing.JTable jTable_Cars;
    // End of variables declaration//GEN-END:variables
}
