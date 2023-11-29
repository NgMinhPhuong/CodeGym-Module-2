package Controller;

import service.UserService;
import service.VoucherService;
import Model.User;


public class UserController {
    private static UserController instance;

    private UserController() {

    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    //-----------------------------------------------------------





    public void findProduct(String productName){
        UserService.getInstance().findProduct(productName);
    }


    public void showMyVoucher(User user){
        VoucherService.getInstance().showMyVoucher(user);
    }
}