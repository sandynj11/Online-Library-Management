/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author santhoshkumar
 */
public class ManageStudent extends javax.swing.JFrame {

    /**
     * Creates new form ManageBookd
     */
    
    String sname,c,b;
    int sid;
    DefaultTableModel mo;
    public ManageStudent() {
        initComponents();
        userDetails();
    }
    
    //to insert book details into table from db
    public void userDetails(){
        
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from user_details");
            
            while(rs.next()){
                String userID = rs.getString("studentid");
                String userName = rs.getString("name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
                
                Object[] o = {userID,userName,course,branch};
                
                mo = (DefaultTableModel) userdetails.getModel();
                mo.addRow(o);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
    //add book details to table
    public boolean addUser(){
        boolean isadd = false;
        sid = Integer.parseInt(userid.getText());
        sname = username.getText();
        c = course.getSelectedItem().toString();
        b = branch.getSelectedItem().toString();
        
        try{
            Connection conn = DatabaseConnection.getConnection();
            String sql = "insert into user_details values(?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, sid);
            pst.setString(2,sname);
            pst.setString(3,c);
            pst.setString(4, b);
            
            int rowcount = pst.executeUpdate();
            if(rowcount>0){
                isadd = true;
                
            }else{
                isadd = false;
            }
            
        }catch (Exception e){
            e.printStackTrace();
            
        }
        return isadd;
        
    }
    
    public boolean userUpdate(){
        
        boolean isupdate = false;
         sid = Integer.parseInt(userid.getText());
        sname = username.getText();
        c = course.getSelectedItem().toString();
        b = branch.getSelectedItem().toString();
        
        
        try{
            Connection conn = DatabaseConnection.getConnection();
            String sql = "update user_details set name = ?, course = ?, branch = ? where studentid = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, sname);
            pst.setString(2,c);
            pst.setString(3,b);
            pst.setInt(4,sid);
            
            int rowcount = pst.executeUpdate();
            if(rowcount > 0){
                isupdate = true;
            }else{
                isupdate = false;
            }
            
        }catch (Exception e){
            e.printStackTrace();
            
        }
        return isupdate;
    }
    
    public boolean deleteUser(){
        boolean isdelete = false;
        sid = Integer.parseInt(userid.getText());
        
        try{
            Connection conn = DatabaseConnection.getConnection();
            String sql = "delete from user_details where studentid = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, sid);
            
            int rowcount = pst.executeUpdate();
            
            if(rowcount > 0){
                isdelete = true;
            }else{
                isdelete = false;
            }
                
            
        }catch (Exception e){
            e.printStackTrace();
            
        }
        return isdelete;
        
    }
    
    public void tableClear(){
        DefaultTableModel mo = (DefaultTableModel) userdetails.getModel();
        mo.setRowCount(0);
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
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        userid = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        username = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        branch = new javax.swing.JComboBox<>();
        course = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userdetails = new rojerusan.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 90, 60));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel9.setText("Enter User ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 240, 40));

        userid.setBackground(new java.awt.Color(0, 102, 255));
        userid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        userid.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        userid.setPhColor(new java.awt.Color(255, 255, 255));
        userid.setPlaceholder("Enter User ID");
        userid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                useridFocusLost(evt);
            }
        });
        jPanel1.add(userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel11.setText("Enter User Name");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 240, 40));

        username.setBackground(new java.awt.Color(0, 102, 255));
        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        username.setFont(new java.awt.Font("Helvetica Neue", 0, 17)); // NOI18N
        username.setPhColor(new java.awt.Color(255, 255, 255));
        username.setPlaceholder("Enter User Name");
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 90, 60));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 90, 60));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel14.setText("Select Course");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 240, 40));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel15.setText("Select Branch");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 240, 40));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 560, 90, 60));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 650, 160, 70));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle2.setText("Add");
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 150, 70));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonCircle3.setText("UPDATE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 650, 150, 70));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Kailasa", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 50));

        branch.setFont(new java.awt.Font("Kailasa", 1, 17)); // NOI18N
        branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CSE", "Cloud", "Secuirty", "Others" }));
        branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchActionPerformed(evt);
            }
        });
        jPanel1.add(branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, 210, 30));

        course.setFont(new java.awt.Font("Kailasa", 1, 17)); // NOI18N
        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bsc", "Msc", "PHD", "Others" }));
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 210, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, -1, 820));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Kailasa", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 20, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 0, 130, 50));

        userdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Name", "Course", "Branch"
            }
        ));
        userdetails.setColorBackgoundHead(new java.awt.Color(0, 153, 255));
        userdetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        userdetails.setRowHeight(40);
        userdetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userdetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(userdetails);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 600, 290));

        jLabel3.setFont(new java.awt.Font("Kailasa", 1, 17)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText("Manage users");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, -1, -1));

        setSize(new java.awt.Dimension(1724, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
        HomePage h = new HomePage();
        h.setVisible(true);
        dispose();
        
        
    }//GEN-LAST:event_jPanel1MouseClicked

    private void useridFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_useridFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_useridFocusLost

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
        if(deleteUser()== true){
            JOptionPane.showMessageDialog(this, "User deleted successfully");
            tableClear();
            userDetails();
        }else{
            JOptionPane.showMessageDialog(this,"User is not deleted");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        if(addUser()== true){
            JOptionPane.showMessageDialog(this, "User added successfully");
            tableClear();
            userDetails();
        }else{
            JOptionPane.showMessageDialog(this,"User is not added");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
        if(userUpdate()== true){
            JOptionPane.showMessageDialog(this, "User updated successfully");
            tableClear();
            userDetails();
        }else{
            JOptionPane.showMessageDialog(this,"User is not updated");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void userdetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userdetailsMouseClicked
        // TODO add your handling code here:
        int rowno = userdetails.getSelectedRow();
        TableModel mo = userdetails.getModel();
        userid.setText(mo.getValueAt(rowno, 0).toString());
        username.setText(mo.getValueAt(rowno, 1).toString());
        course.setSelectedItem(mo.getValueAt(rowno, 2).toString());
        branch.setSelectedItem(mo.getValueAt(rowno, 3).toString());
       
    }//GEN-LAST:event_userdetailsMouseClicked

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

    private void branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchActionPerformed

    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseActionPerformed

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
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> branch;
    private javax.swing.JComboBox<String> course;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSTableMetro userdetails;
    private app.bolivia.swing.JCTextField userid;
    private app.bolivia.swing.JCTextField username;
    // End of variables declaration//GEN-END:variables
}
