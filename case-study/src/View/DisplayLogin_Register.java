package View;

import Controller.Register_LoginController;
import Menu.Menu;
import Model.User;
import untils.DataFile;

import java.util.Scanner;

public class DisplayLogin_Register {
    public static User display(){
        Scanner sc = new Scanner(System.in);
        int choose = -1;
        while(choose != 3) {
            DataFile.getInstance().readClient();
            DataFile.getInstance().readShop();
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
            }
        }
        return null;
    }
}
