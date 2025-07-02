/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Alamat;
import MainClass.Fasilitas;
import MainClass.Lapangan;
import MainClass.LokasiLapangan;
import MainClass.Olahraga;
import MainClass.Pemilik;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DAOLapangan {
    public List<Lapangan> getLapanganByOlahraga(String idOlahraga) {
        List<Lapangan> list = new ArrayList<>();
        String sql = """
                SELECT 
                    *
                FROM Lapangan l
                JOIN JenisOlahraga j ON l.id_olahraga = j.id_olahraga
                JOIN LokasiLapangan lok ON l.id_lokasi = lok.id_lokasi
                JOIN Fasilitas f ON l.id_fasilitas = f.id_fasilitas
                JOIN Pemilik p ON l.id_pemilik = p.id_pemilik
                JOIN Alamat a ON p.id_alamat = a.id_alamat
                WHERE l.id_olahraga = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idOlahraga);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Olahraga olahraga = new Olahraga(
                            rs.getString("id_olahraga"),
                            rs.getString("nama_olahraga"));
                    
                    LokasiLapangan lokasiLapangan = new LokasiLapangan(
                            rs.getString("id_lokasi"),
                            rs.getString("jalan"),
                            rs.getString("rt_rw"),
                            rs.getString("kelurahan"),
                            rs.getString("kecamatan"),
                            rs.getString("kota"),
                            rs.getString("provinsi")
                    );

                    Alamat alamat = new Alamat(
                            rs.getString("id_alamat"),
                            rs.getString("jalan"),
                            rs.getString("rt_rw"),
                            rs.getString("kelurahan"),
                            rs.getString("kecamatan"),
                            rs.getString("kota"),
                            rs.getString("provinsi")
                    );

                    Pemilik pemilik = new Pemilik(
                            rs.getString("id_pemilik"),
                            alamat,
                            rs.getString("password"),
                            rs.getString("nama"),
                            rs.getString("email"),
                            rs.getString("no_rek"),
                            rs.getString("contact_number")
                    );

                    Fasilitas fasilitas = new Fasilitas(
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

                    // Assuming you have dummy or null values for Pemilik, Fasilitas, and LokasiLapangan for now
                    Lapangan lapangan = new Lapangan(
                            rs.getString("id_lapangan"),
                            rs.getDouble("harga_per_jam"),
                            rs.getString("nama_lapangan"),
                            olahraga,
                            lokasiLapangan,
                            pemilik,
                            fasilitas
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
        String sql = """
                SELECT 
                    *
                FROM Lapangan l
                JOIN JenisOlahraga j ON l.id_olahraga = j.id_olahraga
                JOIN LokasiLapangan lok ON l.id_lokasi = lok.id_lokasi
                JOIN Fasilitas f ON l.id_fasilitas = f.id_fasilitas
                JOIN Pemilik p ON l.id_pemilik = p.id_pemilik
                JOIN Alamat a ON p.id_alamat = a.id_alamat
                WHERE l.id_lapangan = ?
                """;
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, id_Lapangan);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                    Olahraga olahraga = LoadOlrgById(rs.getString("id_olahraga"));
                    LokasiLapangan lokasiLapangan = new LokasiLapangan(
                        rs.getString("id_lokasi"),
                        rs.getString("jalan"),
                        rs.getString("rt_rw"),
                        rs.getString("kelurahan"),
                        rs.getString("kecamatan"),
                        rs.getString("kota"),
                        rs.getString("provinsi")
                    );
                    Alamat alamat = new Alamat(
                        rs.getString("id_alamat"),
                        rs.getString("jalan"),
                        rs.getString("rt_rw"),
                        rs.getString("kelurahan"),
                        rs.getString("kecamatan"),
                        rs.getString("kota"),
                        rs.getString("provinsi")
                    );
                    Pemilik pemilik = new Pemilik(
                        rs.getString("id_pemilik"),
                        alamat,
                        rs.getString("password"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("no_rek"),
                        rs.getString("contact_number")
                    );
                    Fasilitas fasilitas = new Fasilitas(
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
                    return new Lapangan(
                        rs.getString("id_lapangan"),
                        rs.getDouble("harga_per_jam"),
                        rs.getString("nama_lapangan"),
                        olahraga,
                        lokasiLapangan,
                        pemilik,
                        fasilitas
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
