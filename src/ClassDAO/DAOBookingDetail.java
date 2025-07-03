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
            SELECT  *
            FROM Booking b
			JOIN Jadwal j ON b.id_jadwal = j.id_jadwal
            JOIN Lapangan l ON j.id_lapangan = l.id_lapangan
			JOIN LokasiLapangan lp ON l.id_lokasi = lp.id_lokasi
            JOIN JenisOlahraga jo ON l.id_Olahraga = jo.id_Olahraga
            JOIN Pengguna p ON b.id_Pengguna = p.id_Pengguna
            WHERE b.id_Pengguna = ?
        """;

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id_Pengguna);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking detail = new Booking();

                detail.setId_booking(rs.getString("id_booking"));
                
                // Pengguna
                detail.setPengguna(new Pengguna());
                detail.getPengguna().setId(id_Pengguna);
                detail.getPengguna().setNama(rs.getString("nama"));
                
                // Buat objek jadwal
                Jadwal jadwal = new Jadwal();
                jadwal.setTanggal(rs.getDate("tanggal").toLocalDate());
                jadwal.setJam_Mulai(rs.getTime("jam_mulai").toLocalTime());
                jadwal.setJam_Selesai(rs.getTime("jam_selesai").toLocalTime());

                // Buat objek lapangan
                Lapangan lapangan = new Lapangan();
                lapangan.setNama_lapangan(rs.getString("nama_lapangan"));
                lapangan.setHarga(rs.getDouble("harga_per_jam"));

                // Buat objek olahraga
                Olahraga olahraga = new Olahraga();
                olahraga.setNama_olahraga(rs.getString("nama_olahraga"));
                lapangan.setOlahraga(olahraga);

                // Buat objek lokasi
                LokasiLapangan lokasi = new LokasiLapangan();
                lokasi.setJalan(rs.getString("jalan"));
                lokasi.setRt_rw(rs.getString("rt_rw"));
                lokasi.setKelurahan(rs.getString("kelurahan"));
                lokasi.setKecamatan(rs.getString("kecamatan"));
                lokasi.setKota(rs.getString("kota"));
                lokasi.setProvinsi(rs.getString("provinsi"));
                lapangan.setLokasi(lokasi);

                // Gabungkan ke jadwal
                jadwal.setLapangan(lapangan);
                detail.addJadwal(jadwal);

                // Tambahkan ke daftar booking
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
        String sql = "INSERT INTO Booking(id_booking, id_pengguna, id_pembayaran) VALUES (?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getId_booking());
            stmt.setString(2, book.getPengguna().getId());
            stmt.setString(3, book.getPembayaran().getId());
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

                // Buat objek jadwal
                Jadwal jadwal = new Jadwal();
                jadwal.setTanggal(rs.getDate("tanggal").toLocalDate());
                jadwal.setJam_Mulai(rs.getTime("jam_mulai").toLocalTime());
                jadwal.setJam_Selesai(rs.getTime("jam_selesai").toLocalTime());

                // Buat objek lapangan
                Lapangan lapangan = new Lapangan();
                lapangan.setNama_lapangan(rs.getString("nama_lapangan"));
                lapangan.setHarga(rs.getDouble("harga_per_jam"));

                // Buat objek olahraga
                Olahraga olahraga = new Olahraga();
                olahraga.setNama_olahraga(rs.getString("nama_olahraga"));
                lapangan.setOlahraga(olahraga);

                // Buat objek lokasi
                LokasiLapangan lokasi = new LokasiLapangan();
                lokasi.setJalan(rs.getString("jalan"));
                lokasi.setRt_rw(rs.getString("rt_rw"));
                lokasi.setKelurahan(rs.getString("kelurahan"));
                lokasi.setKecamatan(rs.getString("kecamatan"));
                lokasi.setKota(rs.getString("kota"));
                lokasi.setProvinsi(rs.getString("provinsi"));
                lapangan.setLokasi(lokasi);

                // Gabungkan ke jadwal
                jadwal.setLapangan(lapangan);
                detail.addJadwal(jadwal);

            }
        } catch (SQLException e) {
            System.out.println("Error retrieving booking detail: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        return detail;
    }
    
    public ArrayList<String[]> getBookingInfo(String id_lapangan, String awal, String akhir) {
        ArrayList<String[]> listBook = new ArrayList<String[]>();
        String sql = """
                     SELECT Pengguna.username, Jadwal.id_jadwal, Pengguna.username, Jadwal.jam_mulai, Jadwal.tanggal as tanggal_jdwl, Lapangan.nama_lapangan, Pembayaran.tanggal as tanggal_byr, Lapangan.harga_per_jam, Pembayaran.status_pembayaran, Pembayaran.id_pembayaran
                     FROM Booking
                     JOIN Pengguna ON Pengguna.id_pengguna = Booking.id_pengguna
                     JOIN Pembayaran ON Booking.id_Pembayaran = Pembayaran.id_pembayaran
                     JOIN Jadwal ON Jadwal.id_jadwal = Booking.id_jadwal
                     JOIN Lapangan ON Lapangan.id_lapangan = Jadwal.id_lapangan
                     WHERE Jadwal.id_lapangan like ? AND Pembayaran.tanggal between ? AND ?
                     """;
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_lapangan);
            stmt.setString(2, awal);
            stmt.setString(3, akhir);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String[] row = new String[8];
                row[0] = rs.getString("username");
                row[1] = rs.getString("id_jadwal");
                row[2] = rs.getString("jam_mulai")+" / "+rs.getString("tanggal_jdwl");
                row[3] = rs.getString("nama_lapangan");
                row[4] = rs.getString("tanggal_byr");
                row[5] = rs.getString("harga_per_jam");
                row[6] = rs.getString("status_pembayaran");
                row[7] = rs.getString("id_pembayaran");
                
                listBook.add(row);
            }   
            
        } catch (SQLException e) {
            System.out.println("Error retrieving booking : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
        return listBook;
    }
}