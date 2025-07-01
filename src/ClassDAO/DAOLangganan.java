/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Langganan;
import MainClass.Pengguna;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gw
 */
public class DAOLangganan {
    public List<Langganan> getAllPaket() {
        List<Langganan> paketList = new ArrayList<>();
        String sql = "SELECT * FROM Subscription";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                paketList.add(new Langganan(
                    rs.getString("id_subscription"),
                    rs.getString("jenis"),
                    rs.getDouble("diskon"),
                    rs.getDouble("harga")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error get all paket: " + e.getMessage());
        }
        return paketList;
    }

    public boolean upgradeLangganan(String idPengguna, String id_Langganan) {
        String sql = "UPDATE Pengguna SET id_subscription = ? WHERE id_pengguna = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id_Langganan);
            stmt.setString(2, idPengguna);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error upgrade langganan: " + e.getMessage());
            return false;
        }
    }
    
    public Langganan LoadSomeById(String id_langganan) {
        String sql = "SELECT * FROM Subscription WHERE id_subscription = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, id_langganan); // Set parameter safely
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Langganan(
                        rs.getString("id_subscription"),
                        rs.getString("Jenis"),
                        rs.getDouble("diskon"),
                        rs.getDouble("harga")
                    );
                }
            }
        } catch (SQLException e) {
            // Log the exception properly instead of just printing
            System.err.println("Error loading Pengguna by ID: " + e.getMessage());
        }
    return null;
    }
}