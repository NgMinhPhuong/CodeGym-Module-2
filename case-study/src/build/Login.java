package build;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Login {
    ObjectInputStream ois;
    public Login(){

    }
    public User login(String accountName, String password){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\AccountList.csv"));)
        {
           User user = null;
            while((user = (User) ois.readObject()) != null) {
                if(user.accountName.equals(accountName) && user.password.equals(password)){
                    if (user instanceof Client) {
                        System.out.println("Login successfully. Welcome My Client " + user.userName);
                        System.out.println("--------------------");
                        ois.close();
                        return user;
                    } else{
                        System.out.println("Login successfully. Welcome Admin: " + user.userName);
                        System.out.println("--------------------");
                        ois.close();
                        return user;
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Wrong Account or Password. Please Enter Again!");
        System.out.println("--------------------");
        return null;
    }
}
