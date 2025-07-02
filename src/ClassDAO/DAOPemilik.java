/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Alamat;
import MainClass.Langganan;
import MainClass.Pemilik;
import MainClass.Pengguna;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Axioo Pongo
 */
public class DAOPemilik {
    public void Regist(String id, String nama, String email, String no_hp, String id_alamat, String norek, String password) {
        String sql = "INSERT INTO Pemilik(id_pemilik, nama, email, no_hp, id_alamat, password, norek) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.setString(2, nama);
            stmt.setString(3, email);
            stmt.setString(4, no_hp);
            stmt.setString(5, id_alamat);
            stmt.setString(6, password);
            stmt.setString(7, norek);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proses Pendaftaran Berhasil.", "Information",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void Update(String id, String nama, String email, String no_hp, String id_alamat, String norek, String password) {
        String sql = "UPDATE Pemilik SET id_alamat = ?, nama = ?, email = ?, no_rek = ?, contact_number = ?, password = ? WHERE id_pemilik = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_alamat);
            stmt.setString(2, nama);
            stmt.setString(3, email);
            stmt.setString(4, norek);
            stmt.setString(5, no_hp);
            stmt.setString(6, password);
            stmt.setString(7, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Profil berhasil disimpan.", "Information",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Pemilik LoadSomeById(String id_pemilik) {
        String sql = """
                SELECT * FROM Pemilik
                JOIN Alamat ON Pemilik.id_alamat = Alamat.id_alamat
                WHERE id_pemilik = ?
                """;
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id_pemilik);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pemilik(
                            rs.getString("id_pemilik"),
                            rs.getString("password"),
                            rs.getString("nama"),
                            rs.getString("email"),
                            rs.getString("no_rek"),
                            rs.getString("contact_number"),
                            new Alamat(
                                    rs.getString("id_alamat"),
                                    rs.getString("jalan"),
                                    rs.getString("rt_rw"),
                                    rs.getString("kelurahan"),
                                    rs.getString("kecamatan"),
                                    rs.getString("kota"),
                                    rs.getString("provinsi")));
                }
            }
        } catch (SQLException e) {
            // Log the exception properly instead of just printing
            System.err.println("Error loading Pengguna by ID: " + e.getMessage());
        }
        return null;
    }
    
    
    
    
}
