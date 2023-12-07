package Controller;

import Model.User;
import final_REGEX.Const;
import untils.DataAccount;
import untils.DataProduct;

import java.util.Scanner;

public class PerSonalInformationController {
    private static PerSonalInformationController instance;
    private PerSonalInformationController(){

    }

    public static PerSonalInformationController getInstance() {
        if(instance == null){
            instance = new PerSonalInformationController();
        }
        return instance;
    }

    public void updateInformation(String email, String phoneNumber, User user){
        Scanner sc = new Scanner(System.in);

        while(!email.matches(Const.getInstance().REGEX_EMAIL)){
            System.out.print("Email: ");
            email = sc.nextLine();
        }

        while (!phoneNumber.matches(Const.getInstance().REGEX_PHONE_NUMBER)){
            System.out.print("Phone Number: ");
            phoneNumber = sc.nextLine();
        }
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        System.out.println("Update Successfully");
        DataAccount.getInstance().writeShop();
        DataAccount.getInstance().writeClient();
        DataProduct.getInstance().writeProduct();
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
        DataAccount.getInstance().writeClient();
        DataAccount.getInstance().writeShop();
        DataProduct.getInstance().writeProduct();
    }
}
