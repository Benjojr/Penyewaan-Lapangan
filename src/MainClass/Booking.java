
package MainClass;

import java.util.ArrayList;

public class Booking {
    private String id_booking;
    private Pengguna pengguna;
    private final ArrayList<Jadwal> jadwal = new ArrayList<>();
    private Lapangan lapangan;
    private Jadwal jadwali;

    public Booking(String id_booking, Pengguna id_Pengguna, Lapangan lapangan) {
        this.id_booking = id_booking;
        this.pengguna = id_Pengguna;
        this.lapangan = lapangan;
    }

    public Booking(){
        this.pengguna = new Pengguna();
        this.lapangan = new Lapangan();
        this.jadwali = new Jadwal();
    }

    public String getId_booking() {
        return id_booking;
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

    public Lapangan getLapangan() {
        return lapangan;
    }

    public void setLapangan(Lapangan lapangan) {
        this.lapangan = lapangan;
    }

    public Jadwal getClassJadwal() {
        return jadwali;
    }
}
