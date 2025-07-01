/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.*;
import MainClass.*;
import java.sql.*;
import java.util.ArrayList;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class DAOPengguna {

    public Pengguna LoadSome(String username) {
        String sql = """
                SELECT * FROM Pengguna
                JOIN Alamat ON Pengguna.id_alamat = Alamat.id_alamat
                JOIN Subscription ON Pengguna.id_subscription = Subscription.id_subscription
                WHERE nama like ?
                """;
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pengguna(
                            rs.getString("id_pengguna"),
                            rs.getString("nama"),
                            rs.getString("email"),
                            rs.getString("no_hp"),
                            rs.getDate("tanggal_lahir").toLocalDate(),
                            new Alamat(
                                    rs.getInt("id_alamat"),
                                    rs.getString("jalan"),
                                    rs.getString("rt_rw"),
                                    rs.getString("kelurahan"),
                                    rs.getString("kecamatan"),
                                    rs.getString("kota"),
                                    rs.getString("provinsi")),
                            new Langganan(
                                    rs.getString("id_langganan"),
                                    rs.getString("jenis_langganan"),
                                    rs.getDouble("potongan"),
                                    rs.getDouble("harga")),
                            rs.getString("password"),
                            rs.getString("username"));

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Pengguna LoadSomeById(String id_Pengguna) {
        String sql = """
                SELECT * FROM Pengguna
                JOIN Alamat ON Pengguna.id_alamat = Alamat.id_alamat
                JOIN Subscription ON Pengguna.id_subscription = Subscription.id_subscription
                WHERE id_pengguna = ?
                """;
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id_Pengguna);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pengguna(
                            rs.getString("id_pengguna"),
                            rs.getString("nama"),
                            rs.getString("email"),
                            rs.getString("no_hp"),
                            rs.getDate("tanggal_lahir").toLocalDate(),
                            new Alamat(
                                    rs.getInt("id_alamat"),
                                    rs.getString("jalan"),
                                    rs.getString("rt_rw"),
                                    rs.getString("kelurahan"),
                                    rs.getString("kecamatan"),
                                    rs.getString("kota"),
                                    rs.getString("provinsi")),
                            new Langganan(
                                    rs.getString("id_langganan"),
                                    rs.getString("jenis_langganan"),
                                    rs.getDouble("potongan"),
                                    rs.getDouble("harga")),
                            rs.getString("password"),
                            rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            // Log the exception properly instead of just printing
            System.err.println("Error loading Pengguna by ID: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Pengguna> LoadAll() {
        ArrayList<Pengguna> penggunas = new ArrayList<Pengguna>();
        String sql = "SELECT * FROM Pengguna";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    penggunas.add(new Pengguna(
                            rs.getString("id_pengguna"),
                            rs.getString("nama"),
                            rs.getString("email"),
                            rs.getString("no_hp"),
                            rs.getDate("tanggal_lahir").toLocalDate(),
                            new Alamat(
                                    rs.getInt("id_alamat"),
                                    rs.getString("jalan"),
                                    rs.getString("rt_rw"),
                                    rs.getString("kelurahan"),
                                    rs.getString("kecamatan"),
                                    rs.getString("kota"),
                                    rs.getString("provinsi")),
                            new Langganan(
                                    rs.getString("id_langganan"),
                                    rs.getString("jenis_langganan"),
                                    rs.getDouble("potongan"),
                                    rs.getDouble("harga")),
                            rs.getString("password"),
                            rs.getString("username")));
                }
                return penggunas;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void Regist(String id, String nama, String email, String no_hp, LocalDate tanggal_lahir, String id_alamat,
            String id_subscription, String username, String password) {
        String sql = "INSERT INTO Pengguna(id_pengguna, nama, email, no_hp, tanggal_lahir, id_alamat, id_subscription, password, username) VALUES (?,?,?,?,?,?,'SUB001',?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id);
            stmt.setString(2, nama);
            stmt.setString(3, email);
            stmt.setString(4, no_hp);
            stmt.setDate(5, Date.valueOf(tanggal_lahir));
            stmt.setString(6, id_alamat);
            stmt.setString(7, password);
            stmt.setString(8, username);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proses Pendaftaran Berhasil.", "Information",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void DeletePengguna(String username) {
        Pengguna temp = LoadSome(username);
        if (temp != null) {
            String sql = "DELETE FROM Pengguna WHERE Username like '" + username + "'";
            try (Connection conn = DatabaseConnection.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pengguna telah dihapus.", "Information",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pengguna tidak ditemukan.", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}