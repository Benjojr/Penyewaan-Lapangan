/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import MainClass.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Axioo Pongo
 */
public class DAOPembayaran {
    DAOBookingDetail daobook = new DAOBookingDetail();
    public void Regist(String id, Pembayaran pembayaran)  {
        String sql = "INSERT INTO Pembayaran(id_Pembayaran, kode_Pembayaran, id_Booking, Tanggal, waktu, status_Pembayaran, harga_awal, harga_akhir) VALUES (?,?,?,?,?,?,?,?)";
        String status = (pembayaran.isStatus())? "1":"0" ;
        try (Connection conn = DatabaseConnection.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,id);
            stmt.setString(2,pembayaran.getKodePembayaran());
            stmt.setString(3,pembayaran.getPemesanan().getId_booking());
            stmt.setString(4,pembayaran.getTanggal().toString());
            stmt.setString(5,pembayaran.getJam().toString());
            stmt.setString(6,status);
            stmt.setString(7,String.valueOf(pembayaran.getHargaAwal()));
            stmt.setString(8,String.valueOf(pembayaran.getHargaAkhir()));
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proses Pencatatan Pembayaran Berhasil.", "Information",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
    
    public ArrayList<Pembayaran> LoadAll() {
        ArrayList<Pembayaran> pembayarans = new ArrayList<Pembayaran>();
        String sql = "SELECT * FROM Pembayaran";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pembayarans.add( new Pembayaran(
                        rs.getString("kode_Pembayaran"),
                        Double.parseDouble(rs.getString("harga_akhir")),
                        (rs.getString("status_Pembayaran").equals("1"))?true:false,
                        LocalDate.parse(rs.getString("Tanggal")),
                        LocalTime.parse(rs.getString("waktu")),
                        daobook.getBooking(rs.getString("id_Booking"))
                    ));
                }
                return pembayarans;
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public ArrayList<String> LoadAllId() {
        ArrayList<String> ids = new ArrayList<String>();
        String sql = "SELECT * FROM Pembayaran";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ids.add( rs.getString("id_Pembayaran"));
                }
                return ids;
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
}
