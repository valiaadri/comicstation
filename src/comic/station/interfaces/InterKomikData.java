
package comic.station.interfaces;

import comic.station.entitas.Komik;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public interface InterKomikData {
    Komik insert(Komik o)throws SQLException;

    void update(Komik o)throws SQLException;

    void delete(String o) throws SQLException;

    List<Komik>getAll() throws SQLException;
    
    public void tampildata (DefaultTableModel dtm)throws SQLException;
    
    public ResultSet cekId(String id) throws SQLException;
    
    public ResultSet caridataKomik(DefaultTableModel dtm, String cari) throws SQLException;

   
    
}
