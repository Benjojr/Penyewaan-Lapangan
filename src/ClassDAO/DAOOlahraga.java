package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Olahraga;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bani
 */
public class DAOOlahraga {
    public List<Olahraga> getAllOlahraga() {
        List<Olahraga> olahragaList = new ArrayList<>();
        String sql = "SELECT * FROM JenisOlahraga";
        
        try (Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                olahragaList.add(new Olahraga(
                    rs.getString("id_olahraga"),
                    rs.getString("nama_olahraga")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Error get all olahraga: " + e.getMessage());
        }
        return olahragaList;
    }
    
    public Olahraga getOlahragaByName(String namaOlahraga) {
        String sql = "SELECT * FROM JenisOlahraga WHERE nama_olahraga = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, namaOlahraga);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Olahraga(
                        rs.getString("id_olahraga"),
                        rs.getString("nama_olahraga")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error get olahraga by name: " + e.getMessage());
        }
        return null;
    }
}


