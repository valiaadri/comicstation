
package comic.station.form;

import comic.station.entitas.Transaksi;
import comic.station.interfaces.InterTransaksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class FormLaporanTransaksi extends javax.swing.JInternalFrame {
    private int id = 0;
    private List<Transaksi> records = new ArrayList<Transaksi>();
    private InterTransaksi daoTransaksi;
   
    public FormLaporanTransaksi() {
        initComponents();
         daoTransaksi = new Transaksi();
         loadAllKomik();
         isiTabel();
    }
    void loadAllKomik() {
        try {
            
            records = daoTransaksi.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(FormUbahDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  void isiTabel() {
        Object data[][] = new Object[records.size()][9];
        int x = 0;
        for (Transaksi t : records ) {
            data[x][0] = t.getIdTransaksi();
            data[x][1] = t.getJumlah();
            data[x][2] = t.getTotalUang();
            data[x][3] = t.getNoRekening();
            data[x][4] = t.getTanggal();
            data[x][5] = t.getNamaPlgn();
            data[x][6] = t.getNoTlp();
            data[x][7] = t.getAlamat();
            data[x][8] = t.getIdKomik();
            x++;
        }
        
        String trans[] = {"ID Transaksi", "Jumlah","Total","No Rekening","Tanggal","Nama","No tlp","Alamat","ID Komik"};
        tabelTransaksi.setModel(new DefaultTableModel(data, trans));
        jScrollPane1.setViewportView(tabelTransaksi);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        Btncari = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setText("Laporan Transaksi");

        tabelTransaksi.setAutoCreateRowSorter(true);
        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id Transaksi", "Jumlah", "Total", "No Rekening", "Tanggal", "Nama", "Nomor Telepon", "Alamat", "id_Komik"
            }
        ));
        tabelTransaksi.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tabelTransaksi);
        if (tabelTransaksi.getColumnModel().getColumnCount() > 0) {
            tabelTransaksi.getColumnModel().getColumn(3).setResizable(false);
        }

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
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Btncari))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btncari))
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
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
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables

private void cari() {
     String cari = txtcari.getText();
     
     DefaultTableModel dtm = (DefaultTableModel)tabelTransaksi.getModel();
     dtm.setRowCount(0);
    try {
        ResultSet rs = daoTransaksi.caridataTransaksi(dtm,cari);
        
    } catch (SQLException ex) {
        System.out.println(ex);
    }
     tabelTransaksi.setModel(dtm);
     
 }

}
