
package MainClass;

public class Langganan {
    String id_Langganan;
    String jenisLangganan;
    double potongan;
    double harga;
    
     public Langganan(String id_langganan, String jenisLangganan, double potongan, double harga) {
        this.id_Langganan = id_langganan;
        this.jenisLangganan = jenisLangganan;
        this.potongan = potongan;
        this.harga = harga;
    }

    public String getJenisLangganan() {
        return jenisLangganan;
    }

    public void setJenisLangganan(String jenisLangganan) {
        this.jenisLangganan = jenisLangganan;
    }

    public double getPotongan() {
        return potongan;
    }

    public void setPotongan(double potongan) {
        this.potongan = potongan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}
