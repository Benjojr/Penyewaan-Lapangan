/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Alamat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bani
 */
public class DAOAlamat {

    public List<Alamat> loadAllAlamat() {
        List<Alamat> alamatList = new ArrayList<>();

        String sql = "SELECT * FROM Alamat";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Alamat alamat = new Alamat();
                alamat.setId_alamat(rs.getString("id_alamat"));
                alamat.setJalan(rs.getString("jalan"));
                alamat.setRt_rw(rs.getString("rt_rw"));
                alamat.setKelurahan(rs.getString("kelurahan"));
                alamat.setKecamatan(rs.getString("kecamatan"));
                alamat.setKota(rs.getString("kota"));
                alamat.setProvinsi(rs.getString("provinsi"));
                alamatList.add(alamat);
            }
        } catch (SQLException err) {
            System.out.println("Error loading Alamat: " + err.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return alamatList;
    }

    public Alamat insertAlamat(Alamat alamat) {
        Alamat alamatBaru = null;
        String sql = "INSERT INTO Alamat(jalan, rt_rw, kelurahan, kecamatan, kota, provinsi) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlSelect = "SELECT TOP 1 id_alamat FROM Alamat WHERE jalan = ? AND rt_rw = ? AND kelurahan = ? " +
                "AND kecamatan = ? AND kota = ? AND provinsi = ? ORDER BY id_alamat DESC";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect)) {

            // Set parameters for insert
            stmt.setString(1, alamat.getJalan());
            stmt.setString(2, alamat.getRt_rw());
            stmt.setString(3, alamat.getKelurahan());
            stmt.setString(4, alamat.getKecamatan());
            stmt.setString(5, alamat.getKota());
            stmt.setString(6, alamat.getProvinsi());
            stmt.executeUpdate();

            // Set parameters for select
            stmtSelect.setString(1, alamat.getJalan());
            stmtSelect.setString(2, alamat.getRt_rw());
            stmtSelect.setString(3, alamat.getKelurahan());
            stmtSelect.setString(4, alamat.getKecamatan());
            stmtSelect.setString(5, alamat.getKota());
            stmtSelect.setString(6, alamat.getProvinsi());

            ResultSet rs = stmtSelect.executeQuery();
            if (rs.next()) {
                String idAlamat = rs.getString("id_alamat");
                alamatBaru = new Alamat(
                        idAlamat,
                        alamat.getJalan(),
                        alamat.getRt_rw(),
                        alamat.getKelurahan(),
                        alamat.getKecamatan(),
                        alamat.getKota(),
                        alamat.getProvinsi());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alamatBaru;
    }

}
