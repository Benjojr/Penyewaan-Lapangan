
package DebugFiles;

import ClassDAO.*;
import MainClass.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Pengguna p1;
        
        // DAOPengguna pd1 = new DAOPengguna();
        
        // p1 = pd1.LoadSome("p0001");
        
        // System.out.println(p1.getNo_telp());

        DAOBookingDetail bd1 = new DAOBookingDetail();
        List<Booking> detail = bd1.getBookingDetail("p0001");

        if (detail != null && !detail.isEmpty()) {
            for (Booking booking : detail) {
                System.out.println("Booking ID: " + booking.getId_booking());
                System.out.println("Username: " + booking.getPengguna().getUserName());
                System.out.println("Lapangan: " + booking.getLapangan().getOlahraga().getNama_olahraga());
                System.out.println("Tanggal: " + booking.getJadwal().getTanggal());
                System.out.println("Jam Mulai: " + booking.getJadwal().getJam_Mulai());
                System.out.println("Jam Selesai: " + booking.getJadwal().getJam_Selesai());
                System.out.println("------------------------");
            }
        } else {
            System.out.println("No booking details found for the user.");
        }
    }
}
