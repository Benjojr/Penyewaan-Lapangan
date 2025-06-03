
package DebugFiles;

import ClassDAO.DAOBookingDetail;
import MainClass.Booking;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOBookingDetail daobook = new DAOBookingDetail();
        List<Booking> bookings = daobook.getBookingDetail("p0001");
        if (!bookings.isEmpty()) {
            for (Booking booking : bookings) {
                System.out.println("id booking : " + booking.getId_booking());
                System.out.println("nama pengguna : " + booking.getPengguna().getUserName());
                System.out.println("Jam Mulai : " + booking.getClassJadwal().getJam_Mulai());
            }
        }
    }
}
