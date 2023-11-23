package View;

import Model.Client;
import Model.Shop;
import Model.User;

import java.util.Scanner;

public class View {
    private static View instance;

    private View() {

    }

    public static View getInstance() {
        if (instance == null) {
            instance = new View();
        }
        return instance;
    }

    //-------------------------------

    public void display() {
        User user;
        do {
            user = DisplayLogin_Register.display();
            if (user == null) return;
            String accountNameOfuser = user.getAccountName();
            if (user instanceof Client) {
                DisplayClient.display(accountNameOfuser);
            } else if (user instanceof Shop) {
                DisplayShop.display(accountNameOfuser);
            }
        } while (user != null);
    }
}
