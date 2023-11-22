package View;

import Controller.UserController;
import Model.Client;
import Model.DataFile;
import Model.RegisterAccount;
import Model.User;

import java.util.Scanner;

public class DisplayClient {
    public static void display(String accountNameOfuser){
        {
            Scanner sc = new Scanner(System.in);
            String accountName;
            String password;
            String userName;
            String type;
            int choose1 = -1;
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
                System.out.println("4. Choose Method to Add Monney to Account");
                System.out.println("5. Add Monney to Account");
                System.out.println("6. Choose Method Payment");
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
                        System.out.print("'Bank' or 'PhoneCard': ");
                        type = sc.nextLine();
                        UserController.getInstance().setAddMoneyMethod(type, client);
                        break;
                    case 5:
                        System.out.print("The monney to add: ");
                        double monney = sc.nextDouble();
                        sc.nextLine();
                        UserController.getInstance().addMonneyToAccount(monney, client);
                        break;
                    case 6:
                        System.out.print("'Bank' or 'Account': ");
                        type = sc.nextLine();
                        UserController.getInstance().setPaymentMethod(type, client);
                        break;
                    case 7:
                        System.out.print("Product's Id you want to buy: ");
                        id = sc.nextInt();
                        System.out.print("Quanlity to Buy: ");
                        int amount = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Buy at the Shop has Id: ");
                        accountName = sc.nextLine();
                        UserController.getInstance().pay(id, amount, accountName, client);
                        break;
                    case 8:
                        System.out.print("You want to connect to Account: ");
                        accountName = sc.nextLine();
                        client.connectToAnUser(accountName);
                        break;
                    case 9:
                        System.out.print("Send to Account: ");
                        accountName = sc.nextLine();
                        System.out.print("Conten is: ");
                        String content = sc.nextLine();
                        client.sendMessageTo(accountName, content);
                        break;
                    case 10:
                        System.out.print("Read MailBox With Account: ");
                        accountName = sc.nextLine();
                        client.readMail(accountName);
                        break;
                }
                System.out.println("------------------------------------------------------------");
            }
        }
    }
}
