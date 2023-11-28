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
    public void setPaymentMethod(String type, User user){
        if (type.equals("Bank")) {
            user.setPaymentMethod(new PayByCard());
            System.out.println("Selected !");
            DataFile.getInstance().writeShop();
            DataFile.getInstance().writeClient();
            return;
        } else if (type.equals("Account")) {
            user.setPaymentMethod(new PayByAccount());
            System.out.println("Selected !");
            DataFile.getInstance().writeShop();
            DataFile.getInstance().writeClient();
            return;
        }
        System.out.println("Type is Wrong. Type must be ('Bank' or 'Account')");
    }

    //-----------------------------------------------------------
    public void pay(int id, int amount, String accountName, User userBuy, int idVoucher) {
        if (userBuy.getPaymentMethod() == null) {
            System.out.println("Chose a PaymentMethod please");
            return;
        }
        Product product = null;
        for (User user : RegisterAccount.getAccountShopList()) {
            for (Product x : ((Shop) user).getMyProductList()) {
                if (x.getId() == id) {
                    product = x;
                    break;
                }
            }
        }
        if (product == null) {
            System.out.println("Id is not Exists");
            return;
        }

        User userSell = null;
        for (User x : RegisterAccount.getAccountShopList()) {
            if (x.getAccountName().equals(accountName)) {
                userSell = x;
                break;
            }
        }
        if (userSell == null) {
            System.out.println("This store is not available");
            return;
        }

        if (amount > product.getAmount()) {
            System.out.println("We only have " + product.getAmount() + " of them");
            return;
        }

        UserService.getInstance().pay(product, amount, userBuy, userSell, idVoucher);
        DataFile.getInstance().writeClient();
        DataFile.getInstance().writeShop();
    }

    //-------------------------------------------------------------
    public void setAddMoneyMethod(String type, User user){
        if (type.equals("Bank")) {
            user.setAddMoneyMethod(new AddByBank());
            System.out.println("Selected !");
            DataFile.getInstance().writeShop();
            DataFile.getInstance().writeClient();
            return;
        } else if (type.equals("PhoneCard")) {
            user.setAddMoneyMethod(new AddByPhoneCard());
            System.out.println("Selected !");
            DataFile.getInstance().writeShop();
            DataFile.getInstance().writeClient();
            return;
        }
        System.out.println("Type is Wrong. Type must be ('Bank' or 'PhoneCard')");
    }

    public void addMonneyToAccount(double monney, User user){
        if(user.getAddMoneyMethod() == null){
            System.out.println("Please Choose a Method to Add Monney");
            return;
        }
        if(user.getAddMoneyMethod() instanceof AddByBank) {
            if (monney > user.getBankCard()) {
                System.out.println("Your BankAccount is not enough monney");
                return;
            }
        }
            UserService.getInstance().addMonneyToAccount(user, monney);
            System.out.println("Add successfully");
            DataFile.getInstance().writeShop();
            DataFile.getInstance().writeClient();
    }
    //------------------------------------------------------------------

    public void voteProduct(String accountName, int id, int star, String comment, User userComment){
        User user = UserService.getInstance().checkUserExists(accountName);
        if(user == null){
            System.out.println("This store is not available");
            return;
        }

        Product product = ShopService.getInstance().checkIdExists(id);
        if (product == null){
            System.out.println("This store has no this ID");
            return;
        }
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\vote_product\\"
                + accountName + "_" + id + ".csv";
        DataFile.getInstance().writeVote(path, star, comment, userComment);
        System.out.println("Comment Successfully");
    }
    public void showVoteProduct(String accountName, int id){
        User user = UserService.getInstance().checkShopExists(accountName);
        if(user == null){
            System.out.println("This store is not available");
            return;
        }

        Product product = ShopService.getInstance().checkIdExists(id);
        if (product == null){
            System.out.println("This store has no this ID");
            return;
        }
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\vote_product\\"
                + accountName + "_" + id + ".csv";
        List<String> listComment;
        listComment = DataFile.getInstance().readVote(path);
        if(listComment == null) {
            System.out.println("There are no comments for this product yet");
            return;
        }
        String [] ss;
        for(int i = listComment.size() - 1; i >= 0; i--){
            ss = listComment.get(i).split(",");
            System.out.println(ss[0] + ": " + ss[1] + " SAO -> " + ss[2]);
        }
    }

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