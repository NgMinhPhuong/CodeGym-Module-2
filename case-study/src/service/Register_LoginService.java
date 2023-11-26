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
            if ((user.getAccountName()).equals(accountName) && !(user.getPassword()).equals(password)) {
                int cnt = user.getCntBlock() + 1;
                user.setCntBlock(cnt);
                if(cnt == 3){
                    user.setCntBlock(0);
                    DataFile.getInstance().writeBlockAccount(accountName);
                    System.out.println("You entered it wrongly 3 time. Your account has been locked");
                    return null;
                }
                System.out.println("You entered it wrongly " + cnt + " time");
                return null;
            }
            if ((user.getAccountName()).equals(accountName) && (user.getPassword()).equals(password)) {
                return user;
            }
        }
        for (User user : RegisterAccount.getAccountShopList()) {
            if ((user.getAccountName()).equals(accountName) && !(user.getPassword()).equals(password)) {
                int cnt = user.getCntBlock() + 1;
                user.setCntBlock(cnt);
                if(cnt == 3){
                    user.setCntBlock(0);
                    try{
                    DataFile.getInstance().writeBlockAccount(accountName);
                    } catch (Exception e){
                        System.out.println("Please Close File. You are opening it");
                    }
                    System.out.println("Enter Wrongly Password");
                    System.out.println("You entered it wrongly 3 time. Your account has been locked");
                    return null;
                }
                System.out.println("Enter Wrongly Password");
                System.out.println("You entered it wrongly " + cnt + " time");
                return null;
            }
            if ((user.getAccountName()).equals(accountName) && (user.getPassword()).equals(password)) {
                return user;
            }
        }
        System.out.println("Account Name is not exists");
        return null;
    }

    //-------------------------------------------------------------------------

    public void resigter(User user) {
        User newUser = user;
        if(newUser instanceof Shop) {
            RegisterAccount.getAccountShopList().add(newUser);
        }
        else{
            RegisterAccount.getAccountClientList().add(newUser);
        }
    }
}
