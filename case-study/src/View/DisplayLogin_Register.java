package View;

import Controller.Register_LoginController;
import Model.User;
import untils.DataFile;

import java.util.Scanner;

public class DisplayLogin_Register {
    public static User display(){
        Scanner sc = new Scanner(System.in);
        int choose = -1;
        while(choose != 3) {
            DataFile.readClient();
            DataFile.readShop();
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
                    DisPlay.getInstance().displayRegister();
                    break;
                case 2:
                    User user = DisPlay.getInstance().displayLogin();
                    if(user == null) continue;
                    return user;
            }
        }
        return null;
    }
}
