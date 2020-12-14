
package comic.station.entitas;

import comic.station.abstracts.DaftarKomik;
import comic.station.interfaces.InterKomikData;
import db_comic.koneksi_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Komik  extends DaftarKomik implements InterKomikData {
    private String id_komik;
    private String judul;
    private String pengarang;
    private int stok;
    private int harga;
    
    public Komik(){
    
    }
     public Komik(String id_komik,String judul,String pengarang,int stok,int harga){
      this.id_komik=id_komik;
      this.judul=judul;
      this.pengarang=pengarang;
      this.stok=stok;
      this.harga=harga;
    }
    @Override
    public void setIdKomik(String id_komik) {
        this.id_komik=id_komik;
    }

    @Override
    public String getIdKomik() {
        return id_komik;
    }
            
    @Override
    public void setJudul(String judul) {
        this.judul=judul;
    }

    @Override
    public String getJudul() {
        return judul;
    }

    @Override
    public void setPengarang(String pengarang) {
        this.pengarang=pengarang;
    }

    @Override
    public String getPengarang() {
        return pengarang;
    }

    @Override
    public void setStok(int stok) {
       this.stok=stok;
    }

    @Override
    public int getStok() {
        return stok;
    }

    @Override
    public void setHarga(int harga) {
        this.harga=harga;
    }

    @Override
    public int getHarga() {
        return harga;
    }

    @Override
    public Komik insert(Komik o) throws SQLException {
        PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("insert into komik values(?,?,?,?,?)");
        ps.setString(1, o.getIdKomik());
        ps.setString(2, o.getJudul());
        ps.setString(3, o.getPengarang());
        ps.setInt(4, o.getStok());
        ps.setInt(5, o.getHarga());
        ps.executeUpdate();
        return o;
    }

    @Override
    public void update(Komik o) throws SQLException {
        PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("update komik set judul=?,pengarang=?,stok=?,harga=? where id_komik=?");
        ps.setString(1, o.getJudul());
        ps.setString(2, o.getPengarang());
        ps.setInt(3, o.getStok());
        ps.setInt(4, o.getHarga());
        ps.setString(5, o.getIdKomik());
        ps.executeUpdate();
    }

    
    public void delete(String o) throws SQLException {
        PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("delete from komik where id_komik=?");
        ps.setString(1, o);
        ps.executeUpdate();
    }

    @Override
    public List<Komik> getAll() throws SQLException {
        Statement st=koneksi_db.koneksiDatabase().createStatement();
        ResultSet rs=st.executeQuery("select *from komik");
        List<Komik>list=new ArrayList<Komik>();
        while(rs.next()){
            Komik o=new Komik();
            o.setIdKomik(rs.getString("id_komik"));
            o.setJudul(rs.getString("judul"));
            o.setPengarang(rs.getString("pengarang"));
            o.setStok(rs.getInt("stok"));
            o.setHarga(rs.getInt("harga"));
            list.add(o);
        }
        return list;
    }
    @Override
    public ResultSet cekId(String id) throws SQLException {
        Statement st=koneksi_db.koneksiDatabase().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM komik where id_komik='"+id+"'");
        return rs;
    }
    @Override
    public void tampildata (DefaultTableModel dtm) throws SQLException{
        Statement st=koneksi_db.koneksiDatabase().createStatement();
        
        try {
            ResultSet rs=st.executeQuery("SELECT * FROM komik");
            Object [] data = new Object[5];
            while(rs.next()) {
                data[0] = rs.getInt("id_komik");
                data[1] = rs.getString("judul");
                data[2] = rs.getString("pengarang");
                data[3] = rs.getInt("stok");
                data[4] = rs.getInt("harga");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Komik.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    @Override
    public ResultSet caridataKomik(DefaultTableModel dtm, String cari) throws SQLException {
    String sql = "SELECT * FROM komik WHERE id_komik LIKE '%"+cari+"%' OR judul LIKE '%"+cari+"%' OR harga LIKE '%"+cari+"%'";
    PreparedStatement st = null;
    ResultSet rs=null;
    Connection connection;
    try{
        connection = koneksi_db.koneksiDatabase();
        st = connection.prepareStatement(sql);
        rs = st.executeQuery(sql);
        Object [] data = new Object[5];
          while(rs.next()){
          data[0] = rs.getString("id_komik");
          data[1] = rs.getString("judul");
          data[2] = rs.getString("pengarang");
          data[3] = rs.getInt("stok");
          data[4] = rs.getInt("harga");
          dtm.addRow(data);  
          }
    
    }catch(SQLException err){
            err.getMessage();
        }
    return rs;
    }
    

    
    

    

    
   

    

   
    
}
