/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Lapangan;
import MainClass.Olahraga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benja
 */
public class DAOLapangan {
    public List<Lapangan> getLapanganByOlahraga(String idOlahraga) {
        List<Lapangan> list = new ArrayList<>();
        String sql = "SELECT l.*, o.nama_Olahraga FROM Lapangan l JOIN Jenis_Olahraga o ON l.id_Olahraga = o.id_Olahraga WHERE l.id_Olahraga = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idOlahraga);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Olahraga olahraga = new Olahraga(
                            rs.getString("id_Olahraga"),
                            rs.getString("nama_Olahraga"));

                    Lapangan lapangan = new Lapangan(
                            rs.getString("id_Lapangan"),
                            rs.getString("Lokasi"),
                            rs.getDouble("Harga"),
                            rs.getString("Nama_lapangan"),
                            olahraga,
                            null
                    );

                    list.add(lapangan);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return list;
    }
}
