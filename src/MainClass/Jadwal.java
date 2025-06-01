
package MainClass;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author bani
 */
public class Jadwal {
    private String idJadwal;
    private LocalDate tanggal;
    private LocalTime jam_Mulai;
    private LocalTime jam_Selesai;
    private String id_Booking;
    private String id_lapangan;

    public Jadwal(String idJadwal, LocalDate tanggal, LocalTime jam_Mulai, LocalTime jam_Selesai, String id_Booking, String id_lapangan) {

        this.idJadwal = idJadwal;
        this.tanggal = tanggal;
        this.jam_Mulai = jam_Mulai;
        this.jam_Selesai = jam_Selesai;
        this.id_Booking = id_Booking;
        this.id_lapangan = id_lapangan;
    }

    public Jadwal(){}

    public String getIdJadwal() {
        return idJadwal;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public LocalTime getJam_Mulai() {
        return jam_Mulai;
    }

    public LocalTime getJam_Selesai() {
        return jam_Selesai;
    }
    
    public String getIdBooking() {
        return id_Booking;
    }
    
    public String getIdLapangan() {
        return id_lapangan;
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal = idJadwal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public void setJam_Mulai(LocalTime jam_Mulai) {
        this.jam_Mulai = jam_Mulai;
    }

    public void setJam_Selesai(LocalTime jam_Selesai) {
        this.jam_Selesai = jam_Selesai;
    }
}
