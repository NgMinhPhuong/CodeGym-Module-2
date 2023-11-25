package View;

import Controller.UserController;
import Menu.Menu;
import Model.Client;
import untils.DataFile;
import Model.RegisterAccount;
import Model.User;

import java.util.Scanner;

public class DisplayClient {
    public static void display(String accountNameOfuser){
        {
            Scanner sc = new Scanner(System.in);
            int choose = -1;
            while(choose != 0)
            {
                Client client = null;
                DataFile.getInstance().readClient();
                DataFile.getInstance().readShop();
                for(User x : RegisterAccount.getAccountClientList()){
                    if(x.getAccountName().equals(accountNameOfuser)){
                        client = (Client) x;
                        break;
                    }
                }
                Menu.getInstance().displayMenuClient(client);
                try{
                    choose = sc.nextInt();
                } catch (Exception e){
                    continue;
                } finally {
                    sc.nextLine();
                }
                switch (choose){
                    case 1:
                        DisPlay.getInstance().displayAddToBasket(client);
                        break;
                    case 2:
                        DisPlay.getInstance().displayRemoveFromBasket(client);
                        break;
                    case 3:
                        DisPlay.getInstance().showBasket(client);
                        break;
                    case 4:
                        DisPlay.getInstance().displaySetAddMonneyMethod(client);
                        break;
                    case 5:
                        DisPlay.getInstance().displayAddMonney(client);
                        break;
                    case 6:
                        DisPlay.getInstance().displaySetPaymentMethod(client);
                        break;
                    case 7:
                        DisPlay.getInstance().displayBuyProduct(client);
                        break;
                    case 8:
                        DisPlay.getInstance().displayFindProduct();
                        break;
                    case 9:
                        DisPlay.getInstance().displayConnectAccount(client);
                        break;
                    case 10:
                        DisPlay.getInstance().displaySendMessage(client);
                        break;
                    case 11:
                        DisPlay.getInstance().displayReadMail(client);
                        break;
                    case 12:
                        DisPlay.getInstance().checkMonneyInAccount(client);
                        break;
                    case 123:
                        DisPlay.getInstance().checkMonneyInBankCard(client);
                        break;
                    case 14:
                        DisPlay.getInstance().voteProduct(client);
                        break;
                    case 15:
                        DisPlay.getInstance().showVoteProduct();
                        break;
                    case 16:
                        DisPlay.getInstance().showTransactionHistory(client);
                        break;

                }
                System.out.println("------------------------------------------------------------");
            }
        }
    }
}
