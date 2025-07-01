package MainClass;

import java.time.LocalDate;

public class Pengguna {
    private String id;
    private String nama;
    private String email;
    private String no_hp;
    private LocalDate tanggal_lahir;
    private Alamat alamat;
    private Langganan subscription;
    private String password;
    private String username;

    public Pengguna(String id, String nama, String email, String no_hp, LocalDate tanggal_lahir, Alamat alamat,
            Langganan subscription, String password, String username) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.no_hp = no_hp;
        this.tanggal_lahir = tanggal_lahir;
        this.password = password;
        this.alamat = alamat;
        this.subscription = subscription;
        this.username = username;
    }

    public Pengguna() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public LocalDate getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(LocalDate tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public void setAlamat(Alamat alamat) {
        this.alamat = alamat;
    }

    public Alamat getAlamat() {
        return alamat;
    }
}
