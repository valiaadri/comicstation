
package comic.station.interfaces;

import comic.station.entitas.Transaksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public interface InterTransaksi {
    void insert()throws SQLException;

    void update()throws SQLException;

    void delete(int o) throws SQLException;

    List<Transaksi>getAll() throws SQLException;
    
    public void tampil(DefaultTableModel dtm) throws SQLException;
    
    public ResultSet cekId(String id) throws SQLException;
    
    public ResultSet caridataKomik(DefaultTableModel dtm, String cari) throws SQLException;
    
    public ResultSet caridataTransaksi(DefaultTableModel dtm, String cari) throws SQLException;
    
    public ResultSet setcombobox() throws SQLException;
    
    public void tampildata (DefaultTableModel dtm)throws SQLException;
    
    public ResultSet total (String total) throws SQLException;
}
