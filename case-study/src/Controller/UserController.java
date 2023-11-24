package Controller;

import Model.AddByBank;
import Model.AddByPhoneCard;
import service.ShopService;
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
                DataFile.getInstance().writeClient();
                DataFile.getInstance().writeShop();
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
                    DataFile.getInstance().writeClient();
                    DataFile.getInstance().writeShop();
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
            DataFile.getInstance().writeShop();
            DataFile.getInstance().writeClient();
            return;
        } else if (type.equals("Account")) {
            user.setPaymentMethod(new PayByAccount());
            System.out.println("Selected !");
            DataFile.getInstance().writeShop();
            DataFile.getInstance().writeClient();
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
        DataFile.getInstance().writeClient();
        DataFile.getInstance().writeShop();
    }

    //-------------------------------------------------------------
    public void setAddMoneyMethod(String type, User user){
        if (type.equals("Bank")) {
            user.setAddMoneyMethod(new AddByBank());
            System.out.println("Selected !");
            DataFile.getInstance().writeShop();
            DataFile.getInstance().writeClient();
            return;
        } else if (type.equals("PhoneCard")) {
            user.setAddMoneyMethod(new AddByPhoneCard());
            System.out.println("Selected !");
            DataFile.getInstance().writeShop();
            DataFile.getInstance().writeClient();
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
            DataFile.getInstance().writeShop();
            DataFile.getInstance().writeClient();
        } else{
            UserService.getInstance().addMonneyToAccount(user, monney);
            System.out.println("Add successfully");
            DataFile.getInstance().writeShop();
            DataFile.getInstance().writeClient();
        }
    }
    //------------------------------------------------------------------

    public void voteProduct(String accountName, int id, int star, String comment, User userComment){
        User user = UserService.getInstance().checkUserExists(accountName);
        if(user == null){
            System.out.println("This store is not available");
            return;
        }

        Product product = ShopService.getInstance().checkIdExists(id);
        if (product == null){
            System.out.println("This store has no this ID");
            return;
        }
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\vote_product\\"
                + accountName + "_" + id + ".csv";
        DataFile.getInstance().writeVote(path, star, comment, userComment);
        System.out.println("Comment Successfully");
    }
    public void showVoteProduct(String accountName, int id){
        User user = UserService.getInstance().checkShopExists(accountName);
        if(user == null){
            System.out.println("This store is not available");
            return;
        }

        Product product = ShopService.getInstance().checkIdExists(id);
        if (product == null){
            System.out.println("This store has no this ID");
            return;
        }
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\vote_product\\"
                + accountName + "_" + id + ".csv";
        List<String> listComment;
        listComment = DataFile.getInstance().readVote(path);
        if(listComment == null) {
            System.out.println("There are no comments for this product yet");
            return;
        }
        String [] ss;
        for(int i = listComment.size() - 1; i >= 0; i--){
            ss = listComment.get(i).split(",");
            System.out.println(ss[0] + ": " + ss[1] + " SAO -> " + ss[2]);
        }

    }

}