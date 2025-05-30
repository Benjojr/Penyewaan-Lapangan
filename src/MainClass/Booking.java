
package MainClass;

public class Booking {
    private String id_booking;
    private Pengguna pengguna;
    private Jadwal jadwal;
    private Lapangan lapangan;

    public Booking(String id_booking, Pengguna id_Pengguna, Jadwal jadwal, Lapangan lapangan) {
        this.id_booking = id_booking;
        this.pengguna = id_Pengguna;
        this.jadwal = jadwal;
        this.lapangan = lapangan;
    }

    public Booking(){

        this.pengguna = new Pengguna();
        this.jadwal = new Jadwal();
        this.lapangan = new Lapangan();

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

    public Jadwal getJadwal() {
        return jadwal;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }

    public Lapangan getLapangan() {
        return lapangan;
    }

    public void setLapangan(Lapangan lapangan) {
        this.lapangan = lapangan;
    }

    
}
