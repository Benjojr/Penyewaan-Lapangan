
package DebugFiles;

import ClassDAO.DAOUlasan;
import MainClass.Rating;


public class Main {
    public static void main(String[] args) {
        DAOUlasan daoUlasan = new DAOUlasan();
        daoUlasan.addUlasan(daoUlasan.generateID(), "GACORRR BANGEETT ANJAAY", Rating.FIVE, "p0001", "l0002");
    }
}
