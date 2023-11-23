package untils;

import Model.RegisterAccount;
import Model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DataFile {
    static File file;
    static ObjectOutputStream oos;
    static ObjectInputStream ois;

    public static void writeClient() {
        try {
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Client.csv"));
            oos.writeObject(RegisterAccount.getAccountClientList());
            oos.close();
        } catch (Exception e) {
            System.out.println("Error Write File Client.csv");
        }
    }

    //---------------------------------------------------------------

    public static void writeShop() {
        try {
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Shop.csv"));
            oos.writeObject(RegisterAccount.getAccountShopList());
            oos.close();
        } catch (Exception e) {
            System.out.println("Error Write File Shop.csv");
        }

    }

    //---------------------------------------------------------------
    public static void readClient() {
        file = new File("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Client.csv");
        if (file.length() != 0) {
            try {
                ois = new ObjectInputStream(new FileInputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Client.csv"));
                RegisterAccount.setAccountClientList((List<User>) ois.readObject());
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error Read Client.csv");
            }
        }
    }

    //------------------------------------------------------------

    public static void readShop() {
        file = new File("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Shop.csv");
        if (file.length() != 0) {
            try {
                ois = new ObjectInputStream(new FileInputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Shop.csv"));
                RegisterAccount.setAccountShopList((List<User>) ois.readObject());
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error Read Shop.csv");
            }
        }
    }


}
