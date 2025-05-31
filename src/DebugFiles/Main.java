
package DebugFiles;

import ClassDAO.*;
import MainClass.*;

import GUI.*;
import java.time.LocalDateTime;
import java.time.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        // Pengguna p1;
        
//        DAOPengguna pd1 = new DAOPengguna();
//        pd1.DeletePengguna("halo");
        // p1 = pd1.LoadSome("p0001");
        
        // System.out.println(p1.getNo_telp());


//        DAOBookingDetail bd1 = new DAOBookingDetail();
//        Booking detail = bd1.getBookingDetail("b0001");
//        if (detail != null) {
//            System.out.println("ID Booking: " + detail.getId_booking());
//            System.out.println("Username: " + detail.getPengguna().getUserName());
//            System.out.println("Lapangan: " + detail.getLapangan().getNama_lapangan());
//            System.out.println("Lokasi: " + detail.getLapangan().getLokasi());
//            System.out.println("Harga: " + detail.getLapangan().getHarga());
//            System.out.println("Olahraga: " + detail.getLapangan().getOlahraga().getNama_olahraga());
//            System.out.println("Tanggal: " + detail.getJadwal().getTanggal());
//            System.out.println("Jam Mulai: " + detail.getJadwal().getJam_Mulai());
//            System.out.println("Jam Selesai: " + detail.getJadwal().getJam_Selesai());
//        } else {
//            System.out.println("No booking details found for the user.");
//        }
        
//        int randomNum; 
//        for(int i=0;i<5;i++) {
//            randomNum = 10000+((int)(Math.random() * 90000));
//            System.out.println(randomNum);
//        }

//         LocalDateTime w = LocalDateTime.now();
//         System.out.println(w.getMonth());

    LocalDate tanggal = LocalDate.of(2025, Month.MAY, 31);
    LocalTime waktu = LocalTime.now();
    
    DAOBookingDetail daobook = new DAOBookingDetail();
    Booking book1 = (Booking) daobook.getBookingDetail("b0001");
        System.out.println(book1.getJadwal().getIdJadwal());
    PembayaranFrame pbf = new PembayaranFrame(book1, "Qris");
    pbf.setVisible(true);
    
    Pembayaran pembayaran = new Pembayaran("12312", 20000, true, tanggal,waktu, book1);
    DAOPembayaran daobyr = new DAOPembayaran();
    ArrayList<String> ids = daobyr.LoadAllId();
    
    for(String elem : ids){
        String id = elem.substring(3);
        System.out.println(Integer.parseInt(id));
    }
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
