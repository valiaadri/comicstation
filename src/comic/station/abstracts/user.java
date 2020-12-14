
package comic.station.abstracts;

import comic.station.entitas.Komik;
import comic.station.entitas.Admin;
import db_comic.koneksi_db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;


public abstract class user {
    public String nama;
    public String username;
    public String password;
    
    public abstract void setNama (String nama);
    public abstract String getNama();
    
    public abstract void setUsername(String username);
    public abstract String getUsername();
    
    public abstract void setPassword(String password);
    public abstract String getPassword();
    
    
    
   
    
      
    
}
