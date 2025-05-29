
package GUI;

import ClassDAO.*;
import MainClass.*;

public class Main {
    public static void main(String[] args) {
        Pengguna p1;
        
        DAOPengguna pd1 = new DAOPengguna();
        
        p1 = pd1.Load("p0001");
        
        System.out.println(p1.getId());
    }
}
