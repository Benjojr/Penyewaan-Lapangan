
package MainClass;

public class Booking {
    private String id_booking;
    private String id_Pengguna;

    public Booking(String id_booking, String id_Pengguna) {
        this.id_booking = id_booking;
        this.id_Pengguna = id_Pengguna;
    }

    public String getId_booking() {
        return id_booking;
    }

    public void setId_booking(String id_booking) {
        this.id_booking = id_booking;
    }

    public String getId_Pengguna() {
        return id_Pengguna;
    }

    public void setId_Pengguna(String id_Pengguna) {
        this.id_Pengguna = id_Pengguna;
    }
}
