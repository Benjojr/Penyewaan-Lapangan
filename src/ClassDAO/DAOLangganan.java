/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Langganan;
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
        String sql = "SELECT * FROM Langganan";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                paketList.add(new Langganan(
                    null,
                    rs.getString("jenisLangganan"),
                    rs.getDouble("potongan"),
                    rs.getDouble("harga")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error get all paket: " + e.getMessage());
        }
        return paketList;
    }

    public boolean upgradeLangganan(String idPengguna, String jenisLangganan) {
        String sql = "UPDATE Pengguna SET Jenis_langganan = ? WHERE id_Pengguna = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, jenisLangganan);
            stmt.setString(2, idPengguna);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error upgrade langganan: " + e.getMessage());
            return false;
        }
    }
}