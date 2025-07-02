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
    private String username;
    private Alamat alamat;

    public Pemilik(String id_pemilik, String password, String nama,  String email, String no_rek, String contact_number, String username, Alamat alamat) {
        this.id_pemilik = id_pemilik;
        this.alamat = alamat;
        this.password = password;
        this.nama = nama;
        this.email = email;
        this.no_rek = no_rek;
        this.username = username;
        this.contact_number = contact_number;
    }

    public Pemilik() {}

    public String getId_pemilik() {
        return id_pemilik;
    }

    public void setId_pemilik(String id_pemilik) {
        this.id_pemilik = id_pemilik;
    }

    public Alamat getalamat() {
        return this.alamat;
    }

    public void setalamat(Alamat alamat) {
        this.alamat = alamat;
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
    
    public String getUsername() {
        return this.username;
    }

}
