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
                            p.id_pengguna,
                            p.nama AS nama_pengguna,
                            l.nama_lapangan,
                            ll.jalan AS lokasi_jalan,
                            l.harga_per_jam,
                            j.jam_mulai,
                            j.jam_selesai,
                            jo.nama_olahraga
                    FROM Booking b
                    JOIN Pengguna p ON b.id_pengguna = p.id_pengguna
                    JOIN Jadwal j ON b.id_jadwal = j.id_jadwal
                    JOIN Lapangan l ON j.id_lapangan = l.id_lapangan
                    JOIN JenisOlahraga jo ON l.id_olahraga = jo.id_olahraga
                    JOIN LokasiLapangan ll ON l.id_lokasi = ll.id_lokasi
                    WHERE b.id_pengguna = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id_Pengguna);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking detail = new Booking();

                detail.setId_booking(rs.getString("id_booking"));

                Pengguna pengguna = new Pengguna();
                pengguna.setId(rs.getString("id_pengguna"));
                pengguna.setNama(rs.getString("nama_pengguna"));
                detail.setPengguna(pengguna);

                Lapangan lapangan = new Lapangan();
                lapangan.setNama_lapangan(rs.getString("nama_lapangan"));
                lapangan.setHarga(rs.getDouble("harga_per_jam"));
                lapangan.setLokasi(rs.getString("lokasi_jalan"));

                Olahraga olahraga = new Olahraga();
                olahraga.setNama_olahraga(rs.getString("nama_olahraga"));
                lapangan.setOlahraga(olahraga);

                detail.setLapangan(lapangan);

                Jadwal jadwal = new Jadwal();
                jadwal.setJam_Mulai(rs.getTime("jam_mulai").toLocalTime());
                jadwal.setJam_Selesai(rs.getTime("jam_selesai").toLocalTime());
                detail.setJadwal(jadwal);

                bookings.add(detail);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving booking detail: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        return bookings;
    }

    public ArrayList<String> getIdAllBooking() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT * FROM Booking";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(rs.getString("id_booking"));
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return list;
    }

    public void RegistBooking(Booking book) {
        String sql = "INSERT INTO Booking(id_booking, id_pengguna) VALUES (?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getId_booking());
            stmt.setString(2, book.getPengguna().getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
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
                detail.getPengguna().setNama(rs.getString("Username"));

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
                detail.getClassJadwal().setTanggal(rs.getDate("tanggal").toLocalDate());
                detail.getClassJadwal().setJam_Mulai(rs.getTime("jam_mulai").toLocalTime());
                detail.getClassJadwal().setJam_Selesai(rs.getTime("jam_selesai").toLocalTime());
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving booking detail: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        return detail;
    }
}