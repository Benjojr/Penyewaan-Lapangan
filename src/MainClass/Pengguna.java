package MainClass;


public class Pengguna {
    private String id;
    private String no_telp;
    private String UserName;
    private String email;
    private String Jenis_Langganan;
    private String password;
    
    public Pengguna(String id, String no_telp,String email, String UserName, String Jenis_Langganan, String password) {
    this.id = id;
    this.no_telp = no_telp;
    this.UserName = UserName;
    this.email = email;
    this.Jenis_Langganan = Jenis_Langganan;
    this.password = password;
}
    
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

    public String getJenis_Langganan() {
        return Jenis_Langganan;
    }

    public void setJenis_Langganan(String Jenis_Langganan) {
        this.Jenis_Langganan = Jenis_Langganan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
