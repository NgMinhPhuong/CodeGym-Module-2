package build;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Login {
    ObjectInputStream ois;
    List<User> accountList = new ArrayList<>();
    public Login(){

    }



    public User login(String accountName, String password){
                RegisterAccount.readData();
                accountList = RegisterAccount.accountList;
                for(User user : this.accountList) {
                    if ((user.accountName).equals(accountName) && (user.password).equals(password)) {
                        if (user instanceof Client) {
                            System.out.println("Login successfully. Welcome My Client " + user.userName);
                            System.out.println("--------------------");
                            return user;
                        } else {
                            System.out.println("Login successfully. Welcome Admin: " + user.userName);
                            System.out.println("--------------------");
                            return user;
                        }
                    }
                }
        System.out.println("Wrong Account or Password. Please Enter Again!");
        System.out.println("--------------------");
        return null;
    }
}
