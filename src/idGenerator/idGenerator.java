package idGenerator;

import ConnectionClass.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bani
 * Jadi digunain ketika hendak insert ke Database yak!
 */
public class idGenerator {
     public static String getNextID(String tableName, String preffix, String column) {
        String newID = preffix + "0001";
        String sql = "SELECT TOP 1 " + column + " FROM " + tableName + " ORDER BY " + column + " DESC";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    String lastID = rs.getString(1);
                    int lastNumber = Integer.parseInt(lastID.substring(preffix.length()));
                    newID = preffix + String.format("%03d", lastNumber + 1);
                }
            
        } catch (SQLException e) {
            System.err.println("ERROR dari database : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("ERROR : " + e.getMessage());
        }
        return newID;
    }
}
