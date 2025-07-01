package MainClass;

/**
 *
 * @author Axioo Pongo
 */
public class Fasilitas {
    private String id_fasilitas;
    private String toilrt;
    private String jenis;
    private String area_parkir;
    private String wifi;
    private String perlengkapan;
    private String akses_listrik;
    private String pencahayaan;
    private String p3k;
    private String lainnya;
        
    public Fasilitas(String id_fasilitas, String toilrt, String jenis, String area_parkir, String wifi, String perlengkapan, String akses_listrik, String pencahayaan, String p3k, String lainnya) {
        this.id_fasilitas = id_fasilitas;
        this.toilrt = toilrt;
        this.jenis = jenis;
        this.area_parkir = area_parkir;
        this.wifi = wifi;
        this.perlengkapan = perlengkapan;
        this.akses_listrik = akses_listrik;
        this.pencahayaan = pencahayaan;
        this.p3k = p3k;
        this.lainnya = lainnya;
    }

    // Getter dan Setter
    public String getId_fasilitas() {
        return id_fasilitas;
    }

    public void setId_fasilitas(String id_fasilitas) {
        this.id_fasilitas = id_fasilitas;
    }

    public String getToilrt() {
        return toilrt;
    }

    public void setToilrt(String toilrt) {
        this.toilrt = toilrt;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getArea_parkir() {
        return area_parkir;
    }

    public void setArea_parkir(String area_parkir) {
        this.area_parkir = area_parkir;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getPerlengkapan() {
        return perlengkapan;
    }

    public void setPerlengkapan(String perlengkapan) {
        this.perlengkapan = perlengkapan;
    }

    public String getAkses_listrik() {
        return akses_listrik;
    }

    public void setAkses_listrik(String akses_listrik) {
        this.akses_listrik = akses_listrik;
    }

    public String getPencahayaan() {
        return pencahayaan;
    }

    public void setPencahayaan(String pencahayaan) {
        this.pencahayaan = pencahayaan;
    }

    public String getP3k() {
        return p3k;
    }

    public void setP3k(String p3k) {
        this.p3k = p3k;
    }

    public String getLainnya() {
        return lainnya;
    }

    public void setLainnya(String lainnya) {
        this.lainnya = lainnya;
    }
    
}
