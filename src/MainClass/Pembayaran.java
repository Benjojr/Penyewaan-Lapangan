package MainClass;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pembayaran {
    private String kodePembayaran;
    private double hargaAwal;
    private double hargaAkhir;
    private boolean status;
    private LocalDate tanggal;
    private LocalTime jam;
    private Booking pemesanan;
    
    public Pembayaran(String kodePembayaran, double hargaAkhir, boolean status, LocalDate tanggal, LocalTime jam, Booking pemesanan) {
        this.kodePembayaran = kodePembayaran;
        this.hargaAkhir = hargaAkhir;
        this.status = status;
        this.tanggal = tanggal;
        this.jam = jam;
        this.pemesanan = pemesanan;
        this.hargaAwal = pemesanan.getClassJadwal().getLapangan().getHarga();
    }

    public Pembayaran() {}
    
    public String getKodePembayaran() {
        return kodePembayaran;
    }

    public void setKodePembayaran(String kodePembayaran) {
        this.kodePembayaran = kodePembayaran;
    }

    public double getHargaAwal() {
        return hargaAwal;
    }

    public void setHargaAwal(double hargaAwal) {
        this.hargaAwal = hargaAwal;
    }

    public double getHargaAkhir() {
        return hargaAkhir;
    }

    public void setHargaAkhir(double hargaAkhir) {
        this.hargaAkhir = hargaAkhir;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public Booking getPemesanan() {
        return pemesanan;
    }

    public void setPemesanan(Booking pemesanan) {
        this.pemesanan = pemesanan;
    }
}
