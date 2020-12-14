
package comic.station.entitas;

import comic.station.entitas.Komik;
import comic.station.abstracts.DaftarTransaksi;
import comic.station.interfaces.InterTransaksi;
import comic.station.interfaces.InterKomikData;
import comic.station.abstracts.DaftarKomik;
import com.toedter.calendar.JDateChooser;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Transaksi extends DaftarTransaksi implements InterTransaksi{
    private int id_transaksi;
    private int jumlah;
    private int TotalUang;
    private String noRekening;
    private String tanggal;
    private String nama_plgn;
    private String no_tlp;
    private String alamat;
    
    private String id_komik;
    private String judul;
    private String pengarang;
    private int stok;
    private int harga;
    
    public Transaksi(){
        
    }
    
    public Transaksi(int id_transaksi,String id_komik, int jumlah,int TotalUang,String noRekening,String tanggal,String nama_plgn,String no_tlp,String alamat){
     this.id_transaksi=id_transaksi;
     this.id_komik=id_komik;
     this.jumlah=jumlah;
     this.TotalUang=TotalUang;
     this.noRekening=noRekening;
     this.tanggal=tanggal;
     this.nama_plgn=nama_plgn;
     this.no_tlp=no_tlp;
     this.alamat=alamat;
    }
    @Override
    public void setIdTransaksi(int id_transaksi){
        this.id_transaksi=id_transaksi;
    }
    @Override
    public int getIdTransaksi(){
        return id_transaksi;
    }
    @Override
    public void setJumlah(int jumlah) {
        this.jumlah=jumlah;
    }
    @Override
    public int getJumlah() {
        return jumlah;
    }
    @Override
    public void setTotalUang(int TotalUang) {
        this.TotalUang=TotalUang;
    }

    @Override
    public int getTotalUang() {
        return TotalUang;
    }
    @Override
    public void setNoRekening(String noRekening) {
        this.noRekening=noRekening;
    }

    @Override
    public String getNoRekening() {
        return noRekening;
    }
    @Override
    public void setTanggal(String tanggal) {
        this.tanggal=tanggal;
    }
    @Override
    public String getTanggal() {
        return tanggal;
    }
    @Override
    public void setNamaPlgn(String nama_plgn){
        this.nama_plgn=nama_plgn;
    }
    @Override
    public String getNamaPlgn(){
        return nama_plgn;
    }
    @Override
    public void setNoTlp(String no_tlp){
        this.no_tlp=no_tlp;
    }
    @Override
    public String getNoTlp(){
        return no_tlp;
    }
    @Override
    public void setAlamat(String alamat){
        this.alamat=alamat;
    }
    @Override
    public String getAlamat(){
        return alamat;
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
    public void insert() throws SQLException {
        
        PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("insert into transaksi values(?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, this.getIdTransaksi());
        ps.setInt(2, this.getJumlah());
        ps.setInt(3, this.getTotalUang());
        ps.setString(4, this.getNoRekening());
        ps.setString(5, this.getTanggal());
        ps.setString(6, this.getNamaPlgn());
        ps.setString(7, this.getNoTlp());
        ps.setString(8, this.getAlamat());
        ps.setString(9, this.getIdKomik());
        ps.executeUpdate(); 
        
    }

    @Override
    public void update() throws SQLException {
        PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("update transaksi set jumlah=?,total=?,noRekening=?,tanggal=?,Nama=?,no_tlp=?,alamat=?,id_komik=? where id_transaksi=?");
        ps.setInt(1, this.getJumlah()); 
        ps.setInt(2, this.getTotalUang());
        ps.setString(3, this.getNoRekening()); 
        ps.setString(4, this.getTanggal());
        ps.setString(5, this.getNamaPlgn());
        ps.setString(6, this.getNoTlp()); 
        ps.setString(7, this.getAlamat());
        ps.setString(8, this.getIdKomik());
        ps.setInt(9, this.getIdTransaksi()); 
        ps.executeUpdate();
    }

    @Override
    public List<Transaksi> getAll() throws SQLException {
        Statement st=koneksi_db.koneksiDatabase().createStatement();
        ResultSet rs=st.executeQuery("SELECT transaksi.id_transaksi, komik.id_komik, komik.judul, komik.pengarang, komik.stok,komik.harga, transaksi.jumlah, transaksi.total,transaksi.noRekening, transaksi.tanggal, transaksi.Nama, transaksi.no_tlp, transaksi.alamat\n" +"\n" +
                        "FROM `komik`,transaksi \n" +
                        "WHERE transaksi.id_transaksi = komik.id_komik   GROUP BY transaksi.id_transaksi");
        List<Transaksi>list=new ArrayList<Transaksi>();
        while(rs.next()){
            Transaksi o=new Transaksi();
            
            o.setIdTransaksi(rs.getInt("id_transaksi"));
            o.setJudul(rs.getString("judul"));
            o.setPengarang(rs.getString("pengarang"));
            o.setStok(rs.getInt("stok"));
            o.setHarga(rs.getInt("harga"));
            o.setJumlah(rs.getInt("jumlah"));
            o.setTotalUang(rs.getInt("total"));
            o.setNoRekening(rs.getString("noRekening"));
            o.setTanggal(rs.getString("tanggal"));
            o.setNamaPlgn(rs.getString("Nama"));
            o.setNoTlp(rs.getString("no_tlp"));
            o.setAlamat(rs.getString("alamat"));
            o.setIdKomik(rs.getString("id_komik"));
            list.add(o);
        }
        return list;
    }

    @Override
    public void delete(int o) throws SQLException {
        PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("delete from transaksi where id_transaksi=?");
        ps.setInt(1, o);
        ps.executeUpdate();
    }

    @Override
    public void tampil(DefaultTableModel dtm) throws SQLException {
        String sql = "SELECT transaksi.id_transaksi, komik.id_komik, komik.judul, komik.pengarang, komik.stok,komik.harga, transaksi.jumlah, transaksi.total, transaksi.uangBayar, transaksi.uangKembalian, transaksi.tanggal, transaksi.Nama, transaksi.no_tlp, transaksi.alamat\n"+
                        "FROM komik,transaksi \n" +
                        "WHERE transaksi.id_transaksi = komik.id_komik AND transaksi.id_komik  GROUP BY transaksi.id_transaksi";
    PreparedStatement st = null;
    Connection connection;
    try{
        connection = koneksi_db.koneksiDatabase();
        st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery(sql);
        Object [] data = new Object[14];
          while(rs.next()){
          data[0] = rs.getObject("id_transaksi");
          data[1] = rs.getObject("judul");
          data[2] = rs.getObject("pengarang");
          data[3] = rs.getObject("stok");
          data[4] = rs.getObject("harga");
          data[5] = rs.getObject("jumlah");
          data[6] = rs.getObject("total");
          data[7] = rs.getObject("uangBayar");
          data[8] = rs.getObject("uangKembalian");
          data[9] = rs.getObject("tanggal");
          data[10] = rs.getObject("Nama");
          data[11] = rs.getObject("no_tlp");
          data[12] = rs.getObject("alamat");
          data[13] = rs.getObject("id_komik");
          dtm.addRow(data);  
          }
    
    }catch(SQLException err){
            err.getMessage();
        }
 }
    @Override
    public ResultSet cekId(String id) throws SQLException {
        Statement st=koneksi_db.koneksiDatabase().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM komik where id_komik='"+id+"'");
        return rs;
        
    }
    @Override
    public ResultSet total (String total) throws SQLException {
        Statement st=koneksi_db.koneksiDatabase().createStatement();
        String sql = "SELECT SUM(komik.harga*transaksi.jumlah ) AS total FROM komik,transaksi WHERE komik.id_komik ="
                + " transaksi.id_komik AND transaksi.id_komik = '"+total+"' GROUP BY transaksi.id_komik";
        ResultSet rs = null;
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    @Override
    public void tampildata(DefaultTableModel dtm) throws SQLException {
    String sql = "SELECT * FROM transaksi";
    PreparedStatement st = null;
    Connection connection;
    try{
        connection = koneksi_db.koneksiDatabase();
        st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery(sql);
        Object [] data = new Object[9];
          while(rs.next()){
          data[0] = rs.getObject("id_transaksi");
          data[1] = rs.getObject("jumlah");
          data[2] = rs.getObject("total");
          data[3] = rs.getObject("noRekening");
          data[4] = rs.getObject("tanggal");
          data[5] = rs.getObject("Nama");
          data[6] = rs.getObject("no_tlp");
          data[7] = rs.getObject("alamat");
          data[8] = rs.getObject("id_komik");
          dtm.addRow(data);  
          }
    
    }catch(SQLException err){
            err.getMessage();
        }
    }
    @Override
    public ResultSet setcombobox() throws SQLException {
       Statement st=koneksi_db.koneksiDatabase().createStatement();
        ResultSet rs=st.executeQuery("SELECT id_komik FROM komik");
        return rs;  
    }
@Override
    public ResultSet caridataKomik (DefaultTableModel dtm, String cari) throws SQLException {
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
    @Override
    public ResultSet caridataTransaksi(DefaultTableModel dtm, String cari) throws SQLException {
    String sql = "SELECT * FROM transaksi WHERE id_transaksi LIKE '%"+cari+"%' OR Nama LIKE '%"+cari+"%' OR alamat LIKE '%"+cari+"%'";
    PreparedStatement st = null;
    ResultSet rs=null;
    Connection connection;
    try{
        connection = koneksi_db.koneksiDatabase();
        st = connection.prepareStatement(sql);
        rs = st.executeQuery(sql);
        Transaksi t= new Transaksi();
        Object [] data = new Object[9];
          while(rs.next()){
          data[0] = rs.getObject("id_transaksi");
          data[1] = rs.getObject("jumlah");
          data[2] = rs.getObject("total");
          data[3] = rs.getObject("noRekening");
          data[4] = rs.getObject("tanggal");
          data[5] = rs.getObject("Nama");
          data[6] = rs.getObject("no_tlp");
          data[7] = rs.getObject("alamat");
          data[8] = rs.getObject("id_komik");
          
          dtm.addRow(data);  
          }
    
    }catch(SQLException err){
            err.getMessage();
        }
    return rs;
    }

    
    

    
    

    

   

   

   
}

    