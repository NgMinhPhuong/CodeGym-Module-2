package View;

import Controller.ShopController;
import Controller.UserController;
import untils.DataFile;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;

import java.util.Scanner;

public class DisplayShop {
    public static void display(String accountNameOfuser){
        Scanner sc = new Scanner(System.in);
        String accountName;
        String password;
        String userName;
        String type;
        int choose1 = -1;
        while(choose1 != 0)
        {
            Shop shop = null;
            DataFile.readShop();
            DataFile.readClient();
            for(User x : RegisterAccount.getAccountShopList()){
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
            System.out.println("7. Choose Method to Add Monney to Account");
            System.out.println("8. Add Monney to Account");
            System.out.println("9. Choose Method Payment");
            System.out.println("10. Buy Product");
            System.out.println("11. Connect To Another User");
            System.out.println("12. Send A Message");
            System.out.println("13. Read MailBox");
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
                    System.out.print("Remove from Shop with Account Name: ");
                    accountName = sc.nextLine();
                    UserController.getInstance().removeFromBasket(id, shop, accountName);
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
                    System.out.print("'Bank' or 'PhoneCard': ");
                    type = sc.nextLine();
                    UserController.getInstance().setAddMoneyMethod(type, shop);
                    break;
                case 8:
                    System.out.print("The monney to add: ");
                    double monney = sc.nextDouble();
                    sc.nextLine();
                    UserController.getInstance().addMonneyToAccount(monney, shop);
                    break;
                case 9:
                    System.out.print("'Bank' or 'Account': ");
                    type = sc.nextLine();
                    UserController.getInstance().setPaymentMethod(type, shop);
                    break;
                case 10:
                    System.out.print("Product's Id you want to buy: ");
                    id = sc.nextInt();
                    System.out.print("Quanlity to Buy: ");
                    amount = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Buy at the Shop has Id: ");
                    accountName = sc.nextLine();
                    UserController.getInstance().pay(id, amount, accountName, shop);
                    break;
                case 11:
                    System.out.print("You want to connect to Account: ");
                    accountName = sc.nextLine();
                    shop.connectToAnUser(accountName);
                    break;
                case 12:
                    System.out.print("Send to Account: ");
                    accountName = sc.nextLine();
                    System.out.print("Conten is: ");
                    String content = sc.nextLine();
                    shop.sendMessageTo(accountName, content);
                    break;
                case 13:
                    System.out.print("Read MailBox With Account: ");
                    accountName = sc.nextLine();
                    shop.readMail(accountName);
                    break;

            }
            System.out.println("------------------------------------------------------------");
        }
    }
}
