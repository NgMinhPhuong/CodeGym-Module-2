package View;

import Menu.Menu;
import Model.User;
import untils.DataAccount;

import java.util.Scanner;

public class DisplayLogin_Register {
    public static User display(){
        Scanner sc = new Scanner(System.in);
        int choose = -1;
        while(choose != 0) {
            DataAccount.getInstance().readClient();
            DataAccount.getInstance().readShop();
            Menu.getInstance().displayMenuRegister_Login();
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
                case 3:
                    DisPlay.getInstance().displayForgotPassWord();
                    System.out.println("-------------------------------------------------------------------------------");
                    break;
            }
        }
        return null;
    }
}
