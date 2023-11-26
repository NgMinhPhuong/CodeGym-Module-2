package Controller;

import Model.Client;
import service.Register_LoginService;
import untils.DataFile;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;

import java.util.List;

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
        List<String[]> list = DataFile.getInstance().readBlockAccount();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i)[0].equals(accountName)){
                System.out.println("Your account is locked until " + list.get(i)[1]);
                return null;
            }
        }

        User user = Register_LoginService.getInstance().login(accountName, password);
        if(user instanceof Client) {
            System.out.println("Login successfully. Welcome My Client " + user.getUserName());
            return user;
        }
        if(user instanceof Shop) {
            System.out.println("Login successfully. Welcome My Shop " + user.getUserName());
            return user;
        }
        DataFile.getInstance().writeClient();
        DataFile.getInstance().writeShop();
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
            System.out.println("The Account Name must contain letters and numbers and no more than 15 characters");
            return;
        }

//        if(!password.matches("")){
//
//        }
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
            Register_LoginService.getInstance().resigter(new Shop(userName, accountName, password));
            DataFile.getInstance().writeShop();
        } else{
            Register_LoginService.getInstance().resigter(new Client(userName, accountName, password));
            DataFile.getInstance().writeClient();
        }
        System.out.println("Resigter successfully");
    }
}
