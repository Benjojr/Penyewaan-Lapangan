/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainClass;

/**
 *
 * @author bani
 */
public class Olahraga {
    private String id_olahraga;
    private String nama_olahraga;

    public Olahraga(String id_olahraga, String nama_olahraga) {
        this.id_olahraga = id_olahraga;
        this.nama_olahraga = nama_olahraga;
    }

    public Olahraga(){}

    public String getId_olahraga() {
        return id_olahraga;
    }

    public void setId_olahraga(String id_olahraga) {
        this.id_olahraga = id_olahraga;
    }

    public String getNama_olahraga() {
        return nama_olahraga;
    }

    public void setNama_olahraga(String nama_olahraga) {
        this.nama_olahraga = nama_olahraga;
    }
}
