
package MainClass;

import java.util.ArrayList;

public class Booking {
    private String id_booking;
    private Pengguna pengguna;
    private final ArrayList<Jadwal> jadwal = new ArrayList<>();
    private Jadwal jadwali;
    private Pembayaran pembayaran;

    public Booking(String id_booking, Jadwal jadwal, Pengguna id_Pengguna, Pembayaran pembayaran) {
        this.id_booking = id_booking;
        this.jadwali = jadwal;
        this.pengguna = id_Pengguna;
        this.pembayaran = pembayaran;
    }

    public Booking(){
        this.pengguna = new Pengguna();
        this.pembayaran = new Pembayaran();
        this.jadwali = new Jadwal();
    }

    public String getId_booking() {
        return id_booking;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(Pembayaran pembayaran) {
        this.pembayaran = pembayaran;
    }

    public void setId_booking(String id_booking) {
        this.id_booking = id_booking;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna id_Pengguna) {
        this.pengguna = id_Pengguna;
    }

    public ArrayList<Jadwal> getJadwal() {
        return jadwal;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal.add(jadwal);
    }

    public Jadwal getClassJadwal() {
        return jadwali;
    }
    
    public Lapangan getLapangan() {
        return this.jadwali.getLapangan();
    }
}
