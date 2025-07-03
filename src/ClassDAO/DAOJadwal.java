/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Jadwal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author benja
 */
public class DAOJadwal {

    public ArrayList<Jadwal> getJadwalByLapangan(String idLapangan, LocalDate today) {
    ArrayList<Jadwal> list = new ArrayList<>();

    String sql = """
        SELECT 
            j.id_jadwal AS id, 
            j.tanggal, 
            j.jam_mulai, 
            j.jam_selesai
        FROM Jadwal j
        WHERE j.id_lapangan = ? AND j.tanggal = ?
        
        UNION ALL
        
        SELECT 
            CAST(n.id_nonaktif AS VARCHAR) AS id, 
            n.tanggal, 
            n.jam_mulai, 
            n.jam_selesai
        FROM NonaktifJadwal n
        WHERE n.id_lapangan = ? AND n.tanggal = ?
        """;

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, idLapangan);
        stmt.setDate(2, Date.valueOf(today));
        stmt.setString(3, idLapangan);
        stmt.setDate(4, Date.valueOf(today));

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Jadwal jadwal = new Jadwal(
                    rs.getString("id"),
                    rs.getDate("tanggal").toLocalDate(),
                    rs.getTime("jam_mulai").toLocalTime(),
                    rs.getTime("jam_selesai").toLocalTime(),
                    null
                );
                list.add(jadwal);
            }
        }

    } catch (Exception e) {
        System.out.println("Error: " + e);
    }

    return list;
}

    public ArrayList<String> getIdAllJadwal() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT * FROM Jadwal";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(rs.getString("id_Jadwal"));
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return list;
    }

    public void RegistJadwal(Jadwal jadwal, String id_Booking) {
        String sql = "INSERT INTO Jadwal(id_Jadwal, tanggal, jam_mulai, jam_selesai, id_booking, id_lapangan) VALUES (?,?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, jadwal.getIdJadwal());
            stmt.setString(2, jadwal.getTanggal().toString());
            stmt.setString(3, jadwal.getJam_Mulai().toString());
            stmt.setString(4, jadwal.getJam_Selesai().toString());
            stmt.setString(5, id_Booking);
            stmt.setString(6, jadwal.getLapangan().getId_lapangan());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void MatikanJadwal(Jadwal jadwal, String alasan) {
        String sql = """
                INSERT INTO NonaktifJadwal (id_lapangan, tanggal, jam_mulai, jam_selesai, alasan)
                VALUES (?,?,?,?,?)
                """;
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, jadwal.getLapangan().getId_lapangan());
            stmt.setDate(2, java.sql.Date.valueOf(jadwal.getTanggal()));
            stmt.setTime(3, java.sql.Time.valueOf(jadwal.getJam_Mulai()));
            stmt.setTime(4, java.sql.Time.valueOf(jadwal.getJam_Selesai()));
            stmt.setString(5, alasan);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
