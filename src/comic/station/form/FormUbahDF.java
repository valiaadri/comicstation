
package comic.station.form;

import comic.station.entitas.Komik;
import comic.station.interfaces.InterKomikData;
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
public class FormUbahDF extends javax.swing.JInternalFrame {
    private int id = 0;
    private List<Komik> records = new ArrayList<Komik>();
    private InterKomikData daoKomik;
    
    public FormUbahDF() {
        initComponents();
        daoKomik = new Komik();
        statusAwal();
        tabelKomik.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                TambahBtn.setText("Ubah");
                int row = tabelKomik.getSelectedRow();
                if (row != -1) {
                    isiTeks();
                }
            }
        });
    }
     public void isiTeks() {
        Komik k = records.get(tabelKomik.getSelectedRow());
        txtIdKomik.setText(k.getIdKomik());
        txtJudul.setText(k.getJudul());
        txtPengarang.setText(k.getPengarang());
        txtStok.setText(String.valueOf(k.getStok()));
        txtHarga.setText(String.valueOf(k.getHarga()));
        
    }
 public int cariID() {
        try {
            String sql = "select id_komik from komik order by id_komik desc";
            Statement st = koneksi_db.koneksiDatabase().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                id = rs.getInt("id_komik");
            }

        } catch (SQLException ex) {

            Logger.getLogger(FormUbahDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ++id;
    }
  void loadAllKomik() {
        try {
            records = daoKomik.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(FormUbahDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  void isiTabel() {
        Object data[][] = new Object[records.size()][5];
        int x = 0;
        for (Komik k : records) {
            data[x][0] = k.getIdKomik();
            data[x][1] = k.getJudul();
            data[x][2] = k.getPengarang();
            data[x][3] = k.getStok();
            data[x][4] = k.getHarga();
            x++;
        }
        String comic[] = {"ID", "Judul", "Pengarang", "Stok", "Harga"};
        tabelKomik.setModel(new DefaultTableModel(data, comic));
        jScrollPane1.setViewportView(tabelKomik);
    }
  public void kosongkanTeks() {
        txtJudul.setText("");
        txtPengarang.setText("");
        txtStok.setText("");
        txtHarga.setText("");
    }
  public boolean tidakBolehKosong() {
        if (!txtJudul.getText().isEmpty()
                && !txtPengarang.getText().isEmpty()
                && !txtStok.getText().isEmpty()
                && !txtHarga.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    public void statusAwal() {
        kosongkanTeks();
        loadAllKomik();
        isiTabel();
        TambahBtn.setText("Tambah");
        txtIdKomik.setText(String.valueOf(cariID()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtStok = new javax.swing.JTextField();
        TambahBtn = new javax.swing.JButton();
        HapusBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        CariBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKomik = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdKomik = new javax.swing.JTextField();
        txtJudul = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPengarang = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        TambahBtn.setText("Tambah");
        TambahBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahBtnActionPerformed(evt);
            }
        });

        HapusBtn.setText("Hapus");
        HapusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusBtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Cari");

        CariBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/search (1).png"))); // NOI18N
        CariBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 20)); // NOI18N
        jLabel6.setText("Tambah Dan Ubah Daftar Komik");

        tabelKomik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "judul", "Pengarang", "Stok", "Harga"
            }
        ));
        jScrollPane1.setViewportView(tabelKomik);

        jLabel1.setText("id Buku");

        jLabel2.setText("Judul");

        jLabel3.setText("Pengarang");

        jLabel4.setText("Stok");

        jLabel7.setText("Harga");

        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPengarang)
                                    .addComponent(txtStok, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtJudul)
                                    .addComponent(txtIdKomik, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtHarga, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel5)
                                .addGap(39, 39, 39)
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CariBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(TambahBtn)
                        .addGap(18, 18, 18)
                        .addComponent(HapusBtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CariBtn, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdKomik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TambahBtn)
                    .addComponent(HapusBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TambahBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahBtnActionPerformed
try {
            // TODO add your handling code here:
            if (TambahBtn.getText().equals("Tambah")) {
                if (tidakBolehKosong()) {
                    Komik k = new Komik();
                    k.setIdKomik(txtIdKomik.getText());
                    k.setJudul(txtJudul.getText());
                    k.setPengarang(txtPengarang.getText());
                    k.setStok(Integer.parseInt(txtStok.getText()));
                    k.setHarga(Integer.parseInt(txtHarga.getText()));
                    daoKomik.insert(k);
                } else {
                    JOptionPane.showMessageDialog(this, "text tidak boleh ada yang kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
                }
            } else if (tidakBolehKosong()) {
                    Komik k = new Komik();
                    k.setIdKomik(txtIdKomik.getText());
                    k.setJudul(txtJudul.getText());
                    k.setPengarang(txtPengarang.getText());
                    k.setStok(Integer.parseInt(txtStok.getText()));
                    k.setHarga(Integer.parseInt(txtHarga.getText()));
                    daoKomik.update(k);
            } else {
                JOptionPane.showMessageDialog(this, "text tidak boleh ada yang kosong", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FormUbahDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.statusAwal();
    }//GEN-LAST:event_TambahBtnActionPerformed

    private void HapusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusBtnActionPerformed
        try {
            if (tidakBolehKosong()) {
                if (JOptionPane.showConfirmDialog(this, "Apakah Anda yakin untuk menghapus kasir", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Komik k = records.get(tabelKomik.getSelectedRow());
                    daoKomik.delete(k.getIdKomik());
                }

            } else {
                JOptionPane.showMessageDialog(this, "Klik data pada tabel terlebih dahulu", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }


        } catch (SQLException ex) {
            Logger.getLogger(FormUbahDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.statusAwal();
    }//GEN-LAST:event_HapusBtnActionPerformed

    private void CariBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariBtnActionPerformed
        cari();
    }//GEN-LAST:event_CariBtnActionPerformed

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CariBtn;
    private javax.swing.JButton HapusBtn;
    private javax.swing.JButton TambahBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelKomik;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIdKomik;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JTextField txtPengarang;
    private javax.swing.JTextField txtStok;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables

private void cari() {
     String cari = txtcari.getText();
     
     DefaultTableModel dtm = (DefaultTableModel) tabelKomik.getModel();
     dtm.setRowCount(0);
    try {
        ResultSet rs = daoKomik.caridataKomik(dtm,cari);
        
    } catch (SQLException ex) {
        System.out.println(ex);
    }
     tabelKomik.setModel(dtm);
     
 }
}
