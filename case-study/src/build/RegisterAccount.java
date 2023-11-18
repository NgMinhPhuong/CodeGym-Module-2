package build;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class RegisterAccount {
    String account;
    String password;
    String accountName;
    ObjectOutputStream oos;
    public RegisterAccount(){

    }

    void resigter(String userName, String accountName, String password) {
        try{
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\AccountList.csv", true));
            oos.writeObject(new Client(userName, accountName, password));
            oos.close();
        } catch(Exception e){
            System.out.println("Error Write File AccountList.txt");
        }
    }
}
