package Controller;

import Model.User;
import service.UserService;
import untils.DataAccount;

public class ForgotPWController {
    private static ForgotPWController instance;
    private ForgotPWController(){

    }

    public static ForgotPWController getInstance() {
        if(instance == null){
            instance = new ForgotPWController();
        }
        return instance;
    }

    public void createNewPW(String accountName, String newPW, String email){
        User user = UserService.getInstance().checkUserExists(accountName);
        if(user == null){
            System.out.println("Account Name is not exists");
            return;
        }
        if(user.getEmail() == null){
            System.out.println("Email is wrong");
            return;
        }
        if(!user.getEmail().equals(email)){
            System.out.println("Email is wrong");
            return;
        }
        user.setPassword(newPW);
        System.out.println("Change PassWord Successfully");
        DataAccount.getInstance().writeClient();
        DataAccount.getInstance().writeShop();
    }
}
