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
        }
        catch (SQLException err) {
            System.out.println("Error loading Alamat: " + err.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return alamatList;
    }

    public Alamat insertAlamat(Alamat alamat) {
    String sql = "INSERT INTO Alamat (id_alamat, jalan, rt_rw, kelurahan, kecamatan, kota, provinsi) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        
        stmt.setString(1, alamat.getId_alamat());
        stmt.setString(2, alamat.getJalan());
        stmt.setString(3, alamat.getRt_rw());
        stmt.setString(4, alamat.getKelurahan());
        stmt.setString(5, alamat.getKecamatan());
        stmt.setString(6, alamat.getKota());
        stmt.setString(7, alamat.getProvinsi());
        
        stmt.executeUpdate();
        
        System.out.println("Alamat berhasil ditambahkan.");
    } catch (SQLException e) {
         System.out.println("Error loading Alamat: " + e.getMessage()); // biar error-nya kelihatan detail
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

        return alamat;
}
}
