/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Lapangan;
import MainClass.Olahraga;
import MainClass.Pengguna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DAOLapangan {
    public List<Lapangan> getLapanganByOlahraga(String idOlahraga) {
        List<Lapangan> list = new ArrayList<>();
        String sql ="SELECT l.id_lapangan, l.nama_lapangan, l.harga_per_jam, " +
                    "j.nama_olahraga, j.id_olahraga, " +
                    "lok.jalan, lok.rt_rw, lok.kelurahan, lok.kecamatan, lok.kota, lok.provinsi " +
                    "FROM Lapangan l " +
                    "JOIN JenisOlahraga j ON l.id_olahraga = j.id_olahraga " +
                    "JOIN LokasiLapangan lok ON l.id_lokasi = lok.id_lokasi " +
                    "WHERE l.id_olahraga = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idOlahraga);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Olahraga olahraga = new Olahraga(
                            rs.getString("id_olahraga"),
                            rs.getString("nama_olahraga"));
                    
                    String lokasiLengkap = rs.getString("jalan") + ", RT/RW " + rs.getString("rt_rw") +
                        ", " + rs.getString("kelurahan") +
                        ", " + rs.getString("kecamatan") +
                        ", " + rs.getString("kota") +
                        ", " + rs.getString("provinsi");

                    Lapangan lapangan = new Lapangan(
                            rs.getString("id_lapangan"),
                            lokasiLengkap,
                            rs.getDouble("harga_per_jam"),
                            rs.getString("nama_lapangan"),
                            olahraga
                    );

                    list.add(lapangan);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return list;
    }
    
    public Lapangan LoadSomeById(String id_Lapangan) {
        String sql = "SELECT l.id_lapangan, l.nama_lapangan, l.harga_per_jam, l.id_olahraga, " +
                     "lok.jalan, lok.rt_rw, lok.kelurahan, lok.kecamatan, lok.kota, lok.provinsi " +
                     "FROM Lapangan l " +
                     "JOIN LokasiLapangan lok ON l.id_lokasi = lok.id_lokasi " +
                     "WHERE l.id_lapangan = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, id_Lapangan);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String lokasiLengkap = rs.getString("jalan") + ", RT/RW " + rs.getString("rt_rw") +
                        ", " + rs.getString("kelurahan") +
                        ", " + rs.getString("kecamatan") +
                        ", " + rs.getString("kota") +
                        ", " + rs.getString("provinsi");
                    
                    return new Lapangan(
                        rs.getString("id_lapangan"),
                        lokasiLengkap,
                        rs.getDouble("harga_per_jam"),
                        rs.getString("nama_lapangan"),
                        LoadOlrgById(rs.getString("id_olahraga"))
                    );
                }
            }
        } catch (SQLException e) {
            // Log the exception properly instead of just printing
            System.err.println("Error loading Pengguna by ID: " + e.getMessage());
        }
    return null;
    }
    
    public Olahraga LoadOlrgById(String id_or) {
        String sql = "SELECT * FROM Jenis_Olahraga WHERE id_olahraga = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, id_or); // Set parameter safely
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Olahraga(
                        rs.getString("id_olahraga"),
                        rs.getString("nama_olahraga")
                        
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
