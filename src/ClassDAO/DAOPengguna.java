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
    
    public Pengguna Load(String id) {
        String sql = "SELECT * FROM users WHERE id = "+id;
        try (Connection conn = dc.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pengguna(
                        rs.getString("id"),
                        rs.getString("no_telp"),
                        rs.getString("email"),
                        rs.getString("Username"),
                        rs.getString("Jenis_lapangan"),
                        rs.getString("password")
                    );
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
    
    
}
