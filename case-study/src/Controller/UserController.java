package Controller;

import Model.AddByBank;
import Model.AddByPhoneCard;
import Model.Voucher;
import final_REGEX.Const;
import service.BasketService;
import service.ShopService;
import service.UserService;
import untils.DataFile;
import Model.PayByAccount;
import Model.PayByCard;
import Model.Product;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;

import java.util.List;
import java.util.Map;
import java.util.Scanner;


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



    //---------------------------------------------------------------------------


    //----------------------------------------


    //-----------------------------------------------------------


    //-------------------------------------------------------------

    //------------------------------------------------------------------



    public void updateInformation(String email, String phoneNumber, User user){
        Scanner sc = new Scanner(System.in);

        while(email.matches(Const.getInstance().REGEX_EMAIL)){
            System.out.print("Email: ");
            email = sc.nextLine();
        }

        while (phoneNumber.matches(Const.getInstance().REGEX_PHONE_NUMBER)){
            System.out.print("Phone Number: ");
            phoneNumber = sc.nextLine();
        }
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        System.out.println("Update Successfully");
        DataFile.getInstance().writeShop();
        DataFile.getInstance().writeClient();
    }

    public void findProduct(String productName){
        UserService.getInstance().findProduct(productName);
    }
    public void changePassword(String oldPassword, String newPassword, String againNewPassword, User user){
        if(!oldPassword.equals(user.getPassword())){
            System.out.println("Old Password is not correct");
            return;
        }
        if(newPassword.isEmpty()){
            System.out.println("New Password cannot be blank");
            return;
        }
        if(!newPassword.equals(againNewPassword)){
            System.out.println("Re-enter the wrong password");
            return;
        }
        user.setPassword(newPassword);
        System.out.println("Changed Password Successfully");
        DataFile.getInstance().writeClient();
        DataFile.getInstance().writeShop();
    }

    public void showMyVoucher(User user){
        UserService.getInstance().showMyVoucher(user);
    }
}