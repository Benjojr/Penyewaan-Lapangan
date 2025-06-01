/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Jadwal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author benja
 */
public class DAOJadwal {
    public ArrayList<Jadwal> getJadwalByLapangan(String idLapangan) {
        ArrayList<Jadwal> list = new ArrayList<>();
        String sql = "SELECT * FROM Jadwal WHERE id_Lapangan = ?";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, idLapangan);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Jadwal jadwal = new Jadwal(
                            rs.getString("id_Jadwal"),
                            rs.getDate("tanggal").toLocalDate(),
                            rs.getTime("jam_mulai").toLocalTime(),
                            rs.getTime("jam_selesai").toLocalTime(),
                            (rs.getByte("status_book"))==0?false:true);
                    list.add(jadwal);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return list;
    }
    
    public void RegistJadwal(Jadwal jadwal)  {
        String sql = "INSERT INTO Jadwal(id_Jadwal, tanggal, jam_mulai, jam_selesai, id_booking, id_lapangan) VALUES (?,?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,jadwal.getIdJadwal());
            stmt.setString(2,jadwal.getTanggal().toString());
            stmt.setString(3,jadwal.getJam_Mulai().toString());
            stmt.setString(4,jadwal.getJam_Selesai().toString());
            stmt.setString(5,jadwal.getIdBooking());
            stmt.setString(6,jadwal.getIdLapangan());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proses Pendaftaran Jadwal Berhasil.", "Information",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
