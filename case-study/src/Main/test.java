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
import View.DisplayRegister;


import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        User user;
         do{
            user = DisplayRegister.display();
            if (user == null) return;
            String accountNameOfuser = user.getAccountName();
            if (user instanceof Client) {
                DisplayClient.display(accountNameOfuser);
            } else if (user instanceof Shop) {
                DispalyShop.display(accountNameOfuser);
            }
        }while(user != null);

    }
}

