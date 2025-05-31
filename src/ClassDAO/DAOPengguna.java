/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassDAO;

import ConnectionClass.*;
import MainClass.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DAOPengguna {
    // Removed instance since getConnection is static
    
        public Pengguna LoadSome(String username) {
        String sql = "SELECT * FROM Pengguna WHERE Username like '"+username+"'";
        try (Connection conn = DatabaseConnection.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pengguna(
                        rs.getString("id_Pengguna"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("Username"),
                        rs.getString("Jenis_langganan"),
                        rs.getString("password")
                    );
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Pengguna LoadSomeById(String id_Pengguna) {
        String sql = "SELECT * FROM Pengguna WHERE id_Pengguna = ?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, id_Pengguna); // Set parameter safely
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pengguna(
                        rs.getString("id_Pengguna"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("Username"),
                        rs.getString("Jenis_langganan"),
                        rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            // Log the exception properly instead of just printing
            System.err.println("Error loading Pengguna by ID: " + e.getMessage());
        }
    return null;
}


    public ArrayList<Pengguna> LoadAll() {
        ArrayList<Pengguna> penggunas = new ArrayList<Pengguna>();
        String sql = "SELECT * FROM Pengguna";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    penggunas.add( new Pengguna(
                        rs.getString("id_Pengguna"),
                        rs.getString("no_hp"),
                        rs.getString("email"),
                        rs.getString("Username"),
                        rs.getString("Jenis_langganan"),
                        rs.getString("password")
                    ));
                }
                return penggunas;
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void Regist(String id, String no_telp,String email, String UserName, String password)  {
        String sql = "INSERT INTO Pengguna(id_Pengguna, no_Hp, email, Username, jenis_Langganan, password) VALUES (?,?,?,?,'Reguler',?)";
        try (Connection conn = DatabaseConnection.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,id);
            stmt.setString(2,no_telp);
            stmt.setString(3,email);
            stmt.setString(4,UserName);
            stmt.setString(5,password);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proses Pendaftaran Berhasil.", "Information",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void DeletePengguna(String username) {
        Pengguna temp = LoadSome(username);
        if(temp!=null) {
            String sql = "DELETE FROM Pengguna WHERE Username like '"+username+"'";
            try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Pengguna telah dihapus.", "Information",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pengguna tidak ditemukan.", "Information",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
