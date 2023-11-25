package View;

import Menu.Menu;
import untils.DataFile;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;

import java.util.Scanner;

public class DisplayShop {
    public static void display(String accountNameOfuser){
        Scanner sc = new Scanner(System.in);
        int choose1 = -1;
        while(choose1 != 0)
        {
            Shop shop = null;
            DataFile.getInstance().readShop();
            DataFile.getInstance().readClient();
            for(User x : RegisterAccount.getAccountShopList()){
                if(x.getAccountName().equals(accountNameOfuser)){
                    shop = (Shop) x;
                    break;
                }
            }
            Menu.getInstance().displayMenuShop(shop);
            try{
                choose1 = sc.nextInt();
            } catch (Exception e){
                continue;
            } finally {
                sc.nextLine();
            }
            switch (choose1){
                case 1:
                    DisPlay.getInstance().displayAddToBasket(shop);
                    break;
                case 2:
                    DisPlay.getInstance().displayRemoveFromBasket(shop);
                    break;
                case 3:
                    DisPlay.getInstance().showBasket(shop);
                    break;
                case 4:
                   DisPlay.getInstance().displayAddProduct(shop);
                    break;
                case 5:
                    DisPlay.getInstance().displayRemoveProduct(shop);
                    break;
                case 6:
                    DisPlay.getInstance().showMyProduct(shop);
                    break;
                case 7:
                    DisPlay.getInstance().displaySetAddMonneyMethod(shop);
                    break;
                case 8:
                    DisPlay.getInstance().displayAddMonney(shop);
                    break;
                case 9:
                    DisPlay.getInstance().displaySetPaymentMethod(shop);
                    break;
                case 10:
                   DisPlay.getInstance().displayBuyProduct(shop);
                    break;
                case 11:
                    DisPlay.getInstance().displayConnectAccount(shop);
                    break;
                case 12:
                    DisPlay.getInstance().displaySendMessage(shop);
                    break;
                case 13:
                    DisPlay.getInstance().displayReadMail(shop);
                    break;
                case 14:
                    DisPlay.getInstance().checkMonneyInAccount(shop);
                    break;
                case 15:
                    DisPlay.getInstance().checkMonneyInBankCard(shop);
                    break;
                case 16:
                    DisPlay.getInstance().voteProduct(shop);
                    break;
                case 17:
                    DisPlay.getInstance().showVoteProduct();
                    break;
                case 18:
                    DisPlay.getInstance().showRevenue(shop);
                    break;
                case 19:
                    DisPlay.getInstance().showTransactionHistory(shop);
                    break;
            }
            System.out.println("------------------------------------------------------------");
        }
    }
}
