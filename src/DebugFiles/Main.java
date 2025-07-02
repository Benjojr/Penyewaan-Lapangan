
package DebugFiles;

import ClassDAO.DAOBookingDetail;
import MainClass.Booking;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOBookingDetail daoBookingDetail = new DAOBookingDetail();

        // Fetch all booking details
        List<Booking> booking = daoBookingDetail.getBookingDetail("P001");
        if (booking.isEmpty()) {
            System.out.println("No booking details found.");
        } else {
            // Print each booking detail
            for (Booking detail : booking) {
                System.out.println("Booking ID: " + detail.getId_booking());
                System.out.println("Pengguna: " + detail.getPengguna().getUserName());
                System.out.println("Jadwal: " + detail.getJadwal().get(0).getTanggal() + " from " 
                                   + detail.getJadwal().get(0).getJam_Mulai() + " to " 
                                   + detail.getJadwal().get(0).getJam_Selesai());
                System.out.println("Lapangan: " + detail.getJadwal().get(0).getLapangan().getNama_lapangan());
                System.out.println("Harga: " + detail.getJadwal().get(0).getLapangan().getHarga());
                System.out.println("-----------------------------");
            }
        }
    }
}
