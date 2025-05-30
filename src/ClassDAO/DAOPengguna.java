/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import MainClass.*;
import java.util.ArrayList;
import java.sql.*;
import ConnectionClass.*;

public class DAOPengguna {
    DatabaseConnection dc = new DatabaseConnection();
    
    public Pengguna LoadSome(String id) {
        String sql = "SELECT * FROM Pengguna WHERE id_Pengguna like '"+id+"'";
        try (Connection conn = dc.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pengguna(
                        rs.getString("id_Pengguna"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("Username"),
                        rs.getString("Jenis_langganan"),
                        rs.getString("password")
                    );
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public ArrayList<Pengguna> LoadAll() {
        ArrayList<Pengguna> penggunas = new ArrayList<Pengguna>();
        String sql = "SELECT * FROM Pengguna";
        try (Connection conn = dc.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    penggunas.add( new Pengguna(
                        rs.getString("id_Pengguna"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("Username"),
                        rs.getString("Jenis_langganan"),
                        rs.getString("password")
                    ));
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    
    
    
}
