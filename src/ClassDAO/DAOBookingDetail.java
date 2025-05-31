


package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DAOBookingDetail {

  

    public List<Booking> getBookingDetail(String id_Pengguna) {
        List<Booking> bookings = new ArrayList<>();
        String sql = """
            SELECT  b.id_booking,
                    p.id_Pengguna,
                    p.Username,
                    l.Nama_lapangan, 
                    l.Lokasi, 
                    l.Harga,
                    j.tanggal, 
                    j.jam_mulai, 
                    j.jam_selesai,
                    jo.nama_Olahraga
            FROM Booking b
            JOIN Jadwal j ON b.id_booking = j.id_booking
            JOIN Lapangan l ON j.id_lapangan = l.id_lapangan
            JOIN Jenis_Olahraga jo ON l.id_Olahraga = jo.id_Olahraga
            JOIN Pengguna p ON b.id_Pengguna = p.id_Pengguna
            WHERE b.id_Pengguna = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id_Pengguna);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking detail;
                detail = new Booking();
                // Booking
                detail.setId_booking(rs.getString("id_booking"));
                
                // Pengguna
                detail.setPengguna(new Pengguna());
                detail.getPengguna().setId(id_Pengguna);
                detail.getPengguna().setUserName(rs.getString("Username"));

                // Olahraga
                detail.setLapangan(new Lapangan());
                detail.getLapangan().setOlahraga(new Olahraga());
                detail.getLapangan().getOlahraga().setNama_olahraga(rs.getString("nama_Olahraga")); 

                // Lapangan
                detail.getLapangan().setNama_lapangan(rs.getString("Nama_lapangan"));
                detail.getLapangan().setLokasi(rs.getString("Lokasi"));
                detail.getLapangan().setHarga(rs.getDouble("Harga"));

                // Jadwal
                detail.setJadwal(new Jadwal());
                detail.getJadwal().setTanggal(rs.getDate("tanggal").toLocalDate());
                detail.getJadwal().setJam_Mulai(rs.getTime("jam_mulai").toLocalTime());
                detail.getJadwal().setJam_Selesai(rs.getTime("jam_selesai").toLocalTime());

                bookings.add(detail);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving booking detail: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        return bookings;
    }

    public Booking getBooking(String id_booking) {
        Booking detail = null;

        String sql = """
            SELECT  b.id_booking,
                    p.id_Pengguna,
                    p.Username,
                    l.Nama_lapangan, 
                    l.Lokasi, 
                    l.Harga,
                    j.tanggal, 
                    j.jam_mulai, 
                    j.jam_selesai,
                    jo.nama_Olahraga
            FROM Booking b
            JOIN Jadwal j ON b.id_booking = j.id_booking
            JOIN Lapangan l ON j.id_lapangan = l.id_lapangan
            JOIN Jenis_Olahraga jo ON l.id_Olahraga = jo.id_Olahraga
            JOIN Pengguna p ON b.id_Pengguna = p.id_Pengguna
            WHERE b.id_booking = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id_booking);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                detail = new Booking();
                // Booking
                detail.setId_booking(id_booking);
                
                // Pengguna
                detail.setPengguna(new Pengguna());
                detail.getPengguna().setId(rs.getString("id_Pengguna"));
                detail.getPengguna().setUserName(rs.getString("Username"));

                // Olahraga
                detail.setLapangan(new Lapangan());
                detail.getLapangan().setOlahraga(new Olahraga());
                detail.getLapangan().getOlahraga().setNama_olahraga(rs.getString("nama_Olahraga")); 

                // Lapangan
                detail.getLapangan().setNama_lapangan(rs.getString("Nama_lapangan"));
                detail.getLapangan().setLokasi(rs.getString("Lokasi"));
                detail.getLapangan().setHarga(rs.getDouble("Harga"));

                // Jadwal
                detail.setJadwal(new Jadwal());
                detail.getJadwal().setTanggal(rs.getDate("tanggal").toLocalDate());
                detail.getJadwal().setJam_Mulai(rs.getTime("jam_mulai").toLocalTime());
                detail.getJadwal().setJam_Selesai(rs.getTime("jam_selesai").toLocalTime());
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving booking detail: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        return detail;
    }
}
