/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.*;
import java.util.ArrayList;

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
            double hargaAkhir = pembayaran.getHargaAkhir();
            stmt.setString(1, id);
            stmt.setString(2, pembayaran.getKodePembayaran());
            stmt.setString(3, pembayaran.getPemesanan().getId_booking());
            stmt.setString(4, pembayaran.getTanggal().toString());
            stmt.setString(5, pembayaran.getJam().toString());
            stmt.setString(6, status);
            stmt.setString(7, String.valueOf(pembayaran.getHargaAwal()));
            stmt.setString(8, String.valueOf(hargaAkhir));
            
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }  
    
    public ArrayList<Pembayaran> LoadAll() {
        ArrayList<Pembayaran> pembayarans = new ArrayList<>();
        String sql = "SELECT * FROM Pembayaran";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pembayarans.add( new Pembayaran(
                        rs.getString("kode_Pembayaran"),
                        Double.parseDouble(rs.getString("harga_akhir")),
                        rs.getString("status_Pembayaran").equals("1"),
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
        ArrayList<String> ids = new ArrayList<>();
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