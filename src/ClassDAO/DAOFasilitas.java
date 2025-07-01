/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Fasilitas;
import java.sql.*;

/**
 *
 * @author Axioo Pongo
 */

public class DAOFasilitas {
    public Fasilitas LoadFasilById(String id_fasilitas) {
        String sql = "SELECT * FROM Fasilitas WHERE id_fasilitas = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, id_fasilitas); // Set parameter safely
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Fasilitas(
                        rs.getString("id_fasilitas"),
                        rs.getString("toilet"),
                        rs.getString("jenis"),
                        rs.getString("area_parkir"),
                        rs.getString("wifi"),
                        rs.getString("perlengkapan"),
                        rs.getString("akses_listrik"),
                        rs.getString("pencahayaan"),
                        rs.getString("p3k"),
                        rs.getString("lainnya")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error loading Pengguna by ID: " + e.getMessage());
        }
    return null;
    }
}
