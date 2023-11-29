package Controller;

import Model.Client;
import final_REGEX.Const;
import service.RegisterService;
import untils.DataAccount;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;
import untils.DataProduct;

public class RegisterController {
    private static RegisterController instance;
    private RegisterController(){

    }
    public static RegisterController getInstance(){
        if(instance == null){
            instance = new RegisterController();
        }
        return instance;
    }


    //------------------------------------------------------------------------------

    public  void resigter(String userName, String accountName, String password, String type){
        if(!type.equals("Shop") && !type.equals("Client")){
            System.out.println("Type must be 'Shop' or 'Client'");
            return;
        }
        if(accountName.length() > 15 || !accountName.matches(Const.getInstance().REGEX_ACCOUNT_NAME))
        {
            System.out.println("The Account Name must contain letters and numbers and no more than 15 characters");
            return;
        }

        if(!password.matches(Const.getInstance().REGEX_PASSWORD)){
            System.out.println("Password can not be blank");
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
            RegisterService.getInstance().resigter(new Shop(userName, accountName, password));
            DataAccount.getInstance().writeShop();
            DataProduct.getInstance().writeProduct();
        } else{
            RegisterService.getInstance().resigter(new Client(userName, accountName, password));
            DataAccount.getInstance().writeClient();
        }
        System.out.println("Resigter successfully");
    }
}
