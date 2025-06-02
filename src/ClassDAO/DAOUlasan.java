package ClassDAO;

import ConnectionClass.DatabaseConnection;
import MainClass.Ulasan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOUlasan {
    private int getnumID(Ulasan ulasan) {
        String temp = ulasan.getIdUlasan();
        temp = temp.substring(1);
        return Integer.parseInt(temp);
    }
    public String generateID() {
        List<Ulasan> ulasanList = getUlasanAll();
        int maxId = 0;
        for(Ulasan elem : ulasanList) {
            if(getnumID(elem)>maxId){
                maxId = getnumID(elem);
            }
        }
        return String.format("u%04d", (maxId+1));
    }

    public void addUlasan(String idUlasan, String komen, MainClass.Rating rating, String idPengguna, String idLapangan) {
        String sql = """
            INSERT INTO Ulasan (id_Ulasan, komen, rating, tanggal, id_Pengguna, id_lapangan)
            VALUES (?, ?, ?, ?, ?, ?)
                """;
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, idUlasan);
                stmt.setString(2, komen);
                stmt.setInt(3, rating.toInt());
                stmt.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
                stmt.setString(5, idPengguna);
                stmt.setString(6, idLapangan);
                stmt.executeUpdate();

                System.out.println("Ulasan added successfully.");
                
            } catch (Exception e) {
                System.err.println("Error adding ulasan: " + e.getMessage());
            }
        }

    public List<Ulasan> getUlasanAll() {
        ArrayList<Ulasan> ulasanList = new ArrayList<>();
        String sql = "SELECT * FROM Ulasan";

        try (Connection conn = DatabaseConnection.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Ulasan ulasan = new Ulasan();
                    ulasan.setIdUlasan(rs.getString("id_Ulasan"));
                    ulasan.setKomen(rs.getString("komen"));
                    int ratingValue = rs.getInt("rating");
                    ulasan.setRating(ratingValue >= 1 && ratingValue <= 5 ? 
                        MainClass.Rating.fromInt(ratingValue) :
                        MainClass.Rating.ONE); // Default to ONE if invalid
                    ulasan.setTanggal(rs.getDate("tanggal").toLocalDate());
                    ulasan.getPengguna().setId(rs.getString("id_Pengguna"));
                    ulasan.getLapangan().setId_lapangan(rs.getString("id_Lapangan"));
                    ulasanList.add(ulasan);
                }
            } catch (Exception e) {
                System.err.println("Error processing result set: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error retrieving ulasan: " + e.getMessage());
        }
        return ulasanList;
    }

    public List<Ulasan> getUlasanByLapangan(String idLapangan) {
        List<Ulasan> ulasanList = new ArrayList<>();
        String sql = "SELECT * FROM Ulasan WHERE id_Lapangan = ?";

        try (Connection conn = DatabaseConnection.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, idLapangan);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Ulasan ulasan = new Ulasan();
                    ulasan.setIdUlasan(rs.getString("id_Ulasan"));
                    ulasan.setKomen(rs.getString("komen"));
                    int ratingValue = rs.getInt("rating");
                    ulasan.setRating(ratingValue >= 1 && ratingValue <= 5 ? 
                        MainClass.Rating.fromInt(ratingValue) : MainClass.Rating.ONE); // Default to ONE if invalid
                    ulasan.setTanggal(rs.getDate("tanggal").toLocalDate());
                    ulasan.getPengguna().setId(rs.getString("id_Pengguna"));
                    ulasan.getLapangan().setId_lapangan(rs.getString("id_Lapangan"));
                    ulasanList.add(ulasan);
                }
            } catch (Exception e) {
                System.err.println("Error processing result set: " + e.getMessage());
            }
        } catch (Exception e) {
            System.err.println("Error retrieving ulasan by lapangan: " + e.getMessage());
        }
        return ulasanList;
    }
}
