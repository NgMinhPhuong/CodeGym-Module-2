package Model;

import untils.DataFile;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class RegisterAccount {
    private static List<User> accountClientList = new ArrayList<>();
    private static List<User> accountShopList = new ArrayList<>();
    public static final String REGEX = "([a-z]){5,13}(\\d){2,5}";
    public RegisterAccount(){

    }
    //-------------------------------------------
    public static List<User> getAccountClientList() {
        return accountClientList;
    }

    public static List<User> getAccountShopList() {
        return accountShopList;
    }

    //------------------------------------------------
    public static void setAccountClientList(List<User> accountClientList) {
        RegisterAccount.accountClientList = accountClientList;
    }

    public static void setAccountShopList(List<User> accountShopList) {
        RegisterAccount.accountShopList = accountShopList;
    }

    //--------------------------------------------------------------------





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
