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
import View.DispalyShop;
import View.DisplayClient;


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
                        DisplayClient.display(accountNameOfuser);fdfd
                    }else if(user instanceof Shop){
                        DispalyShop.display(accountNameOfuser);
                    }
                    break;
            }

        }

    }
}

