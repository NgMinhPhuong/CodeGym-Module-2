import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class RegisterAccount {
    String account;
    String password;
    String accountName;
    ObjectOutputStream oos;
    public RegisterAccount(){

    }
    public RegisterAccount(String account, String password, String accountName) {
        this.account = account;
        this.password = password;
        this.accountName = accountName;
        try{
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\AccountList.csv"));
            oos.writeObject(this);
            oos.close();
        } catch(Exception e){
            System.out.println("Error Read File AccountList.txt");
        }
    }
}
