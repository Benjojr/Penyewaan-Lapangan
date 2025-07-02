package MainClass;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pembayaran {
    private LocalDate tanggal;
    private LocalTime jam;
    private String metode_pembayaran;
    private double jumlah;
    private boolean status_pembayaran;
    
    public Pembayaran(LocalDate tanggal, LocalTime jam, String metode_pembayaran, double jumlah, boolean status_pembayaran) {
        this.tanggal = tanggal;
        this.jam = jam;
        this.metode_pembayaran = metode_pembayaran;
        this.jumlah = jumlah;
        this.status_pembayaran = status_pembayaran;
    }
    

    public Pembayaran(){}

    public boolean isStatusPembayaran() {
        return status_pembayaran;
    }

    public void setStatus(boolean status_pembayaran) {
        this.status_pembayaran = status_pembayaran;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public LocalTime getJam() {
        return jam;
    }

    public void setJam(LocalTime jam) {
        this.jam = jam;
    }

    public String getMetodePembayaran() {
        return metode_pembayaran;
    }

    public void setMetodePembayaran(String metode_pembayaran) {
        this.metode_pembayaran = metode_pembayaran;
    }

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }
}
