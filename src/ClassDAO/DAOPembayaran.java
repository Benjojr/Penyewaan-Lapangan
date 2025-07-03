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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Axioo Pongo
 */
public class DAOPembayaran {
    DAOBookingDetail daobook = new DAOBookingDetail();
    
    public void Regist(Pembayaran pembayaran, String tipePembayaran)  {
        String sql = "INSERT INTO Pembayaran(id_pembayaran, tanggal, jam, metode_pembayaran, jumlah, status_pembayaran) VALUES (?,?,?,?,?,?)";
        try (Connection conn = DatabaseConnection.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pembayaran.getId());
            stmt.setString(2, pembayaran.getTanggal().toString());
            stmt.setString(3, pembayaran.getJam().toString());
            stmt.setString(4, pembayaran.getMetodePembayaran());
            stmt.setDouble(5, pembayaran.getJumlah());
            stmt.setString(6, tipePembayaran);
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
                        rs.getString("id_pembayaran"),
                        rs.getDate("tanggal").toLocalDate(),
                        rs.getTime("jam").toLocalTime(),
                        rs.getString("metode_pembayaran"),
                        rs.getDouble("jumlah"),
                        rs.getBoolean("status_pembayaran")
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
    
    public void Lunasi(String id_pembayaran) {
        String sql = "UPDATE Pembayaran SET status_pembayaran = 'Lunas' WHERE id_pembayaran = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, id_pembayaran);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pembayaran telah dilunasi.", "Information",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}