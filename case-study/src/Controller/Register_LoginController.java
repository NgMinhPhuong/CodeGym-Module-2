package Controller;

import Model.Client;
import service.Register_LoginService;
import untils.DataFile;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;

public class Register_LoginController {
    private static Register_LoginController instance;
    private Register_LoginController(){

    }
    public static Register_LoginController getInstance(){
        if(instance == null){
            instance = new Register_LoginController();
        }
        return instance;
    }

    //--------------------------------------------------------------

    public User login(String accountName, String password) {
        User user = Register_LoginService.getInstance().login(accountName, password);
        if(user instanceof Client) {
                System.out.println("Login successfully. Welcome My Client " + user.getUserName());
                return user;
        }
        if(user instanceof Shop) {
                System.out.println("Login successfully. Welcome My Shop " + user.getUserName());
                return user;
        }
        System.out.println("Wrong Account or Password. Please Enter Again!");
        return null;
    }

    //------------------------------------------------------------------------------

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
        for(User user : RegisterAccount.getAccountShopList()){
            if((user.getAccountName()).equals(accountName)){
                System.out.println("Account Name already exists");
                return;
            }
        }

        for(User user : RegisterAccount.getAccountClientList()){
            if((user.getAccountName()).equals(accountName)){
                System.out.println("Account Name already exists");
                return;
            }
        }

        if(type.equals("Shop")){
            Register_LoginService.resigter(new Shop(userName, accountName, password));
            DataFile.writeShop();
        } else{
            Register_LoginService.resigter(new Client(userName, accountName, password));
            DataFile.writeClient();
        }
        System.out.println("Resigter successfully");
    }
}
