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
        String sql = "SELECT * FROM Olahraga";
        
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
}
