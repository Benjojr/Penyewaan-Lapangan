package ConnectionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        if (connection == null || connection.isClosed()) {
            String url = "jdbc:sqlserver://100.78.233.51:1433;"
                    + "database=Basis_Data_Sms_2;"
                    + "user=benn;"
                    + "password=Mucacos_26;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;"
                    + "loginTimeout=30;";
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url);
            } catch (ClassNotFoundException e) {
                System.out.println("SQL Server driver tidak ditemukan!");
            }
        }
        return connection;
    }
}
