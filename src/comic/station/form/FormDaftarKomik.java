
package comic.station.form;

import comic.station.entitas.Komik;
import comic.station.interfaces.InterKomikData;
import db_comic.koneksi_db;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormDaftarKomik extends javax.swing.JInternalFrame {
    private int id = 0;
    private List<Komik> records = new ArrayList<Komik>();
    private InterKomikData daoKomik;
    public void loadAllKomik() {
        try {
            records = daoKomik.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(FormDaftarKomik.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void isiTabel() {
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
    private void refreshDataInTable(){
        DefaultTableModel tabelModel;
        tabelModel = (DefaultTableModel) tabelKomik.getModel();
        int jumlahBaris = tabelKomik.getRowCount();
        for(int i = 0; i < jumlahBaris; i++){
            tabelModel.removeRow(0);
        }
        loadAllKomik();
    }
    public FormDaftarKomik() {
        initComponents();
        daoKomik = new Komik();
        loadAllKomik();
        isiTabel();
        
        
    }

    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKomik = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        Btncari = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setText("Daftar Komik");

        tabelKomik.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Judul", "Pengarang", "Stok", "Harga", "Aksi"
            }
        ));
        jScrollPane1.setViewportView(tabelKomik);

        Btncari.setText("Cari");
        Btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtncariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btncari))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btncari))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtncariActionPerformed
        cari();
    }//GEN-LAST:event_BtncariActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btncari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelKomik;
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
