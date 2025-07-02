/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClass;

/**
 *
 * @author Bani
 */
public class Pemilik {
    private String id_pemilik;
    private String password;
    private String nama;
    private String email;
    private String no_rek;
    private String contact_number;
    private Alamat id_alamat;

    public Pemilik(String id_pemilik, Alamat id_alamat, String password, String nama,  String email, String no_rek, String contact_number) {
        this.id_pemilik = id_pemilik;
        this.id_alamat = id_alamat;
        this.password = password;
        this.nama = nama;
        this.email = email;
        this.no_rek = no_rek;
        this.contact_number = contact_number;
    }

    public Pemilik() {}

    public String getId_pemilik() {
        return id_pemilik;
    }

    public void setId_pemilik(String id_pemilik) {
        this.id_pemilik = id_pemilik;
    }

    public Alamat getId_alamat() {
        return id_alamat;
    }

    public void setId_alamat(Alamat id_alamat) {
        this.id_alamat = id_alamat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getNo_rek() {
        return no_rek;
    }

    public void setNo_rek(String no_rek) {
        this.no_rek = no_rek;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

}
