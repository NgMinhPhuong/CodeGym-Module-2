package Controller;

import Model.RegisterAccount;
import Model.User;

public class RegisterAccountController {
    private static RegisterAccountController instance;
    private RegisterAccountController(){

    }
    public static  RegisterAccountController getInstance(){
        if(instance == null){
            instance = new RegisterAccountController();
        }
        return instance;
    }
    public  void resigter(String userName, String accountName, String password, String type){
        if(!type.equals("Shop") && !type.equals("Client")){
            System.out.println("Type must be Shop or Client");
            return;
        }
        if(accountName.length() > 15 || !accountName.matches(RegisterAccount.REGEX))
        {
            System.out.println("The string must contain letters and numbers and no more than 15 characters");
            return;
        }
        for(User user : RegisterAccount.accountShopList){
            if((user.getAccountName()).equals(accountName)){
                System.out.println("Account Name already exists");
                return;
            }
        }
        for(User user : RegisterAccount.accountClientList){
            if((user.getAccountName()).equals(accountName)){
                System.out.println("Account Name already exists");
                return;
            }
        }
        RegisterAccount.resigter(userName, accountName, password, type);
        System.out.println("Resigter successfully");
    }
}
