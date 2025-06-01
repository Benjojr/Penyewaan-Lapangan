package MainClass;

import java.time.LocalDate;

public class Ulasan {
    private String idUlasan;
    private String komen;
    private Rating rating;
    private LocalDate tanggal;
    private Pengguna pengguna;
    private Lapangan lapangan;

    public Ulasan(String idUlasan, String komen, Rating rating, LocalDate tanggal, Pengguna pengguna, Lapangan lapangan) {
        this.idUlasan = idUlasan;
        this.komen = komen;
        this.rating = rating;
        this.tanggal = tanggal;
        this.pengguna = pengguna;
        this.lapangan = lapangan;
    }

    public Ulasan() {
        this.pengguna = new Pengguna();
        this.lapangan = new Lapangan();
    }

    public String getIdUlasan() {
        return idUlasan;
    }

    public void setIdUlasan(String idUlasan) {
        this.idUlasan = idUlasan;
    }

    public String getKomen() {
        return komen;
    }

    public void setKomen(String komen) {
        this.komen = komen;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }

    public void setTanggal(LocalDate tanggal) {
        this.tanggal = tanggal;
    }

    public Pengguna getPengguna() {
        return pengguna;
    }

    public void setPengguna(Pengguna pengguna) {
        this.pengguna = pengguna;
    }

    public Lapangan getLapangan() {
        return lapangan;
    }

    public void setLapangan(Lapangan lapangan) {
        this.lapangan = lapangan;
    }
}


