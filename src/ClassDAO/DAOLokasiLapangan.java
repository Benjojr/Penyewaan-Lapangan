package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.LokasiLapangan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author bani
 */
public class DAOLokasiLapangan {
    public LokasiLapangan insertLokasiLapangan(LokasiLapangan lokasiLapangan) {
        String sql = """
                INSERT INTO LokasiLapangan(id_lokasi, jalan, rt_rw, kelurahan, kecamatan, kota, provinsi) 
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
        
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, lokasiLapangan.getId_lokasi());
            stmt.setString(2, lokasiLapangan.getJalan());
            stmt.setString(3, lokasiLapangan.getRt_rw());
            stmt.setString(4, lokasiLapangan.getKelurahan());
            stmt.setString(5, lokasiLapangan.getKecamatan());
            stmt.setString(6, lokasiLapangan.getKota());
            stmt.setString(7, lokasiLapangan.getProvinsi());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting lokasi lapangan: " + e.getMessage());
            return null;
        }
        return lokasiLapangan;
    }
    
    public void updateLokasiLapangan(LokasiLapangan lokasi) {
        String sql = "UPDATE LokasiLapangan SET jalan = ?, rt_rw = ?, kelurahan = ?, kecamatan = ?, kota = ?, provinsi = ? WHERE id_lokasi = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, lokasi.getJalan());
            stmt.setString(2, lokasi.getRt_rw());
            stmt.setString(3, lokasi.getKelurahan());
            stmt.setString(4, lokasi.getKecamatan());
            stmt.setString(5, lokasi.getKota());
            stmt.setString(6, lokasi.getProvinsi());
            stmt.setString(7, lokasi.getId_lokasi());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating lokasi lapangan: " + e.getMessage());
        }
    }
}
