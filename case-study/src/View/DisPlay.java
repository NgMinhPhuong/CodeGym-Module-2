package View;

import Controller.Register_LoginController;
import Controller.ShopController;
import Controller.UserController;
import Model.Shop;
import Model.User;
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
        UserController.getInstance().addIntoBasket(id, user,accountName);
    }

    public void displayRemoveFromBasket(User user){
        System.out.print("Id want to remove from Basket: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Remove from Shop with Account Name: ");
        String accountName = sc.nextLine();
        UserController.getInstance().removeFromBasket(id, user, accountName);
    }

    public void showBasket(User user) {
        UserService.getInstance().showBasket(user);
    }

    //-------------------------------------------------
    public void displaySetAddMonneyMethod(User user){
        System.out.print("'Bank(100%)' or 'PhoneCard(80%)': ");
        String type = sc.nextLine();
        UserController.getInstance().setAddMoneyMethod(type, user);
    }

    public void displayAddMonney(User user){
        System.out.print("The monney want to add: ");
        double monney = sc.nextDouble();
        sc.nextLine();
        UserController.getInstance().addMonneyToAccount(monney, user);
    }

    //-------------------------------------------------
    public void displaySetPaymentMethod(User user){
        System.out.print("'Bank' or 'Account': ");
        String type = sc.nextLine();
        UserController.getInstance().setPaymentMethod(type, user);
    }

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


    public void displaySendMessage(User user){
        System.out.print("Send to Account: ");
        String accountName = sc.nextLine();
        System.out.print("Conten is: ");
        String content = sc.nextLine();
        user.sendMessageTo(accountName, content);
    }


    public void displayReadMail(User user){
        System.out.print("Read MailBox With Account: ");
        String accountName = sc.nextLine();
        user.readMail(accountName);
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

    public void showMyProduct(Shop shop){
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
    public void displayMenuClient(User user){
        System.out.println("                                          Welcome " + user.getAccountName() + "(Client)");
        System.out.println("1: Add a Product To Basket");
        System.out.println("2: Remove a Product To Basket");
        System.out.println("3: Show my Basket");
        System.out.println("4. Choose Method to Add Monney to Account");
        System.out.println("5. Add Monney to Account");
        System.out.println("6. Choose Method Payment");
        System.out.println("7. Buy Product");
        System.out.println("8. Connect To Another User");
        System.out.println("9. Send A Message");
        System.out.println("10. Read MailBox");
        System.out.println("11. Check Your Account");
        System.out.println("12. Check your BankCard");
        System.out.println("13. Vote A Product");
        System.out.println("14. Show Vote About Product");
        System.out.println("0. Log out");
        System.out.print("Enter your choose: ");
    }


    public void displayMenuShop(User user){
        System.out.println("                                          Welcome " + user.getAccountName() + "(Shop)");
        System.out.println("1: Add a Product To Basket");
        System.out.println("2: Remove a Product To Basket");
        System.out.println("3: Show my Basket");
        System.out.println("4. Add a Product into My Store");
        System.out.println("5. Remove a Product from My Store");
        System.out.println("6. Show Product in my Store");
        System.out.println("7. Choose Method to Add Monney to Account");
        System.out.println("8. Add Monney to Account");
        System.out.println("9. Choose Method Payment");
        System.out.println("10. Buy Product");
        System.out.println("11. Connect To Another User");
        System.out.println("12. Send A Message");
        System.out.println("13. Read MailBox");
        System.out.println("14. Check Your Account");
        System.out.println("15. Check your BankCard");
        System.out.println("16. Vote A Product");
        System.out.println("17. Show Vote About Product");
        System.out.println("0. Log out");
        System.out.print("Enter your choose: ");
    }


    public void displayMenuRegister_Login(){
        System.out.println("1. Resigter an account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choose: ");
    }
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

    public void  voteProduct(User user){
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
        UserController.getInstance().voteProduct(accountName, id, star, comment, user);
    }

    public void showVoteProduct(){
        System.out.print("Enter product's Id that you want to see: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("At Shop with AccountName: ");
        String accountName = sc.nextLine();
        UserController.getInstance().showVoteProduct(accountName, id);
    }
}

