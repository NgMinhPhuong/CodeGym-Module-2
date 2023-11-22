package Main;

import Controller.RegisterAccountController;
import Controller.ShopController;
import Controller.UserController;
import Model.Client;
import Model.DataFile;
import Model.Login;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;


import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String accountName;
        String password;
        String userName;
        int choose = -1;
        while(choose != 3) {
            System.out.println("1. Resigter an account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choose: ");
            try{
                choose = sc.nextInt();

            } catch (Exception e){
                continue;
            } finally {
                sc.nextLine();
            }

            switch (choose) {
                case 1:
                    System.out.print("Create accountName is: ");
                    accountName = sc.nextLine();
                    System.out.print("Create password is: ");
                    password = sc.nextLine();
                    System.out.print("User Name is: ");
                    userName = sc.nextLine();
                    System.out.print("Type('Shop' or 'Client'): ");
                    String type = sc.nextLine();
                    RegisterAccountController.getInstance().resigter(userName, accountName, password, type);
                    System.out.println("------------------------------------------------------------");
                    break;
                case 2:
                    System.out.print("Enter your accountName: ");
                    accountName = sc.nextLine();
                    System.out.print("Enter your password: ");
                    password = sc.nextLine();
                    Login login = new Login();
                    User user = login.login(accountName, password);
                    System.out.println("------------------------------------------------------------");
                    if(user == null) continue;
                    int choose1 = -1;
                    String accountNameOfuser = user.getAccountName();
                    if (user instanceof Client) {
                        while(choose1 != 0)
                        {
                            Client client = null;
                            DataFile.readClient();
                            DataFile.readShop();
                            for(User x : RegisterAccount.accountClientList){
                                if(x.getAccountName().equals(accountNameOfuser)){
                                    client = (Client) x;
                                    break;
                                }
                            }
                            System.out.println("                                          Welcome " + client.getAccountName() + "(Client)");
                            System.out.println("1: Add a Product To Basket");
                            System.out.println("2: Remove a Product To Basket");
                            System.out.println("3: Show my Basket");
                            System.out.println("4. Buy Product");
                            System.out.println("5. Connect To Another User");
                            System.out.println("6. Send A Message");
                            System.out.println("7. Read MailBox");
                            System.out.println("0. Log out");
                            System.out.print("Enter your choose: ");
                            try{
                                choose1 = sc.nextInt();
                            } catch (Exception e){
                                continue;
                            } finally {
                                sc.nextLine();
                            }
                            int id = 0;
                            switch (choose1){
                                case 1:
                                    System.out.print("Id want to Add Basket: ");
                                    id = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Product of Shop with AccountName: ");
                                    accountName = sc.nextLine();
                                    UserController.getInstance().addIntoBasket(id, client,accountName);
                                    break;
                                case 2:
                                    System.out.print("Id want to remove from Basket: ");
                                    id = sc.nextInt();
                                    sc.nextLine();
                                    UserController.getInstance().removeFromBasket(id, client);
                                    break;
                                case 3:
                                    UserController.getInstance().showBasket(client);
                                    break;
                                case 4:
                                    System.out.print("Product's Id you want to buy");
                                    id = sc.nextInt();
                                    System.out.print("Quanlity to Buy: ");
                                    int amount = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Buy at the Shop has Id: ");
                                    accountName = sc.nextLine();
                                    UserController.getInstance().pay(id, amount, accountName, client);
                                    break;
                                case 5:
                                    System.out.print("You want to connect to Account: ");
                                    accountName = sc.nextLine();
                                    client.connectToAnUser(accountName);
                                    break;
                                case 6:
                                    System.out.print("Send to Account: ");
                                    accountName = sc.nextLine();
                                    System.out.print("Conten is: ");
                                    String content = sc.nextLine();
                                    client.sendMessageTo(accountName, content);
                                    break;
                                case 7:
                                    System.out.print("Read MailBox With Account: ");
                                    accountName = sc.nextLine();
                                    client.readMail(accountName);
                                    break;
                            }
                            System.out.println("------------------------------------------------------------");
                        }
                    }else if(user instanceof Shop){

                        while(choose1 != 0)
                        {
                            Shop shop = null;
                            DataFile.readShop();
                            DataFile.readClient();
                            for(User x : RegisterAccount.accountShopList){
                                if(x.getAccountName().equals(accountNameOfuser)){
                                    shop = (Shop) x;
                                    break;
                                }
                            }
                            System.out.println("                                          Welcome " + shop.getAccountName() + "(Shop)");
                            System.out.println("1: Add a Product To Basket");
                            System.out.println("2: Remove a Product To Basket");
                            System.out.println("3: Show my Basket");
                            System.out.println("4. Add a Product into My Store");
                            System.out.println("5. Remove a Product from My Store");
                            System.out.println("6. Show Product in my Store");
                            System.out.println("7. Buy Product");
                            System.out.println("8. Connect To Another User");
                            System.out.println("9. Send A Message");
                            System.out.println("10. Read MailBox");
                            System.out.println("0. Log out");
                            System.out.print("Enter your choose: ");
                            try{
                                choose1 = sc.nextInt();
                            } catch (Exception e){
                                continue;
                            } finally {
                                sc.nextLine();
                            }
                            int id = 0;
                            switch (choose1){
                                case 1:
                                    System.out.print("Id want to Add Basket: ");
                                    id = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Product of Shop with AccountName: ");
                                    accountName = sc.nextLine();
                                    UserController.getInstance().addIntoBasket(id, shop,accountName);
                                    break;
                                case 2:
                                    System.out.print("Id want to remove from Basket: ");
                                    id = sc.nextInt();
                                    sc.nextLine();
                                    UserController.getInstance().removeFromBasket(id, shop);
                                    break;
                                case 3:
                                    UserController.getInstance().showBasket(shop);
                                    break;
                                case 4:
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
                                    break;
                                case 5:
                                    System.out.print("Product's Id want to Remove: ");
                                    id = sc.nextInt();
                                    sc.nextLine();
                                    ShopController.getInstance().removeProductFromStore(id, shop);
                                    break;
                                case 6:
                                    ShopController.getInstance().showMyProduct(shop);
                                    break;
                                case 7:
                                    System.out.print("Product's Id you want to buy: ");
                                    id = sc.nextInt();
                                    System.out.print("Quanlity to Buy: ");
                                    amount = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Buy at the Shop has Id: ");
                                    accountName = sc.nextLine();
                                    UserController.getInstance().pay(id, amount, accountName, shop);
                                    break;
                                case 8:
                                    System.out.print("You want to connect to Account: ");
                                    accountName = sc.nextLine();
                                    shop.connectToAnUser(accountName);
                                    break;
                                case 9:
                                    System.out.print("Send to Account: ");
                                    accountName = sc.nextLine();
                                    System.out.print("Conten is: ");
                                    String content = sc.nextLine();
                                    shop.sendMessageTo(accountName, content);
                                    break;
                                case 10:
                                    System.out.print("Read MailBox With Account: ");
                                    accountName = sc.nextLine();
                                    shop.readMail(accountName);
                                    break;

                            }
                            System.out.println("------------------------------------------------------------");
                        }
                    }
                    break;
            }

        }

    }
}

