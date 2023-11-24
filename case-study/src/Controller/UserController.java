package Controller;

import Model.AddByBank;
import Model.AddByPhoneCard;
import service.UserService;
import untils.DataFile;
import Model.PayByAccount;
import Model.PayByCard;
import Model.Product;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;

import java.util.List;
import java.util.Map;


public class UserController {
    private static UserController instance;

    private UserController() {

    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    //-----------------------------------------------------------

    public void addIntoBasket(int id, User userAdd, String accountName) {
        User userSell = null;
        for (User user : RegisterAccount.getAccountShopList()) {
            if (user.getAccountName().equals(accountName)) {
                userSell = user;
                break;
            }
        }

        if (userSell == null) {
            System.out.println("This store is not available");
            return;
        }
        for (Product product : ((Shop) userSell).getMyProductList()) {
            if (id == product.getId()) {
                product = new Product(product);
                UserService.getInstance().addIntoBasket(userAdd ,product, accountName);
                System.out.println("Add successfully");
                DataFile.writeClient();
                DataFile.writeShop();
                return;
            }
        }
        System.out.println("Id is not exists");

    }

    //------------------------------------------------------------------

    public void removeFromBasket(int id, User userRemove, String accountName) {
        User userSell = null;
        for (User user : RegisterAccount.getAccountShopList()) {
            if (user.getAccountName().equals(accountName)) {
                userSell = user;
                break;
            }
        }

        if (userSell == null) {
            System.out.println("This store is not available");
            return;
        }

        for (Map.Entry<String, List<Product>> map : userRemove.getBasket().entrySet()){
            for(Product product : map.getValue()){
                if(product.getId() == id){
                    UserService.getInstance().removeFromBasket(userRemove, id, accountName);
                    System.out.println("Remove from your Basket successfully");
                    DataFile.writeClient();
                    DataFile.writeShop();
                    return;
                }
            }
        }
        System.out.println("There is no this Id in your Basket");
    }

    //---------------------------------------------------------------------------


    //----------------------------------------
    public void setPaymentMethod(String type, User user){
        if (type.equals("Bank")) {
            user.setPaymentMethod(new PayByCard());
            System.out.println("Selected !");
            DataFile.writeShop();
            DataFile.writeClient();
            return;
        } else if (type.equals("Account")) {
            user.setPaymentMethod(new PayByAccount());
            System.out.println("Selected !");
            DataFile.writeShop();
            DataFile.writeClient();
            return;
        }
        System.out.println("Type is Wrong. Type must be ('Bank' or 'Account')");
    }

    //-----------------------------------------------------------
    public void pay(int id, int amount, String accountName, User userBuy) {
        if (userBuy.getPaymentMethod() == null) {
            System.out.println("Chose a PaymentMethod please");
            return;
        }
        Product product = null;
        for (User user : RegisterAccount.getAccountShopList()) {
            for (Product x : ((Shop) user).getMyProductList()) {
                if (x.getId() == id) {
                    product = x;
                    break;
                }
            }
        }
        if (product == null) {
            System.out.println("Id is not Exists");
            return;
        }

        User userSell = null;
        for (User x : RegisterAccount.getAccountShopList()) {
            if (x.getAccountName().equals(accountName)) {
                userSell = x;
                break;
            }
        }
        if (userSell == null) {
            System.out.println("This store is not available");
            return;
        }

        if (amount > product.getAmount()) {
            System.out.println("We only have " + product.getAmount() + " of them");
            return;
        }
        UserService.getInstance().pay(product, amount, userBuy, userSell);
        DataFile.writeClient();
        DataFile.writeShop();
    }

    //-------------------------------------------------------------
    public void setAddMoneyMethod(String type, User user){
        if (type.equals("Bank")) {
            user.setAddMoneyMethod(new AddByBank());
            System.out.println("Selected !");
            DataFile.writeShop();
            DataFile.writeClient();
            return;
        } else if (type.equals("PhoneCard")) {
            user.setAddMoneyMethod(new AddByPhoneCard());
            System.out.println("Selected !");
            DataFile.writeShop();
            DataFile.writeClient();
            return;
        }
        System.out.println("Type is Wrong. Type must be ('Bank' or 'PhoneCard')");
    }

    public void addMonneyToAccount(double monney, User user){
        if(user.getAddMoneyMethod() == null){
            System.out.println("Please a Method to Add Monney");
            return;
        }
        if(user.getAddMoneyMethod() instanceof AddByBank){
            if(monney > user.getBankCard()){
                System.out.println("Your cardAccount is not enough monney");
                return;
            }
            UserService.getInstance().addMonneyToAccount(user, monney);
            System.out.println("Add successfully");
            DataFile.writeShop();
            DataFile.writeClient();
        } else{
            UserService.getInstance().addMonneyToAccount(user, monney);
            System.out.println("Add successfully");
            DataFile.writeShop();
            DataFile.writeClient();
        }
    }
    //------------------------------------------------------------------

    public void showCommentProduct(String accountName, int id){
        for(accountName)
    }

}