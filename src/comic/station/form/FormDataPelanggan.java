/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comic.station.form;
import comic.station.abstracts.user;
import comic.station.entitas.Komik;
import comic.station.entitas.Pelanggan;
import db_comic.koneksi_db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import comic.station.interfaces.InterPelanggan;
/**
 *
 * @author ASUS
 */
public class FormDataPelanggan extends javax.swing.JInternalFrame {

   private int id = 0;
    private List<Pelanggan> records = new ArrayList<Pelanggan>();
    private InterPelanggan daoPembeli;
    public FormDataPelanggan() {
        initComponents();
        daoPembeli = new Pelanggan();
        statusAwal();
        
        tabelUser.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                BtnTambahUbah.setText("Ubah");
                int row = tabelUser.getSelectedRow();
                if (row != -1) {
                    isiTeks();
                }
            }
        });
    }

    void loadAllUser() {
        try {
            records = daoPembeli.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(FormDataPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   void isiTabel() {
        Object data[][] = new Object[records.size()][5];
        int x = 0;
        for (Pelanggan p : records) {
            data[x][0] = p.getIdPelanggan();
            data[x][1] = p.getNama();
            data[x][2] = p.getUsername();
            data[x][3] = p.getPassword();
            
            x++;
        }
        String comic[] = {"ID", "Nama", "Username", "Password"};
        tabelUser.setModel(new DefaultTableModel(data, comic));
        jScrollPane1.setViewportView(tabelUser);
    }
    void kosongkanTeks() {
        txtID.setText("");
        txtNama.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
       
    }
   void isiTeks() {
        Pelanggan p = records.get(tabelUser.getSelectedRow());
        txtID.setText(String.valueOf(p.getIdPelanggan()));
        txtNama.setText(p.getNama());
        txtUsername.setText(p.getUsername());
        txtPassword.setText(p.getPassword());
       
        
        
    }
 
    
    private void refreshDataInTable(){
        DefaultTableModel tabelModel;
        tabelModel = (DefaultTableModel) tabelUser.getModel();
        int jumlahBaris = tabelUser.getRowCount();
        for(int i = 0; i < jumlahBaris; i++){
            tabelModel.removeRow(0);
        }
        loadAllUser();
    }
    
    

    boolean tidakBolehKosong() {
        if (!txtID.getText().isEmpty()
                && !txtNama.getText().isEmpty()
                && !txtUsername.getText().isEmpty()
                && !txtPassword.getText().isEmpty()
                ) {
            return true;
        } else {
            return false;
        }
    }
   
    void statusAwal() {
        kosongkanTeks();
        loadAllUser();
        isiTabel();
        txtID.setText(String.valueOf(cariID()));
         
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNama = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelUser = new javax.swing.JTable();
        BtnTambahUbah = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        tabelUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Username", "Password"
            }
        ));
        jScrollPane1.setViewportView(tabelUser);

        BtnTambahUbah.setText("Tambah");
        BtnTambahUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahUbahActionPerformed(evt);
            }
        });

        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setText("Data Pelanggan");

        jLabel2.setText("Nama");

        jLabel6.setText("ID");

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(BtnTambahUbah))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(txtUsername)
                            .addComponent(txtPassword)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Hapus))
                            .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTambahUbah)
                    .addComponent(Hapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnTambahUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahUbahActionPerformed
        try {
            // TODO add your handling code here:
            if (BtnTambahUbah.getText().equals("Tambah")) {
                if (tidakBolehKosong()) {
                    Pelanggan p = new Pelanggan();
                    p.setIdPelanggan(Integer.parseInt(txtID.getText()));
                    p.setNama(txtNama.getText());
                    p.setUsername(txtUsername.getText());
                    p.setPassword(txtPassword.getText());

                    daoPembeli.insert(p);
                } else {
                    JOptionPane.showMessageDialog(this, "text tidak boleh ada yang kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            } else if (tidakBolehKosong()) {
                Pelanggan p = new Pelanggan();
                p.setIdPelanggan(Integer.parseInt(txtID.getText()));
                p.setNama(txtNama.getText());
                p.setUsername(txtUsername.getText());
                p.setPassword(txtPassword.getText());

                daoPembeli.update(p);
            } else {
                JOptionPane.showMessageDialog(this, "text tidak boleh ada yang kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FormUbahDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.statusAwal();
    }//GEN-LAST:event_BtnTambahUbahActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        try {
            // TODO add your handling code here:

            if (tidakBolehKosong()) {
                if (JOptionPane.showConfirmDialog(this, "Apakah Anda yakin untuk menghapus kasir", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Pelanggan p = records.get(tabelUser.getSelectedRow());
                    daoPembeli.delete(p.getIdPelanggan());
                }

            } else {
                JOptionPane.showMessageDialog(this, "Klik data pada tabel terlebih dahulu", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FormDataPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.statusAwal();
    }//GEN-LAST:event_HapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnTambahUbah;
    private javax.swing.JButton Hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelUser;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
