package View;

import Controller.AddMonneyController;
import Controller.BasketController;
import Controller.CommunicateController;
import Controller.ForgotPWController;
import Controller.LoginController;
import Controller.PaymentController;
import Controller.PerSonalInformationController;
import Controller.VoteProductController;
import Controller.RegisterController;
import Controller.ShopController;
import Controller.UserController;
import Model.Shop;
import Model.User;
import service.BasketService;
import service.ShopService;
import service.UserService;

import java.util.Scanner;

public class DisPlay {
    Scanner sc = new Scanner(System.in);
    private static DisPlay instance;

    private DisPlay() {

    }

    public static DisPlay getInstance() {
        if (instance == null) {
            instance = new DisPlay();
        }
        return instance;
    }

    //---------------------------------------------------


    public void displayAddToBasket(User user){
        int id;
        while(true) {
            try {
                System.out.print("Id want to Add Basket: ");
                id = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("Product of Shop with AccountName: ");
        String accountName = sc.nextLine();
        BasketController.getInstance().addIntoBasket(id, user,accountName);
    }

    public void displayRemoveFromBasket(User user){
        int id;
        while(true) {
            try {
                System.out.print("Id want to remove from Basket: ");
                id = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("Remove from Shop with Account Name: ");
        String accountName = sc.nextLine();
        BasketController.getInstance().removeFromBasket(id, user, accountName);
    }

    public void displayShowBasket(User user) {
        BasketService.getInstance().showBasket(user);
    }

    //-------------------------------------------------
    public void displaySetAddMonneyMethod(User user){
        System.out.print("'Bank(100%)' or 'PhoneCard(80%)': ");
        String type = sc.nextLine();
        AddMonneyController.getInstance().setAddMoneyMethod(type, user);
    }

    public void displayAddMonney(User user){
        double monney;
        while(true) {
            try {
                System.out.print("The monney want to add: ");
                monney = sc.nextDouble();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        sc.nextLine();
        AddMonneyController.getInstance().addMonneyToAccount(monney, user);
    }

    //-------------------------------------------------
    public void displaySetPaymentMethod(User user){
        System.out.print("'Bank' or 'Account': ");
        String type = sc.nextLine();
        PaymentController.getInstance().setPaymentMethod(type, user);
    }

    public void displayBuyProduct(User user){
        int id, amount, idVoucher;
        while(true) {
            try {
                System.out.print("Product's Id you want to buy: ");
                id = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }

        while(true) {
            try {
                System.out.print("Quanlity to Buy: ");
                amount = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("Buy at the Shop has Id: ");
        String accountName = sc.nextLine();
        while(true) {
            try {
                System.out.println("Enter ID voucher that you want to use: ");
                System.out.println("If you enter it wrongly or It is not exists. Default is not Use the Voucher");
                idVoucher = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        sc.nextLine();
        PaymentController.getInstance().pay(id, amount, accountName, user, idVoucher);
    }

    //-------------------------------------------------
    public void displayConnectAccount(User user){
        System.out.print("You want to connect to Account: ");
        String accountName = sc.nextLine();
        CommunicateController.getInstance().connectToAnUser(user, accountName);
    }


    public void displaySendMessage(User user){
        System.out.print("Send to Account: ");
        String accountName = sc.nextLine();
        System.out.print("Conten is: ");
        String content = sc.nextLine();
        CommunicateController.getInstance().sendMessageTo(user, accountName, content);
    }


    public void displayReadMail(User user){
        System.out.print("Read MailBox With Account: ");
        String accountName = sc.nextLine();
        CommunicateController.getInstance().readMail(user, accountName);
    }

    //--------------------------------------------------

    public void displayAddProduct(Shop shop){
        System.out.print("Product's Name: ");
        String name = sc.nextLine();
        double price;
        int amount;
        while(true) {
            try {
                System.out.print("Product's Price: ");
                price = sc.nextDouble();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }

        while(true) {
            try {
                System.out.print("The Number of Products: ");
                amount = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("Product's Description: ");
        String description = sc.nextLine();
        ShopController.getInstance().addProductIntoStore(name, price, amount, description, shop);
    }

    public void displayRemoveProduct(Shop shop){
        int id;
        while(true) {
            try {
                System.out.print("Product's Id want to Remove: ");
                id = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        sc.nextLine();
        ShopController.getInstance().removeProductFromStore(id, shop);
    }

    public void displayShowMyProduct(Shop shop){
        ShopService.getInstance().showProductList(shop);
    }
    //----------------------------------------------------
    public void displayRegister(){
        System.out.print("Create accountName is: ");
        String accountName = sc.nextLine();
        System.out.print("Create password is: ");
        String password = sc.nextLine();
        System.out.print("User Name is: ");
        String userName = sc.nextLine();
        System.out.print("Type('Shop' or 'Client'): ");
        String type = sc.nextLine();
        RegisterController.getInstance().resigter(userName, accountName, password, type);
        System.out.println("------------------------------------------------------------");
    }

    public User displayLogin(){
        System.out.print("Enter your accountName: ");
        String accountName = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        User user = LoginController.getInstance().login(accountName, password);
        System.out.println("------------------------------------------------------------");
        return user;
    }

    //------------------------------------------------------------------

    //-------------------------------------------------------------------
    public void checkMonneyInAccount(User user){
        System.out.print("Your Account has: ");
        System.out.println(user.getAccount());
    }


    public void checkMonneyInBankCard(User user){
        System.out.print("Your Bank Card has: ");
        System.out.println(user.getBankCard());
    }

    //---------------------------------------------------------

    public void displayVoteProduct(User user){
        int id;
        while(true) {
            try {
                System.out.print("Product's ID that you want to vote: ");
                id = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("At Shop with AccountName: ");
        String accountName = sc.nextLine();
        int star;
        while(true) {
            try {
                System.out.print("The Numbers of star: ");
                star = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("Comment: ");
        String comment = sc.nextLine();
        VoteProductController.getInstance().voteProduct(accountName, id, star, comment, user);
    }

    public void displayShowVoteProduct(){
        int id;
        while(true) {
            try {
                System.out.print("Enter product's Id that you want to see: ");
                id = sc.nextInt();
                break;
            } catch (Exception e) {
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("At Shop with AccountName: ");
        String accountName = sc.nextLine();
        VoteProductController.getInstance().showVoteProduct(accountName, id);
    }

    public void displayRevenue(Shop shop){
        System.out.print("Your Shop's Revenue is: ");
        System.out.println(shop.getRevenue());
    }

    public void displayTransactionHistory(User user){
        UserService.getInstance().showTransactionHistory(user);
    }

    public void displayFindProduct(){
        System.out.print("The name of Product: ");
        String productName = sc.nextLine();
        UserController.getInstance().findProduct(productName);
    }

    public void displayUpdateInformation(User user){
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = sc.nextLine();
        PerSonalInformationController.getInstance().updateInformation(email, phoneNumber, user);
    }

    public void displayChangePassword(User user){
        System.out.print("Old Password: ");
        String oldPassword = sc.nextLine();
        System.out.print("New password: ");
        String newPassword = sc.nextLine();
        System.out.print("Enter New Password again: ");
        String againNewPassword = sc.nextLine();
        PerSonalInformationController.getInstance().changePassword(oldPassword, newPassword, againNewPassword, user);
    }

    public void displayShowMyVoucher(User user){
        UserController.getInstance().showMyVoucher(user);
    }

    public void displayForgotPassWord(){
        System.out.print("Enter your Account Name: ");
        String accountName = sc.nextLine();
        System.out.print("Enter your Email: ");
        String email = sc.nextLine();
        System.out.print("Enter New PassWord: ");
        String newPW = sc.nextLine();
        ForgotPWController.getInstance().createNewPW(accountName, newPW, email);
    }
}

