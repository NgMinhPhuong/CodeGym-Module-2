package View;

import Menu.Menu;
import untils.DataAccount;
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
            DataAccount.getInstance().readShop();
            DataAccount.getInstance().readClient();
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
                    DisPlay.getInstance().displayShowBasket(shop);
                    break;
                case 4:
                   DisPlay.getInstance().displayAddProduct(shop);
                    break;
                case 5:
                    DisPlay.getInstance().displayRemoveProduct(shop);
                    break;
                case 6:
                    DisPlay.getInstance().displayShowMyProduct(shop);
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
                    DisPlay.getInstance().displayFindProduct();
                    break;
                case 12:
                    DisPlay.getInstance().displayConnectAccount(shop);
                    break;
                case 13:
                    DisPlay.getInstance().displaySendMessage(shop);
                    break;
                case 14:
                    DisPlay.getInstance().displayReadMail(shop);
                    break;
                case 15:
                    DisPlay.getInstance().checkMonneyInAccount(shop);
                    break;
                case 16:
                    DisPlay.getInstance().checkMonneyInBankCard(shop);
                    break;
                case 17:
                    DisPlay.getInstance().displayVoteProduct(shop);
                    break;
                case 18:
                    DisPlay.getInstance().displayShowVoteProduct();
                    break;
                case 19:
                    DisPlay.getInstance().displayRevenue(shop);
                    break;
                case 20:
                    DisPlay.getInstance().displayTransactionHistory(shop);
                    break;
                case 21:
                    DisPlay.getInstance().displayUpdateInformation(shop);
                    break;
                case 22:
                    DisPlay.getInstance().displayChangePassword(shop);
                    break;
                case 23:
                    DisPlay.getInstance().displayShowMyVoucher(shop);
            }
            System.out.println("------------------------------------------------------------");
        }
    }
}
