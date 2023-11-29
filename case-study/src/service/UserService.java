package service;

import Model.PayByAccount;
import Model.Product;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;
import Model.Voucher;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class UserService {
    private static UserService instance;

    private UserService() {

    }

    public static UserService getInstance() {
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }



    //--------------------------------------------------
    public User checkUserExists(String accountName){
        for (User user : RegisterAccount.getAccountClientList()){
            if(user.getAccountName().equals(accountName)){
                return user;
            }
        }

        for (User user : RegisterAccount.getAccountShopList()){
            if(user.getAccountName().equals(accountName)){
                return user;
            }
        }
        return null;
    }

    public User checkShopExists(String accountName){
        for (User user : RegisterAccount.getAccountShopList()){
            if(user.getAccountName().equals(accountName)){
                return user;
            }
        }
        return null;
    }

    public void showTransactionHistory(User user){
        if(user.getTransactionHistory().isEmpty()){
            System.out.println("Your Transaction is empty");
            return;
        }
        List<String> list = user.getTransactionHistory();
        for(int i = list.size() - 1; i >= 0; i--){
            System.out.println(list.get(i));
        }
    }

    public void findProduct(String productName){
        int cnt = 0;
        for(User user : RegisterAccount.getAccountShopList()){
           for(Product product : ((Shop)(user)).getMyProductList()){
               if(product.getName().contains(productName)){
                   System.out.println(user.getAccountName() + ":  " + product);
                   cnt++;
               }
           }
        }
        if(cnt == 0){
            System.out.println("There is no Product with " + "'" + productName + "'");
        }
    }



}