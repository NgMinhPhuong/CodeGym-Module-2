package build;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class RegisterAccount {
    static ObjectOutputStream oos;
    static ObjectInputStream ois;
    static List<User> accountList = new ArrayList<>();
    private final String REGEX = "([a-z]){5,13}(\\d){2,5}";
    public RegisterAccount(){

    }

    public static void writeData(){
        try{
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\AccountList.csv"));
            oos.writeObject(accountList);
            oos.close();
            System.out.println("Resigter successfully");
        } catch(Exception e){
            System.out.println("Error Write File AccountList.txt");
        }
    }
    public static void writeData1(){
        try{
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\AccountList.csv"));
            oos.writeObject(accountList);
            oos.close();
        } catch(Exception e){
            System.out.println("Error Write File AccountList.txt");
        }
    }

    public static void readData(){
        File file = new File("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\AccountList.csv");
        if(file.length() != 0) {
            try {
                ois = new ObjectInputStream(new FileInputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\AccountList.csv"));
                accountList = (List<User>) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error Read accountList.csv");
            }
        }
    }
    public void resigter(String userName, String accountName, String password, String type) {
        if(!type.equals("Shop") && !type.equals("Shop")){
            System.out.println("Type must be Shop or Client");
            return;
        }

        if(accountName.length() > 15 || !accountName.matches(REGEX))
        {
            System.out.println("The string must contain letters and numbers and no more than 15 characters");
            return;
        }
        readData();
        User newUser;
        if(type.equals("Shop")){
            newUser = new Shop(userName, accountName, password);
        } else {
            newUser = new Client(userName, accountName, password);
        }
        for(User user : this.accountList){
            if((user.accountName).equals(newUser.accountName)){
                System.out.println("Account Name already exists");
                return;
            }
        }
        accountList.add(newUser);
        writeData();
    }



    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\ProductData.csv", "rw")) {
            file.setLength(0); // Đặt độ dài file là 0
            //System.out.println("Đã xóa hết nội dung trong file nhị phân.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (RandomAccessFile file = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\AccountList.csv", "rw")) {
            file.setLength(0); // Đặt độ dài file là 0
            //System.out.println("Đã xóa hết nội dung trong file nhị phân.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
