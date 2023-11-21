package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class RegisterAccount {
    static ObjectOutputStream oos;
    static ObjectInputStream ois;
    public static List<User> accountClientList = new ArrayList<>();
    public static List<User> accountShopList = new ArrayList<>();
    public static final String REGEX = "([a-z]){5,13}(\\d){2,5}";
    public RegisterAccount(){

    }


    public static void resigter(String userName, String accountName, String password, User user) {
        User newUser = user;
        if(newUser instanceof Shop) {
            accountShopList.add(newUser);
            DataFile.writeShop();
        }
        else{
            accountClientList.add(newUser);
            DataFile.writeClient();
        }
    }



    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Client.csv", "rw")) {
            file.setLength(0); // Đặt độ dài file là 0
            //System.out.println("Đã xóa hết nội dung trong file nhị phân.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (RandomAccessFile file = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Shop.csv", "rw")) {
            file.setLength(0); // Đặt độ dài file là 0
            //System.out.println("Đã xóa hết nội dung trong file nhị phân.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
