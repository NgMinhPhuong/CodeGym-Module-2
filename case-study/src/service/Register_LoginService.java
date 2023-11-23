package service;

import Model.Client;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;
import untils.DataFile;

public class Register_LoginService {
    private static Register_LoginService instance;
    private Register_LoginService(){

    }

    public static Register_LoginService getInstance() {
        if(instance == null){
            instance = new Register_LoginService();
        }
        return instance;
    }

    public User login(String accountName, String password){
        for (User user : RegisterAccount.getAccountClientList()) {
            if ((user.getAccountName()).equals(accountName) && (user.getPassword()).equals(password)) {
                return user;
            }
        }
        for (User user : RegisterAccount.getAccountShopList()) {
            if ((user.getAccountName()).equals(accountName) && (user.getPassword()).equals(password)) {
                return user;
            }
        }
        return null;
    }

    //-------------------------------------------------------------------------

    public static void resigter(User user) {
        User newUser = user;
        if(newUser instanceof Shop) {
            RegisterAccount.getAccountShopList().add(newUser);
        }
        else{
            RegisterAccount.getAccountClientList().add(newUser);
        }
    }
}
