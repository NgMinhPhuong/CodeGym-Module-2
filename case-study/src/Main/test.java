package Main;

import Model.Client;
import Model.Shop;
import Model.User;
import View.DisplayShop;
import View.DisplayClient;
import View.DisplayLogin_Register;

public class test {
    public static void main(String[] args) {
        User user;
         do{
            user = DisplayLogin_Register.display();
            if (user == null) return;
            String accountNameOfuser = user.getAccountName();
            if (user instanceof Client) {
                DisplayClient.display(accountNameOfuser);
            } else if (user instanceof Shop) {
                DisplayShop.display(accountNameOfuser);
            }
        }while(user != null);

    }
}

