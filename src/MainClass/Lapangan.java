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
    private double harga;
    private double luas;
    private Fasilitas fasilitas;
    private LokasiLapangan lokasiLapangan;
    private String nama_lapangan;
    private Pemilik pemilik;
    private Olahraga olahraga;
    private Jadwal jadwal;
    private String status;
    private final ArrayList<Jadwal> jadwals = new ArrayList<>();

    public Lapangan(String id_lapangan, String nama_lapangan, double harga, double luas, Olahraga olahraga, LokasiLapangan lokasiLapangan, Pemilik pemilik, Fasilitas fasilitas, String status) {
        this.id_lapangan = id_lapangan;
        this.harga = harga;
        this.luas = luas;
        this.nama_lapangan = nama_lapangan;
        this.olahraga = olahraga;
        this.lokasiLapangan = lokasiLapangan;
        this.pemilik = pemilik;
        this.fasilitas = fasilitas;
        this.status = status;
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

    public LokasiLapangan getLokasi() {
        return lokasiLapangan;
    }

    public void setLokasi(LokasiLapangan lokasiLapangan) {
        this.lokasiLapangan = lokasiLapangan;
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

    public Fasilitas getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(Fasilitas fasilitas) {
        this.fasilitas = fasilitas;
    }

    public Pemilik getPemilik() {
        return pemilik;
    }

    public void setPemilik(Pemilik pemilik) {
        this.pemilik = pemilik;
    }

    public LokasiLapangan getLokasiLapangan() {
        return lokasiLapangan;
    }

    public void setLokasiLapangan(LokasiLapangan lokasiLapangan) {
        this.lokasiLapangan = lokasiLapangan;
    }

    public double getLuas() {
        return luas;
    }

    public void setLuas(double luas) {
        this.luas = luas;
    }

    public void addJadwal(Jadwal jadwal) {
        this.jadwals.add(jadwal);
    }
    
    public String getStatus(){
        return status;
    }
}
