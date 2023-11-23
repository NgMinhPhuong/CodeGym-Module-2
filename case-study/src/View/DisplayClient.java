package View;

import Controller.UserController;
import Model.Client;
import untils.DataFile;
import Model.RegisterAccount;
import Model.User;

import java.util.Scanner;

public class DisplayClient {
    public static void display(String accountNameOfuser){
        {
            Scanner sc = new Scanner(System.in);
            int choose1 = -1;
            while(choose1 != 0)
            {
                Client client = null;
                DataFile.readClient();
                DataFile.readShop();
                for(User x : RegisterAccount.getAccountClientList()){
                    if(x.getAccountName().equals(accountNameOfuser)){
                        client = (Client) x;
                        break;
                    }
                }
                System.out.println("                                          Welcome " + client.getAccountName() + "(Client)");
                System.out.println("1: Add a Product To Basket");
                System.out.println("2: Remove a Product To Basket");
                System.out.println("3: Show my Basket");
                System.out.println("4. Choose Method to Add Monney to Account");
                System.out.println("5. Add Monney to Account");
                System.out.println("6. Choose Method Payment");
                System.out.println("7. Buy Product");
                System.out.println("8. Connect To Another User");
                System.out.println("9. Send A Message");
                System.out.println("10. Read MailBox");
                System.out.println("0. Log out");
                System.out.print("Enter your choose: ");
                try{
                    choose1 = sc.nextInt();
                } catch (Exception e){
                    continue;
                } finally {
                    sc.nextLine();
                }
                int id = 0;
                switch (choose1){
                    case 1:
                        DisPlay.getInstance().displayAddToBasket(client);
                        break;
                    case 2:
                        DisPlay.getInstance().displayRemoveFromBasket(client);
                        break;
                    case 3:
                        UserController.getInstance().showBasket(client);
                        break;
                    case 4:
                        DisPlay.getInstance().displaySetMethodAddMonney(client);
                        break;
                    case 5:
                        DisPlay.getInstance().displayAddMonney(client);
                        break;
                    case 6:
                        DisPlay.getInstance().displaySetMethodPayment(client);
                        break;
                    case 7:
                        DisPlay.getInstance().displayBuyProduct(client);
                        break;
                    case 8:
                        DisPlay.getInstance().displayConnectAccount(client);
                        break;
                    case 9:
                        DisPlay.getInstance().displaySendMessage(client);
                        break;
                    case 10:
                        DisPlay.getInstance().displayReadMail(client);
                        break;
                }
                System.out.println("------------------------------------------------------------");
            }
        }
    }
}
