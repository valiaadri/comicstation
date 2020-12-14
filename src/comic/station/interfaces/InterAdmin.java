/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comic.station.interfaces;

import comic.station.entitas.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface InterAdmin {
    
    public abstract List<Admin>getAll() throws SQLException;
    
    public abstract Admin insert(Admin o) throws SQLException;
    
    public abstract void update(Admin o) throws SQLException ;
       
    public abstract  void delete(int o) throws SQLException;
    
}
