
package GUI;

import ClassDAO.*;
import MainClass.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Pengguna p1;
        
        DAOPengguna pd1 = new DAOPengguna();
        
        p1 = pd1.LoadSome("aya");
        //p1 = pd1.LoadSome("aya");
        //JOptionPane.showMessageDialog(null, "Pengguna tidak ditemukan.", "Information",JOptionPane.INFORMATION_MESSAGE);
        //pd1.DeletePengguna("p0002");
//        for(Pengguna elem : p1) {
//            System.out.println(elem.getUserName());
//        }
        //System.out.println(p1.getEmail());
        
        
    }
    
}
