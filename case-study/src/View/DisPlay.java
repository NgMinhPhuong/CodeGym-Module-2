package View;

import Controller.AddMonneyController;
import Controller.BasketController;
import Controller.CommunicateController;
import Controller.PaymentController;
import Controller.VoteProductController;
import Controller.Register_LoginController;
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
        System.out.print("Id want to Add Basket: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Product of Shop with AccountName: ");
        String accountName = sc.nextLine();
        BasketController.getInstance().addIntoBasket(id, user,accountName);
    }

    public void displayRemoveFromBasket(User user){
        System.out.print("Id want to remove from Basket: ");
        int id = sc.nextInt();
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
        System.out.print("The monney want to add: ");
        double monney = sc.nextDouble();
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
        System.out.print("Product's Id you want to buy: ");
        int id = sc.nextInt();
        System.out.print("Quanlity to Buy: ");
        int amount = sc.nextInt();
        sc.nextLine();
        System.out.print("Buy at the Shop has Id: ");
        String accountName = sc.nextLine();
        System.out.println("Enter ID voucher that you want to use: ");
        System.out.println("If you enter it wrongly or let it Empty. Default is not Use the Voucher");
        int idVoucher = sc.nextInt();
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
        System.out.print("Product's Price: ");
        double price = sc.nextDouble();
        System.out.print("The Number of Products: ");
        int amount = sc.nextInt();
        sc.nextLine();
        System.out.print("Product's Description: ");
        String description = sc.nextLine();
        ShopController.getInstance().addProductIntoStore(name, price, amount, description, shop);
    }

    public void displayRemoveProduct(Shop shop){
        System.out.print("Product's Id want to Remove: ");
        int id = sc.nextInt();
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
        Register_LoginController.getInstance().resigter(userName, accountName, password, type);
        System.out.println("------------------------------------------------------------");
    }

    public User displayLogin(){
        System.out.print("Enter your accountName: ");
        String accountName = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        User user = Register_LoginController.getInstance().login(accountName, password);
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
        System.out.print("Product's ID that you want to vote: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("At Shop with AccountName: ");
        String accountName = sc.nextLine();
        System.out.print("The Numbers of star: ");
        int star = sc.nextInt();
        sc.nextLine();
        System.out.print("Comment: ");
        String comment = sc.nextLine();
        VoteProductController.getInstance().voteProduct(accountName, id, star, comment, user);
    }

    public void displayShowVoteProduct(){
        System.out.print("Enter product's Id that you want to see: ");
        int id = sc.nextInt();
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
        UserController.getInstance().updateInformation(email, phoneNumber, user);
    }

    public void displayChangePassword(User user){
        System.out.print("Old Password: ");
        String oldPassword = sc.nextLine();
        System.out.print("New password: ");
        String newPassword = sc.nextLine();
        System.out.print("Enter New Password again: ");
        String againNewPassword = sc.nextLine();
        UserController.getInstance().changePassword(oldPassword, newPassword, againNewPassword, user);
    }

    public void displayShowMyVoucher(User user){
        UserController.getInstance().showMyVoucher(user);
    }
    public void flowText(String name){
        String redColor = "\u001B[31m";
        String greenColor = "\u001B[32m";
        String defaultColor = "\u001B[0m";
        String yellowColor = "\\u001B[43m";
        String blank = " ";
        int cnt = 0;
        while(true){
            String s = " ";
            for(int i = 0; i < 143 - name.length(); i++){
                s += " ";
            }
            s += name;
            System.out.println(yellowColor + s);
            cnt++;
        }
    }
}

