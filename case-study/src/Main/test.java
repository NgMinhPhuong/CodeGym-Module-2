package Main;

import build.Admin;
import build.Client;
import build.Login;
import build.RegisterAccount;
import build.User;

import javax.security.auth.login.LoginContext;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (RandomAccessFile file = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\ProductData.csv", "rw")) {
            file.setLength(0); // Đặt độ dài file là 0
            //System.out.println("Đã xóa hết nội dung trong file nhị phân.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Client another = (Client) (new Login().login("phuong123","123456"));
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
                    registerAccount.resigter(userName, accountName, password);

                    System.out.println("------------------------------------------------------------");
                    break;
                case 2:
                    System.out.print("Enter your accountName: ");
                    accountName = sc.nextLine();
                    System.out.print("Enter your password: ");
                    password = sc.nextLine();
                    Login login = new Login();
                    User user = login.login(accountName, password);
                    if(user == null) continue;
                    int choose1 = 0;
                    if (user instanceof Client) {
                        Client client = (Client) user;
                        while(choose1 != 6)
                        {
                            System.out.println("1: Add a Product To Basket");
                            System.out.println("2: Add a Product To Basket");
                            System.out.println("3. Buy Product");
                            System.out.println("4. Connect To Another User");
                            System.out.println("5. Send A Message");
                            choose1 = sc.nextInt();
                            switch (choose1){
                                case 4:
                                    client.connectToAnUser(another);
                                    break;
                                case 5:
                                    client.sendMessageTo(another, "hi mày nhé");
                            }
                        }

                    }else {
                        while(choose1 != 6)
                        {
                            System.out.println("1: Add a Product To Basket");
                            System.out.println("2: Add a Product To Basket");
                            System.out.println("3. Buy Product");
                            System.out.println();
                            choose1 = sc.nextInt();
                        }

                    }
                    break;
            }

        }

    }
}

