package View;

import Menu.Menu;
import Model.Client;
import untils.DataAccount;
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
                DataAccount.getInstance().readClient();
                DataAccount.getInstance().readShop();
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
                        DisPlay.getInstance().displayShowBasket(client);
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
                    case 13:
                        DisPlay.getInstance().checkMonneyInBankCard(client);
                        break;
                    case 14:
                        DisPlay.getInstance().displayVoteProduct(client);
                        break;
                    case 15:
                        DisPlay.getInstance().displayShowVoteProduct();
                        break;
                    case 16:
                        DisPlay.getInstance().displayTransactionHistory(client);
                        break;
                    case 17:
                        DisPlay.getInstance().displayUpdateInformation(client);
                        break;
                    case 18:
                        DisPlay.getInstance().displayChangePassword(client);
                        break;
                    case 19:
                        DisPlay.getInstance().displayShowMyVoucher(client);
                        break;
                }
                System.out.println("------------------------------------------------------------");
            }
        }
    }
}
