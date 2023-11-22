package View;

import Controller.RegisterAccountController;
import Model.Client;
import Model.Login;
import Model.Shop;
import Model.User;

import java.util.Scanner;

public class DisplayRegister {
    public static User display(){
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
                    return user;
            }
        }
        return null;
    }
}
