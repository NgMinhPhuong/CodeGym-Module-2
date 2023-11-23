package View;

import Controller.Register_LoginController;
import Controller.UserController;
import Model.Client;
import Model.Shop;
import Model.User;

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
        UserController.getInstance().addIntoBasket(id, user,accountName);
    }

    //------------------------------------------------
    public void displayRemoveFromBasket(User user){
        System.out.print("Id want to remove from Basket: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Remove from Shop with Account Name: ");
        String accountName = sc.nextLine();
        UserController.getInstance().removeFromBasket(id, user, accountName);
    }

    //-------------------------------------------------
    public void displaySetMethodAddMonney(User user){
        System.out.print("'Bank' or 'PhoneCard': ");
        String type = sc.nextLine();
        UserController.getInstance().setAddMoneyMethod(type, user);
    }

    //-------------------------------------------------
    public void displayAddMonney(User user){
        System.out.print("The monney to add: ");
        double monney = sc.nextDouble();
        sc.nextLine();
        UserController.getInstance().addMonneyToAccount(monney, user);
    }

    //-------------------------------------------------
    public void displaySetMethodPayment(User user){
        System.out.print("'Bank' or 'Account': ");
        String type = sc.nextLine();
        UserController.getInstance().setPaymentMethod(type, user);
    }

    //-------------------------------------------------
    public void displayBuyProduct(User user){
        System.out.print("Product's Id you want to buy: ");
        int id = sc.nextInt();
        System.out.print("Quanlity to Buy: ");
        int amount = sc.nextInt();
        sc.nextLine();
        System.out.print("Buy at the Shop has Id: ");
        String accountName = sc.nextLine();
        UserController.getInstance().pay(id, amount, accountName, user);
    }

    //-------------------------------------------------
    public void displayConnectAccount(User user){
        System.out.print("You want to connect to Account: ");
        String accountName = sc.nextLine();
        user.connectToAnUser(accountName);
    }

    //-------------------------------------------------
    public void displaySendMessage(User user){
        System.out.print("Send to Account: ");
        String accountName = sc.nextLine();
        System.out.print("Conten is: ");
        String content = sc.nextLine();
        user.sendMessageTo(accountName, content);
    }

    //-------------------------------------------------
    public void displayReadMail(User user){
        System.out.print("Read MailBox With Account: ");
        String accountName = sc.nextLine();
        user.readMail(accountName);
    }

    //--------------------------------------------------
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

    //--------------------------------------------------------------
    public User displayLogin(){
        System.out.print("Enter your accountName: ");
        String accountName = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        System.out.println("------------------------------------------------------------");
        return Register_LoginController.getInstance().login(accountName, password);
    }
}

