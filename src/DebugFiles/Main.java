
package DebugFiles;

import ClassDAO.DAOLangganan;
import MainClass.Booking;

public class Main {
    public static void main(String[] args) {
        Booking booking = new Booking();
        DAOLangganan daoLangganan = new DAOLangganan();
        double hargaAwal = booking.getLapangan().getHarga() * booking.getJadwal().size(); 
        double potongan = daoLangganan.LoadSomeById(booking.getPengguna().getJenis_langganan()).getPotongan() * hargaAwal;
        double hargaAkhir = hargaAwal - potongan;
        System.out.println(hargaAkhir);
    }
}
