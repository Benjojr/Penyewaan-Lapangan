/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClass;

/**
 *
 * @author Bani
 */
public class LokasiLapangan {
    private String id_lokasi;
    private String jalan;
    private String rt_rw;
    private String kelurahan;
    private String kecamatan;
    private String kota;
    private String provinsi;

    public LokasiLapangan(String id_lokasi, String jalan, String rt_rw, String kelurahan, String kecamatan, String kota, String provinsi) {
        this.id_lokasi = id_lokasi;
        this.jalan = jalan;
        this.rt_rw = rt_rw;
        this.kelurahan = kelurahan;
        this.kecamatan = kecamatan;
        this.kota = kota;
        this.provinsi = provinsi;
    }

    public LokasiLapangan() {}

    public String getId_lokasi() {
        return id_lokasi;
    }

    public void setId_lokasi(String id_lokasi) {
        this.id_lokasi = id_lokasi;
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
}


