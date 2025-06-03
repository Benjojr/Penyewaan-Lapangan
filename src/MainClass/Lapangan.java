/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClass;

import java.util.ArrayList;

/**
 *
 * @author bani
 */
public class Lapangan {
    private String id_lapangan;
    private String lokasi;
    private double harga;
    private String nama_lapangan;
    private Olahraga olahraga;
    private Jadwal jadwal;
    private final ArrayList<Jadwal> jadwals = new ArrayList<>();

    public Lapangan(String id_lapangan, String lokasi, double harga, String nama_lapangan, Olahraga olahraga) {
        this.id_lapangan = id_lapangan;
        this.lokasi = lokasi;
        this.harga = harga;
        this.nama_lapangan = nama_lapangan;
        this.olahraga = olahraga;
    }
    

    public Lapangan(){
        this.olahraga = new Olahraga();
        this.jadwal = new Jadwal();
    }

    public String getId_lapangan() {
        return id_lapangan;
    }

    public void setId_lapangan(String id_lapangan) {
        this.id_lapangan = id_lapangan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getNama_lapangan() {
        return nama_lapangan;
    }

    public void setNama_lapangan(String nama_lapangan) {
        this.nama_lapangan = nama_lapangan;
    }

    public Olahraga getOlahraga() {
        return olahraga;
    }

    public void setOlahraga(Olahraga olahraga) {
        this.olahraga = olahraga;
    }

    public Jadwal getJadwal() {
        return jadwal;
    }

    public ArrayList<Jadwal> getAllJadwal() {
        return jadwals;
    }

    public void setJadwal(Jadwal jadwal) {
        this.jadwal = jadwal;
    }
}
