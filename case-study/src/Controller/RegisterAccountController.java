package Controller;

import Model.Client;
import Model.DataFile;
import Model.RegisterAccount;
import Model.Shop;
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
            System.out.println("Type must be 'Shop' or 'Client'");
            return;
        }
        if(accountName.length() > 15 || !accountName.matches(RegisterAccount.REGEX))
        {
            System.out.println("The string must contain letters and numbers and no more than 15 characters");
            return;
        }
        DataFile.readShop();
        for(User user : RegisterAccount.accountShopList){
            if((user.getAccountName()).equals(accountName)){
                System.out.println("Account Name already exists");
                return;
            }
        }
        DataFile.readClient();
        for(User user : RegisterAccount.accountClientList){
            if((user.getAccountName()).equals(accountName)){
                System.out.println("Account Name already exists");
                return;
            }
        }

        if(type.equals("Shop")){
            RegisterAccount.resigter(userName, accountName, password, new Shop(userName, accountName, password));
        } else{
            RegisterAccount.resigter(userName, accountName, password, new Client(userName, accountName, password));
        }
        System.out.println("Resigter successfully");
    }
}
