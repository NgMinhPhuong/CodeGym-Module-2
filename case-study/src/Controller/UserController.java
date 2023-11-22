package Controller;

import Model.Client;
import Model.DataFile;
import Model.Product;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;


public class UserController{
    private static UserController instance;
    private UserController(){

    }
    public static UserController getInstance(){
        if(instance == null){
            instance = new UserController();
        }
        return instance;
    }
    public void pay(int id, int amount, String accountName, User userBuy){
        if(userBuy.getPaymentMethod() == null)  {
            System.out.println("Chose a PaymentMethod please");
            return;
        }
        Product product = null;
        for(User user : RegisterAccount.accountShopList){
            for(Product x : ((Shop) user).getMyProductList()){
                if(x.getId() == id){
                    product = x;
                    break;
                }
            }
        }
        if(product == null){
            System.out.println("Id is not Exists");
            return;
        }

        User userSell = null;
        for(User x : RegisterAccount.accountShopList){
            if(x.getAccountName().equals(accountName)){
                userSell = x;
                break;
            }
        }
        if(userSell == null){
            System.out.println("This store is not available");
            return;
        }

        if(amount > product.getAmount()){
            System.out.println("We only have " + product.getAmount() + " of them");
            return;
        }
        userBuy.pay(product, amount, userSell);
        DataFile.writeClient();
        DataFile.writeShop();
    }

    public void addIntoBasket(int id, User userBuy, String accountName){
        User userSell = null;
        for(User user : RegisterAccount.accountShopList){
            if(user.getAccountName().equals(accountName)){
                userSell = user;
            }
        }

        if(userSell == null){
            System.out.println("This store is not available");
            return;
        }
        for(Product product : ((Shop) userSell).getMyProductList()){
            if(id == product.getId()){
                userBuy.addIntoBasket(product);
                System.out.println("Add successfully");
                DataFile.writeClient();
                DataFile.writeShop();
                return;
            }
        }
        System.out.println("Id is not exists");

    }

    public void removeFromBasket(int id, User userBuy){
        for(Product product : ((Shop) userBuy).getMyProductList()){
            if(product.getId() == id){
                ((Client) userBuy).removeFromBasket(id);
                System.out.println("Remove from your Basket successfully");
                DataFile.writeClient();
                DataFile.writeShop();
                return;
            }
        }
        System.out.println("Id is not exists");
    }

    public void showBasket(User user){
        user.showBasket();
    }
}
