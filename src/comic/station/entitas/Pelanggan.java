package comic.station.entitas;

import comic.station.abstracts.user;
import db_comic.koneksi_db;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import comic.station.interfaces.InterPelanggan;


public class Pelanggan extends user implements InterPelanggan{
    private int id_pelanggan;
    
    public Pelanggan(){
    
    }
    public Pelanggan(int id_pelanggan,String nama,String username,String password){
        this.id_pelanggan=id_pelanggan;
        this.nama=nama;
        this.username=username;
        this.password=password;
        
   }
    
    public void setIdPelanggan(int id_pelanggan) {
        this.id_pelanggan=id_pelanggan;
    }

   
    public int getIdPelanggan() {
        return id_pelanggan;
    }

    @Override
    public void setNama(String nama) {
        this.nama=nama;
    }

    @Override
    public String getNama() {
        return nama;
    }

    @Override
    public void setUsername(String username) {
        this.username=username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setPassword(String password) {
        this.password=password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public List<Pelanggan> getAll() throws SQLException {
        Statement st=koneksi_db.koneksiDatabase().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM pelanggan");
        List<Pelanggan>list=new ArrayList<Pelanggan>();
        while(rs.next()){
            Pelanggan p=new Pelanggan();
            p.setIdPelanggan(rs.getInt("id_pelanggan"));
            p.setNama(rs.getString("nama"));
            p.setUsername(rs.getString("username"));
            p.setPassword(rs.getString("pass"));
            list.add(p);
    }   
        return list;
}

    @Override
    public Pelanggan insert(Pelanggan o) throws SQLException {
       PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("INSERT INTO pelanggan (id_pelanggan,nama,username,pass) VALUES (?,?,?,?)");
        ps.setInt(1, o.getIdPelanggan());
        ps.setString(2, o.getNama());
        ps.setString(3, o.getUsername());
        ps.setString(4, o.getPassword());
        ps.executeUpdate();
        return o;
    }

    @Override
    public void update(Pelanggan o) throws SQLException {
        PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("UPDATE pelanggan SET nama=?,username=?,pass=? WHERE id_pelanggan=?");
        ps.setString(1, o.getNama());
        ps.setString(2, o.getUsername());
        ps.setString(3, o.getPassword());
        ps.setInt(4, o.getIdPelanggan());
        ps.executeUpdate();
    }

    @Override
    public void delete(int o) throws SQLException {
        PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("DELETE FROM pelaggan WHERE id_pelanggan=?");
        ps.setInt(1, o);
        ps.executeUpdate();
    }

    
   
}
 
