package build;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Login {
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
                            return user;
                        } else {
                            System.out.println("Login successfully. Welcome Shop: " + user.userName);
                            return user;
                        }
                    }
                }
        System.out.println("Wrong Account or Password. Please Enter Again!");
        return null;
    }
}
