/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comic.station.form;


import comic.station.entitas.Komik;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import comic.station.entitas.Transaksi;
import comic.station.interfaces.InterTransaksi;
import db_comic.koneksi_db;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author RPL22
 */
public class FromTransaksiAdmin extends javax.swing.JInternalFrame {
    private int id=0;
    private Transaksi t;
    private String idtransaksi,jumlah,total,tanggal,norekening,nama,nohp,alamat,idkomik;
    private InterTransaksi daoTrans;   
    private ResultSet rs;  
    private double bayar,kem;
    private DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    private DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    public FromTransaksiAdmin() throws SQLException {
        initComponents();
        daoTrans= new Transaksi(); 
        t = new Transaksi();
        tampildata();
        setobjek(false);
        txtjudul.setEnabled(false);
        txtharga.setEnabled(false);
        baru.setEnabled(true);
        update.setEnabled(false);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        edit.setEnabled(false);
        canceledit.setVisible(false);
        try {
            ResultSet rs = t.setcombobox();
            while (rs.next()) {
            cbkomik.addItem(rs.getString("id_komik"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FromTransaksiAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp); 
        txtidtransaksi.setText(String.valueOf(cariID()));
    }

    public int cariID() {
        try {
            String sql = "select id_transaksi from transaksi order by id_transaksi desc";
            Statement st = koneksi_db.koneksiDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("id_transaksi");
            }

        } catch (SQLException ex) {

            Logger.getLogger(FormUbahDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++id;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel18 = new javax.swing.JLabel();
        txtnamauser4 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtidtransaksi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtjumlah = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtotal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtnorek = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbkomik = new javax.swing.JComboBox();
        txtjudul = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtnohp = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        edit = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        baru = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtransaksi = new javax.swing.JTable();
        canceledit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        hapus = new javax.swing.JButton();
        update = new javax.swing.JButton();
        txtTanggal = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        kembalian = new javax.swing.JLabel();
        lblkembalian = new javax.swing.JLabel();
        txtuangyangdibayar = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtiduser1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtusername1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtpassword1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtnamauser1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbuser1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        simpan1 = new javax.swing.JButton();
        hapus1 = new javax.swing.JButton();
        baru1 = new javax.swing.JButton();
        update1 = new javax.swing.JButton();
        edit1 = new javax.swing.JButton();
        cbstatus1 = new javax.swing.JComboBox();

        jLabel18.setText("Nama           :");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Form input transaksi admin");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("ID Transaksi  :");

        jLabel3.setText("Jumlah          :");

        txtjumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtjumlahKeyReleased(evt);
            }
        });

        jLabel4.setText("Total             :");

        jLabel5.setText("No rekening   :");

        jLabel6.setText("ID Komik       :");

        cbkomik.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih ID Komik" }));
        cbkomik.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbkomikPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbkomik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkomikActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("| Input Data Transaksi");

        jLabel16.setText("Nama            :");

        jLabel17.setText("No Hp           :");

        jLabel19.setText("Alamat          :");

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        baru.setText("Baru");
        baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baruActionPerformed(evt);
            }
        });

        tbtransaksi.setBackground(new java.awt.Color(204, 204, 204));
        tbtransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaksi", "Jumlah", "Total", "No rekening", "Tanggal", "Nama", "No Hp", "Alamat", "ID komik"
            }
        ));
        tbtransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbtransaksi);
        if (tbtransaksi.getColumnModel().getColumnCount() > 0) {
            tbtransaksi.getColumnModel().getColumn(2).setResizable(false);
        }

        canceledit.setText("Cancel Edit");
        canceledit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canceleditActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("| List Transaksi");

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel20.setText("Tanggal         :");

        jLabel1.setText("Harga:");

        jLabel21.setText("Jumlah yang dibayarkan");

        kembalian.setText("Kembalian");

        lblkembalian.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblkembalian.setText("-");

        txtuangyangdibayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtuangyangdibayarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtuangyangdibayarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(canceledit)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(baru)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(update)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(simpan)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(hapus)))))
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel15)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbkomik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtharga)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel20)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel17))
                                            .addComponent(jLabel16))
                                        .addGap(41, 41, 41)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtidtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtnorek, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtnohp)
                                                .addComponent(txtalamat, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(kembalian, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addComponent(txtuangyangdibayar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblkembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtidtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtuangyangdibayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblkembalian)
                            .addComponent(kembalian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtnorek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtnohp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbkomik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpan)
                            .addComponent(hapus)
                            .addComponent(baru)
                            .addComponent(update))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(canceledit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel16, jLabel17, jLabel19, jLabel2, jLabel20, jLabel3, jLabel4, jLabel5, txtTanggal, txtalamat, txtidtransaksi, txtjumlah, txtnama, txtnohp, txtnorek, txtotal});

        jInternalFrame1.setClosable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("USER");

        jLabel9.setText("ID User          :");

        jLabel10.setText("Username      :");

        jLabel11.setText("Password       :");

        jLabel12.setText("Nama User     :");

        jLabel13.setText("ID Level         :");

        tbuser1.setBackground(new java.awt.Color(204, 204, 204));
        tbuser1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID User", "Username", "Password", "Nama User", "ID Level"
            }
        ));
        tbuser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbuser1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbuser1);

        jLabel14.setText("| List User");

        simpan1.setText("Simpan");
        simpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpan1ActionPerformed(evt);
            }
        });

        hapus1.setText("Hapus");
        hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus1ActionPerformed(evt);
            }
        });

        baru1.setText("Baru");
        baru1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baru1ActionPerformed(evt);
            }
        });

        update1.setText("Update");
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });

        edit1.setText("Edit");
        edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit1ActionPerformed(evt);
            }
        });

        cbstatus1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Level Pengguna", "Administrator", "Waiter", "Kasir", "Owner", "Pelanggan" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jLabel8))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel9))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(edit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(baru1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(update1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(simpan1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(hapus1))
                                            .addComponent(txtiduser1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtnamauser1)
                                            .addComponent(txtpassword1)
                                            .addComponent(txtusername1)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cbstatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtiduser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtusername1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtpassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtnamauser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cbstatus1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan1)
                    .addComponent(hapus1)
                    .addComponent(baru1)
                    .addComponent(update1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edit1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 457, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 457, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 412, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 412, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbuser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbuser1MouseClicked
        // TODO add your handling code here:
        total();
    }//GEN-LAST:event_tbuser1MouseClicked

    private void simpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simpan1ActionPerformed

    private void hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hapus1ActionPerformed

    private void baru1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baru1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_baru1ActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_update1ActionPerformed

    private void edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edit1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        try {
            // TODO add your handling code here:
            updatedata();

            update.setEnabled(true);
            edit.setEnabled(false);
            simpan.setEnabled(false);
            hapus.setEnabled(false);
            baru.setEnabled(true);
            canceledit.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(FromTransaksiAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try {
            // TODO add your handling code here:
            hapusdata();
        } catch (SQLException ex) {
            Logger.getLogger(FromTransaksiAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        baru.setEnabled(true);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        update.setEnabled(false);
        edit.setEnabled(false);
        canceledit.setVisible(false);
    }//GEN-LAST:event_hapusActionPerformed

    private void canceleditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canceleditActionPerformed
        // TODO add your handling code here:
        baru();
        baru.setEnabled(true);
        update.setEnabled(false);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        edit.setEnabled(false);
    }//GEN-LAST:event_canceleditActionPerformed

    private void tbtransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtransaksiMouseClicked
        // TODO add your handling code here:
        setformtable();
        baru.setEnabled(true);
        edit.setEnabled(true);
        hapus.setEnabled(true);
        update.setEnabled(false);
        simpan.setEnabled(false);
        canceledit.setVisible(false);
    }//GEN-LAST:event_tbtransaksiMouseClicked

    private void baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baruActionPerformed
        // TODO add your handling code here:
        baru();
        setobjek(true);
        txtidtransaksi.requestFocus();
        simpan.setEnabled(true);
        update.setEnabled(false);
        edit.setEnabled(false);
        hapus.setEnabled(false);
        update.setEnabled(false);
        canceledit.setVisible(false);
    }//GEN-LAST:event_baruActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed

        try {
            // TODO add your handling code here:
            simpandata();

            baru.setEnabled(true);
            simpan.setEnabled(true);
            hapus.setEnabled(false);
            update.setEnabled(false);
            edit.setEnabled(false);
            canceledit.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(FromTransaksiAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        setobjek(true);
        edit.setVisible(true);
        update.setEnabled(true);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        baru.setEnabled(false);
        canceledit.setVisible(true);
    }//GEN-LAST:event_editActionPerformed

    private void cbkomikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkomikActionPerformed
        // TODO add your handling code here
        
    }//GEN-LAST:event_cbkomikActionPerformed

    private void cbkomikPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbkomikPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        carikomik();
    }//GEN-LAST:event_cbkomikPopupMenuWillBecomeInvisible

    private void txtjumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlahKeyReleased
        // TODO add your handling code here:
        if(!txtjumlah.getText().equalsIgnoreCase("")){
            int satuan  = Integer.valueOf(txtharga.getText());
            int jumlah =  Integer.valueOf(txtjumlah.getText());
            int total =  satuan*jumlah;
            txtotal.setText(String.valueOf(total));
            
        }
    }//GEN-LAST:event_txtjumlahKeyReleased

    private void txtuangyangdibayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuangyangdibayarKeyReleased
        // TODO add your handling code here:
        if (!txtuangyangdibayar.getText().equalsIgnoreCase("")&& !txtjumlah.getText().equalsIgnoreCase("")) {
            bayar = Double.parseDouble(txtuangyangdibayar.getText());
            int jumlah=Integer.parseInt(txtjumlah.getText());
            Double total = Double.parseDouble(txtotal.getText());
            kem = bayar-(total);

            if (kem < 0) {
                kembalian.setVisible(false);
                lblkembalian.setText("Jumlah uang kurang");
                lblkembalian.setForeground(new java.awt.Color(255, 51, 51));
                simpan.setEnabled(false);
            }else{
                kembalian.setVisible(true);
                lblkembalian.setText(String.valueOf(+kem));
                lblkembalian.setText(kursIndonesia.format(kem));
                lblkembalian.setForeground(new java.awt.Color(0,0,0));
                simpan.setEnabled(true);

            }
        }
    }//GEN-LAST:event_txtuangyangdibayarKeyReleased

    private void txtuangyangdibayarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuangyangdibayarKeyTyped
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if(Character.isAlphabetic(enter)){
            evt.consume();
            lblkembalian.setText("Inputan harus angka");
            lblkembalian.setForeground(new java.awt.Color(255, 51, 51));
            kembalian.setVisible(false);

        }
    }//GEN-LAST:event_txtuangyangdibayarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baru;
    private javax.swing.JButton baru1;
    private javax.swing.JButton canceledit;
    private javax.swing.JComboBox cbkomik;
    private javax.swing.JComboBox cbstatus1;
    private javax.swing.JButton edit;
    private javax.swing.JButton edit1;
    private javax.swing.JButton hapus;
    private javax.swing.JButton hapus1;
    private javax.swing.JInternalFrame jInternalFrame1;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kembalian;
    private javax.swing.JLabel lblkembalian;
    private javax.swing.JButton simpan;
    private javax.swing.JButton simpan1;
    private javax.swing.JTable tbtransaksi;
    private javax.swing.JTable tbuser1;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtidtransaksi;
    private javax.swing.JTextField txtiduser1;
    private javax.swing.JTextField txtjudul;
    private javax.swing.JTextField txtjumlah;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnamauser1;
    private javax.swing.JTextField txtnamauser4;
    private javax.swing.JTextField txtnohp;
    private javax.swing.JTextField txtnorek;
    private javax.swing.JTextField txtotal;
    private javax.swing.JTextField txtpassword1;
    public javax.swing.JTextField txtuangyangdibayar;
    private javax.swing.JTextField txtusername1;
    private javax.swing.JButton update;
    private javax.swing.JButton update1;
    // End of variables declaration//GEN-END:variables
private void simpandata() throws SQLException {
    try{
        idtransaksi = txtidtransaksi.getText();
        jumlah = txtjumlah.getText();
        total = txtotal.getText();
        norekening = txtnorek.getText();
        tanggal=txtTanggal.getText();
        nama=txtnama.getText();
        nohp=txtnohp.getText();
        alamat=txtalamat.getText();
        idkomik = (String) cbkomik.getSelectedItem();
        
        if (txtidtransaksi.getText().isEmpty() || txtjumlah.getText().isEmpty() || txtotal.getText().isEmpty() || txtnorek.getText().isEmpty()|| txtTanggal.getText().isEmpty()|| txtnama.getText().isEmpty()|| txtnohp.getText().isEmpty()|| txtalamat.getText().isEmpty() || cbkomik.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane,"Silahkan isi data terlebih dahulu !","Informasi",JOptionPane.INFORMATION_MESSAGE);
        } else {
                    t.setIdTransaksi(Integer.parseInt(txtidtransaksi.getText()));
                    t.setJumlah(Integer.parseInt(txtjumlah.getText()));
                    t.setTotalUang(Integer.parseInt(txtotal.getText()));
                    t.setNoRekening(txtnorek.getText());
                    t.setTanggal(txtTanggal.getText());
                    t.setNamaPlgn(txtnama.getText());
                    t.setNoTlp(txtnohp.getText());
                    t.setAlamat(txtalamat.getText());
                    t.setIdKomik((String)cbkomik.getSelectedItem());
                    t.insert();
            
            JOptionPane.showMessageDialog(rootPane,"Data berhasil disimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
            tampildata();
            baru();
            setobjek(false);
        }
    }catch (SQLException ex) {
        System.out.println(ex);
    }      
}
private void total() {
        try {
            String value  = tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 0).toString();
            ResultSet rs = t.total(value);
            if (rs.next()) {
            txtotal.setText(rs.getObject("total").toString());
               
            }  
        } catch (SQLException ex) {
            System.out.println(ex);
        }
 }
private void tampildata () throws SQLException {
    DefaultTableModel dtm = (DefaultTableModel) tbtransaksi.getModel();
    dtm.setRowCount(0);
    t.tampildata(dtm);
    tbtransaksi.setModel(dtm);
}

private void setformtable() {
     txtidtransaksi.setText(tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 0).toString());
     txtjumlah.setText(tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 1).toString());
     txtotal.setText(tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 2).toString());
     txtnorek.setText(tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 3).toString());
     txtTanggal.setText(tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 4).toString());
     txtnama.setText(tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 5).toString());
     txtnohp.setText(tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 6).toString());
     txtalamat.setText(tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 7).toString());
     
        try {
            
            ResultSet rs = t.cekId(tbtransaksi.getValueAt(tbtransaksi.getSelectedRow(), 8).toString());
            while(rs.next()){
                cbkomik.setSelectedItem(rs.getString("id_komik"));
                txtjudul.setText(rs.getString("judul"));
                txtharga.setText(rs.getString("harga"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FromTransaksiAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
}

private void hapusdata() throws SQLException {
    idtransaksi = txtidtransaksi.getText();
    
    int conf = JOptionPane.showConfirmDialog(rootPane,"Apakah anda yakin akan menghapus data ini ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
    if (conf == 0) {
        daoTrans.delete(t.getIdTransaksi());
    JOptionPane.showMessageDialog(rootPane,"Data berhasil dihapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
    tampildata();
        baru();
        setobjek(false);
    }
    
} 

private void updatedata() throws SQLException {
   try{
        idtransaksi = txtidtransaksi.getText();
        jumlah = txtjumlah.getText();
        total = txtotal.getText();
        norekening = txtnorek.getText();
        tanggal=txtTanggal.getText();
        nama=txtnama.getText();
        nohp=txtnohp.getText();
        alamat=txtalamat.getText();
        idkomik = (String) cbkomik.getSelectedItem();
        int conf = JOptionPane.showConfirmDialog(rootPane,"Apakah anda yakin akan mengubah data ini ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (conf == 0) {
                    t.setIdTransaksi(Integer.parseInt(txtidtransaksi.getText()));
                    t.setJumlah(Integer.parseInt(txtjumlah.getText()));
                    t.setTotalUang(Integer.parseInt(txtotal.getText()));
                    t.setNoRekening(txtnorek.getText());
                    t.setNamaPlgn(txtnama.getText());
                    t.setTanggal(txtTanggal.getText());
                    t.setNoTlp(txtnohp.getText());
                    t.setAlamat(txtalamat.getText());
                    t.setIdKomik((String)cbkomik.getSelectedItem());
                    t.update();
            tampildata();
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil Diubah","Informasi",JOptionPane.INFORMATION_MESSAGE);
            baru();
            setobjek(false);
        }
      }catch (SQLException ex) {
            System.out.println(ex);
        }
    }

private void baru() {
    txtidtransaksi.setText(null);
    txtjumlah.setText(null);
    txtotal.setText(null);
    txtnorek.setText(null);
    txtnama.setText(null);
    txtTanggal.setText(null);
    txtnohp.setText(null);
    txtalamat.setText(null);
    cbkomik.setSelectedIndex(0); 
    txtjudul.setText(null);
    txtharga.setText(null);
}

private void setobjek(boolean b) {
    txtidtransaksi.setEnabled(b);
    txtjumlah.setEnabled(b);
    txtotal.setEnabled(b);
    txtnorek.setEnabled(b);
    txtTanggal.setEnabled(b);
    txtnama.setEnabled(b);
    txtnohp.setEnabled(b);
    txtharga.setEnabled(b);
    txtalamat.setEnabled(b);
    cbkomik.setEnabled(b);

}

private void carikomik () {
     try {
            String judul = txtjudul.getText();
            String harga = txtharga.getText();
            ResultSet rs = t.cekId(cbkomik.getSelectedItem().toString());
            while (rs.next()) {
                txtjudul.setText(rs.getString("judul"));
                txtharga.setText(rs.getString("harga"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FromTransaksiAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
}     
    



}












