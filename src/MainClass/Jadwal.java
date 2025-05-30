
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
    private boolean status;

    public Jadwal(String idJadwal, LocalDate tanggal, LocalTime jam_Mulai, LocalTime jam_Selesai, boolean status) {
        this.idJadwal = idJadwal;
        this.tanggal = tanggal;
        this.jam_Mulai = jam_Mulai;
        this.jam_Selesai = jam_Selesai;
        this.status = status;
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

    public boolean isStatus() {
        return status;
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

    public void setStatus(boolean status) {
        this.status = status;
    }
}
