
package comic.station.interfaces;

import comic.station.entitas.Pelanggan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public interface InterPelanggan {
    
    public abstract List<Pelanggan>getAll() throws SQLException;
    
    public abstract Pelanggan insert(Pelanggan o) throws SQLException ;

    public abstract void update(Pelanggan o) throws SQLException ;
       
    public abstract  void delete(int o) throws SQLException;
}
