package MainClass;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author bani
 */
public class Jadwal {
    private String id_jadwal;
    private LocalDate tanggal;
    private LocalTime jam_Mulai;
    private LocalTime jam_Selesai;
    private Lapangan id_lapangan;

    public Jadwal(String id_jadwal, LocalDate tanggal, LocalTime jam_Mulai, LocalTime jam_Selesai, Lapangan id_lapangan) {

        this.id_jadwal = id_jadwal;
        this.tanggal = tanggal;
        this.jam_Mulai = jam_Mulai;
        this.jam_Selesai = jam_Selesai;
        this.id_lapangan = id_lapangan;
    }

    public Jadwal(){}

    public String getIdJadwal() {
        return id_jadwal;
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
    
    public Lapangan getLapangan() {
        return id_lapangan;
    }

    public void setIdJadwal(String idJadwal) {
        this.id_jadwal = idJadwal;
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
