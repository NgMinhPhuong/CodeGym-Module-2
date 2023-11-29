package service;

import Model.RegisterAccount;
import Model.Shop;
import Model.User;

public class RegisterService {
    private static RegisterService instance;
    private RegisterService(){

    }

    public static RegisterService getInstance() {
        if(instance == null){
            instance = new RegisterService();
        }
        return instance;
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
