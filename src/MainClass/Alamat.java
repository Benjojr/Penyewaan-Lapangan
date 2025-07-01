/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClass;

/**
 *
 * @author benja
 */
public class Alamat {
    private int idAlamat;
    private String jalan;
    private String rtRw;
    private String kelurahan;
    private String kecamatan;
    private String kota;
    private String provinsi;

    // Constructor
    public Alamat(int idAlamat, String jalan, String rtRw, String kelurahan,
                  String kecamatan, String kota, String provinsi) {
        this.idAlamat = idAlamat;
        this.jalan = jalan;
        this.rtRw = rtRw;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.kota = kota;
        this.provinsi = provinsi;
    }

    // Getter dan Setter
    public int getIdAlamat() {
        return idAlamat;
    }

    public void setIdAlamat(int idAlamat) {
        this.idAlamat = idAlamat;
    }

    public String getJalan() {
        return jalan;
    }

    public void setJalan(String jalan) {
        this.jalan = jalan;
    }

    public String getRtRw() {
        return rtRw;
    }

    public void setRtRw(String rtRw) {
        this.rtRw = rtRw;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
}
