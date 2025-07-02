/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClass;

import java.util.StringJoiner;

/**
 *
 * @author Bani
 */
public class Alamat {
    private String id_alamat;
    private String jalan;
    private String rt_rw;
    private String kelurahan;
    private String kecamatan;
    private String kota;
    private String provinsi;

    public Alamat(String id_alamat, String jalan, String rt_rw, String kelurahan, String kecamatan, String kota, String provinsi) {
        this.id_alamat = id_alamat;
        this.jalan = jalan;
        this.rt_rw = rt_rw;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.kota = kota;
        this.provinsi = provinsi;
    }

    public Alamat() {}

    public String getId_alamat() {
        return id_alamat;
    }

    public void setId_alamat(String id_alamat) {
        this.id_alamat = id_alamat;
    }

    public String getJalan() {
        return jalan;
    }

    public void setJalan(String jalan) {
        this.jalan = jalan;
    }

    public String getRt_rw() {
        return rt_rw;
    }

    public void setRt_rw(String rt_rw) {
        this.rt_rw = rt_rw;
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

    public String toStrings() {
        StringJoiner temp = new StringJoiner(", ");
        temp.add(rt_rw);
        temp.add(jalan);
        temp.add(kelurahan);
        temp.add(kecamatan);
        temp.add(kota);
        temp.add(provinsi);
        return temp.toString();
        
    }
}
