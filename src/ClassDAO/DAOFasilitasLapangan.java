package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Fasilitas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bani
 */
public class DAOFasilitasLapangan {
    public Fasilitas insertFasilitas(Fasilitas fasilitas) {
        String sql = """
                INSERT INTO Fasilitas(id_fasilitas, toilet, jenis, area_parkir, wifi, perlengkapan, akses_listrik, pencahayaan, p3k, lainnya) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fasilitas.getId_fasilitas());
            stmt.setString(2, fasilitas.getToilrt());
            stmt.setString(3, fasilitas.getJenis());
            stmt.setString(4, fasilitas.getArea_parkir());
            stmt.setString(5, fasilitas.getWifi());
            stmt.setString(6, fasilitas.getPerlengkapan());
            stmt.setString(7, fasilitas.getAkses_listrik());
            stmt.setString(8, fasilitas.getPencahayaan());
            stmt.setString(9, fasilitas.getP3k());
            stmt.setString(10, fasilitas.getLainnya());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error inserting fasilitas: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error inserting fasilitas: " + e.getMessage());
            return null;
        }
        return fasilitas;
    }
}
