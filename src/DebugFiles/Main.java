
package DebugFiles;

import ClassDAO.*;
import MainClass.*;

public class Main {
    public static void main(String[] args) {
        // Pengguna p1;
        
        // DAOPengguna pd1 = new DAOPengguna();
        
        // p1 = pd1.LoadSome("p0001");
        
        // System.out.println(p1.getNo_telp());

        DAOBookingDetail bd1 = new DAOBookingDetail();
        Booking detail = bd1.getBookingDetail("b0001");
        if (detail != null) {
            System.out.println("ID Booking: " + detail.getId_booking());
            System.out.println("Username: " + detail.getPengguna().getUserName());
            System.out.println("Lapangan: " + detail.getLapangan().getNama_lapangan());
            System.out.println("Lokasi: " + detail.getLapangan().getLokasi());
            System.out.println("Harga: " + detail.getLapangan().getHarga());
            System.out.println("Olahraga: " + detail.getLapangan().getOlahraga().getNama_olahraga());
            System.out.println("Tanggal: " + detail.getJadwal().getTanggal());
            System.out.println("Jam Mulai: " + detail.getJadwal().getJam_Mulai());
            System.out.println("Jam Selesai: " + detail.getJadwal().getJam_Selesai());
        } else {
            System.out.println("No booking details found for the user.");
        }
        
    }
}
