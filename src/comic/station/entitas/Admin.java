/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comic.station.entitas;

import comic.station.abstracts.user;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import db_comic.koneksi_db;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import comic.station.interfaces.InterAdmin;

/**
 *
 * @author ASUS
 */
public class Admin extends user implements InterAdmin {
    private int id_admin;
   
   public Admin(){
   
   }
   public Admin(int id_admin,String nama,String username,String password){
        this.id_admin=id_admin;
        this.nama=nama;
        this.username=username;
        this.password=password;
        
   }
    
    public void setIdAdmin(int id_admin) {
        this.id_admin=id_admin;
    }

   
    public int getIdAdmin() {
        return id_admin;
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
    public List<Admin> getAll() throws SQLException {
         Statement st=koneksi_db.koneksiDatabase().createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM admin");
        List<Admin>list=new ArrayList<Admin>();
        while(rs.next()){
            Admin p=new Admin();
            p.setIdAdmin(rs.getInt("id_admin"));
            p.setNama(rs.getString("nama"));
            p.setUsername(rs.getString("username"));
            p.setPassword(rs.getString("password"));
            list.add(p);
        }
        return list;
    }


    @Override
    public Admin insert(Admin o) throws SQLException {
        PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("INSERT INTO admin (id_admin,nama,username,password) VALUES (?,?,?,?)");
        ps.setInt(1, o.getIdAdmin());
        ps.setString(2, o.getNama());
        ps.setString(3, o.getUsername());
        ps.setString(4, o.getPassword());
        ps.executeUpdate();
        return o;
    }

    @Override
    public void update(Admin o) throws SQLException {
        PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("UPDATE admin SET nama=?,username=?,password=? WHERE id_admin=?");
        ps.setString(1, o.getNama());
        ps.setString(2, o.getUsername());
        ps.setString(3, o.getPassword());
        ps.setInt(4, o.getIdAdmin());
        ps.executeUpdate();
    }

    @Override
    public void delete(int o) throws SQLException {
        PreparedStatement ps=koneksi_db.koneksiDatabase().prepareStatement("DELETE FROM admin WHERE id_admin=?");
        ps.setInt(1, o);
        ps.executeUpdate();
    }

    
}

   
 

   

    
    

