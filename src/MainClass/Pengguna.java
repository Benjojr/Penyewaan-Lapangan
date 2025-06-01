package MainClass;


public class Pengguna {
    private String id;
    private String no_telp;
    private String UserName;
    private String email;
    private String Jenis_langganan;
    private String password;
    
    public Pengguna(String id, String no_telp,String email, String UserName, String Jenis_langganan, String password) {
    this.id = id;
    this.no_telp = no_telp;
    this.UserName = UserName;
    this.email = email;
    this.Jenis_langganan = Jenis_langganan;
    this.password = password;
    }

    public Pengguna(){}
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJenis_langganan() {
        return Jenis_langganan;
    }

    public void setJenis_langganan(String Jenis_langganan) {
        this.Jenis_langganan = Jenis_langganan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
