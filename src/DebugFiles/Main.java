
package DebugFiles;

import ClassDAO.DAOUlasan;
import MainClass.Ulasan;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        DAOUlasan daoUlasan = new DAOUlasan();
        List<Ulasan> ulasanList = daoUlasan.getUlasanByLapangan("l0001");
        if (ulasanList.isEmpty()) {
            System.out.println("Tidak ada ulasan untuk lapangan ini.");
        } else {
            for (Ulasan ulasan : ulasanList) {
                System.out.println("ID Ulasan: " + ulasan.getIdUlasan());
                System.out.println("Komentar: " + ulasan.getKomen());
                System.out.println("Rating: " + ulasan.getRating());
                System.out.println("Tanggal: " + ulasan.getTanggal());
                System.out.println("ID Pengguna: " + ulasan.getPengguna().getId());
                System.out.println("ID Lapangan: " + ulasan.getLapangan().getId_lapangan());
                System.out.println("-----------------------------");
            }
        }
    }
}
