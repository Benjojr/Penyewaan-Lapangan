/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.*;
import MainClass.*;
import java.sql.*;

public class DAOPengguna {
    // Removed instance since getConnection is static
    
        public Pengguna Load(String id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, id); // Set nilai id dengan placeholder untuk menghindari SQL Injection

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pengguna(
                        rs.getString("id"),
                        rs.getString("no_telp"),
                        rs.getString("email"),
                        rs.getString("Username"),
                        rs.getString("Jenis_langganan"),
                        rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
        return null;
    }
}
