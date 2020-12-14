/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comic.station.form;

import com.sun.glass.events.KeyEvent;
import comic.station.entitas.Pelanggan;
import db_comic.koneksi_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.*;
import comic.station.interfaces.InterPelanggan;

public class FormSignUp extends javax.swing.JFrame {
    private int id=0;
    private InterPelanggan daoPembeli;
     private void hakAkses(boolean akses){
        MasukSignUp.setEnabled(akses);
        
    }
    public FormSignUp() {
        initComponents();
        hakAkses(true);
        daoPembeli = new Pelanggan();
        kosongkanTeks();
        kolomId.setText(String.valueOf(cariID()));
    }
   boolean tidakBolehKosong() {
        if (!kolomId.getText().isEmpty()
                && !kolomNama.getText().isEmpty()
                && !kolomUsername.getText().isEmpty()
                && !kolomPassword.getText().isEmpty()
                ) {
            return true;
        } else {
            return false;
        }
    }
    public void validasi(){
       
        try{
            if (MasukSignUp.getText().equals("Sign up")){
                if (tidakBolehKosong()) {
                    Pelanggan p = new Pelanggan();
                    p.setIdPelanggan(Integer.parseInt(kolomId.getText()));
                    p.setNama(kolomNama.getText());
                    p.setUsername(kolomUsername.getText());
                    p.setPassword(kolomPassword.getText());
                    daoPembeli.insert(p);
                    this.dispose();
                    new FormLoginPelanggan().setVisible(true);
                }else  {
                    JOptionPane.showMessageDialog(this, "text tidak boleh ada yang kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                kosongkanTeks();
                JOptionPane.showMessageDialog(this, 
                        "Username dan Password tidak valid");
            
            }
           
        } catch(SQLException err){
            JOptionPane.showMessageDialog(this, "Terjadi Kesalahan:" 
                    + err.getMessage());
        }
    }
    public int cariID() {
        try {
            String sql = "select id_pelanggan from pelanggan order by id_pelanggan desc";
            Statement st = koneksi_db.koneksiDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("id_pelanggan");
            }

        } catch (SQLException ex) {

            Logger.getLogger(FormUbahDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++id;
    }
void kosongkanTeks() {
        kolomId.setText("");
        kolomNama.setText("");
        kolomUsername.setText("");
        kolomPassword.setText("");
       
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MasukSignUp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kolomUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kolomPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        kolomNama = new javax.swing.JTextField();
        kolomId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        kembali1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MasukSignUp.setText("Sign up");
        MasukSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MasukSignUpActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel1.setText("COMIC STATION");

        jLabel2.setText("Username");

        kolomUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolomUsernameActionPerformed(evt);
            }
        });

        jLabel3.setText("Password");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel4.setText("Sign Up");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/COMIS STATION fix.png"))); // NOI18N
        jLabel5.setText("jLabel5");

        kolomPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolomPasswordActionPerformed(evt);
            }
        });
        kolomPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                kolomPasswordKeyTyped(evt);
            }
        });

        jLabel8.setText("Nama");

        kolomId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolomIdActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        kembali1.setText("kembali");
        kembali1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembali1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(kolomId, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kolomPassword)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MasukSignUp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(kembali1)))
                        .addGap(23, 23, 23))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(183, 183, 183)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel8)))
                            .addGap(166, 166, 166))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(kolomUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(kolomNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(142, 142, 142)
                    .addComponent(jLabel1)
                    .addContainerGap(120, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kolomId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(kolomNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kolomUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kolomPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MasukSignUp)
                    .addComponent(kembali1))
                .addGap(63, 63, 63))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jLabel1)
                    .addContainerGap(675, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MasukSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MasukSignUpActionPerformed
        String id   =kolomId.getText();
        String name = kolomNama.getText();
        String user = kolomUsername.getText();
        String pass = kolomPassword.getText();
        if(id.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Id tidak boleh kosong");
        }else if(name.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong");
        }else if(user.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Username tidak boleh kosong");
        }else if(pass.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Password tidak boleh kosong");
        }else{
            validasi();
        }
        
    }//GEN-LAST:event_MasukSignUpActionPerformed

    private void kolomUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolomUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kolomUsernameActionPerformed

    private void kolomPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kolomPasswordKeyTyped
       if(evt.getKeyChar() == KeyEvent.VK_ENTER){
           String id   =kolomId.getText();
           String name = kolomNama.getText(); 
           String user = kolomUsername.getText();
           String pass = kolomPassword.getText();
            if(id.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Id tidak boleh kosong");
            }else if(name.trim().equals("")){
            JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong");
            }else if(user.trim().equals("")){
                JOptionPane.showMessageDialog(this, "Username tidak boleh kosong");
            }else if(pass.trim().equals("")){
                JOptionPane.showMessageDialog(this, "Password tidak boleh kosong");
            }else{
                validasi();
            }
        }
    }//GEN-LAST:event_kolomPasswordKeyTyped

    private void kolomPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolomPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kolomPasswordActionPerformed

    private void kolomIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolomIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kolomIdActionPerformed

    private void kembali1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembali1ActionPerformed
        dispose();
        new FormLoginPelanggan().setVisible(true);
    }//GEN-LAST:event_kembali1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MasukSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton kembali1;
    private javax.swing.JTextField kolomId;
    private javax.swing.JTextField kolomNama;
    private javax.swing.JPasswordField kolomPassword;
    private javax.swing.JTextField kolomUsername;
    // End of variables declaration//GEN-END:variables

   

   

   
}
