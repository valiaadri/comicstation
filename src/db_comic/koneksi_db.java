
package db_comic;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class koneksi_db {
    private static Connection koneksi;
    public Statement st;
    public ResultSet rs;
     
    public static Connection koneksiDatabase(){
        if(koneksi == null){
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost/comicstation");
            dataSource.setUser("root");
            dataSource.setPassword("");
            try{
                koneksi = dataSource.getConnection();
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "KONEKSI ERROR :" + 
                        ex.getMessage());
            }
        }
        return koneksi;
    }
}
