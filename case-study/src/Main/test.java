package Main;

import build.Client;
import build.Login;
import build.RegisterAccount;
import build.Shop;
import build.User;


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
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    RegisterAccount registerAccount = new RegisterAccount();
                    System.out.print("Create accountName is: ");
                    accountName = sc.nextLine();
                    System.out.print("Create password is: ");
                    password = sc.nextLine();
                    System.out.print("User Name is: ");
                    userName = sc.nextLine();
                    System.out.print("Type('Shop' or 'Client': ");
                    String type = sc.nextLine();
                    registerAccount.resigter(userName, accountName, password, type);
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
                    int choose1 = 0;
                    if (user instanceof Client) {
                        Client client = (Client) user;
                        while(choose1 != 7)
                        {
                            System.out.println("                                          Welcome " + client.getAccountName());
                            System.out.println("1: Add a Product To Basket");
                            System.out.println("2: Add a Product To Basket");
                            System.out.println("3. Buy Product");
                            System.out.println("4. Connect To Another User");
                            System.out.println("5. Send A Message");
                            System.out.println("6. Read MailBox");
                            System.out.println("7. Log out");
                            System.out.print("Enter your choose: ");
                            choose1 = sc.nextInt();
                            sc.nextLine();
                            switch (choose1){
                                case 1:
                                    //client.addIntoBasket();
                                    break;
                                case 4:
                                    System.out.print("You want to connect to Account: ");
                                    accountName = sc.nextLine();
                                    client.connectToAnUser(accountName);
                                    break;
                                case 5:
                                    System.out.print("Send to Account: ");
                                    accountName = sc.nextLine();
                                    System.out.print("Conten is: ");
                                    String content = sc.nextLine();
                                    client.sendMessageTo(accountName, content);
                                    break;
                                case 6:
                                    System.out.print("Read MailBox With Account: ");
                                    accountName = sc.nextLine();
                                    client.readMail(accountName);
                                    break;
                            }
                            System.out.println("------------------------------------------------------------");
                        }
                    }else if(user instanceof Shop){
                        Shop shop = (Shop) user;
                        while(choose1 != 6)
                        {
                            System.out.println("1: Add a Product To Basket");
                            System.out.println("2: Add a Product To Basket");
                            System.out.println("3. Buy Product");
                            System.out.print("Enter your choose: ");
                            choose1 = sc.nextInt();
                            switch (choose1){
                                case 1:
                                    String name = sc.nextLine();
                                    double price = sc.nextDouble();
                                    sc.nextLine();
                                    int amount = sc.nextInt();
                                    sc.nextLine();
                                    String description = sc.nextLine();
                                    shop.addProduct(name, price, description, amount);
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

