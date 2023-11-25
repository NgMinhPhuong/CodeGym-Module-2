package service;

import Model.Product;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;
import untils.DataFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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



    //-------------------------------------------


    //-----------------------------------------------------------

    User checkExists(String accountName) {
        User user = null;
        for (User x : RegisterAccount.getAccountClientList()) {
            if ((x.getAccountName()).equals(accountName)) {
                user = x;
                return user;
            }
        }
        for (User x : RegisterAccount.getAccountShopList()) {
            if ((x.getAccountName()).equals(accountName)) {
                user = x;
                return user;
            }
        }
        return user;
    }

    //------------------------------------
    public String checkTruePath(User user1, User user2) {

        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + user2.getUserName()
                + "_And_" + user1.getUserName() + ".txt";
        String path1 = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + user1.getUserName()
                + "_And_" + user2.getUserName() + ".txt";

        if (new File(path).exists()) {
            return path;
        } else if (new File(path1).exists()) {
            return path1;
        } else {
            return null;
        }
    }

    //--------------------------------------
    public void connectToAnUser(User user1, String accountName) {
        User user2 = checkExists(accountName);
        if (user2 == null) {
            System.out.println("Account Name is not exists");
            return;
        }
        String path = checkTruePath(user1, user2);
        if (path == null) {
            String newPath = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + user1.getUserName()
                    + "_And_" + user2.getUserName() + ".txt";
            File fileConnect = new File(newPath);

            try {
                fileConnect.createNewFile();
                System.out.println("Connect To " + user2.getAccountName() + "(" + user2.getUserName() + ") Successfully");
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        System.out.println("You are connected");

    }

    //----------------------------------------
    public void sendMessageTo(User user1, String accountName, String message) {
        User user2 = checkExists(accountName);
        if (user2 == null) {
            System.out.println("Account Name is not exists. Cannot send this massage");
            return;
        }
        String path = checkTruePath(user1, user2);
        if (path == null) {
            System.out.println("Please Connect To " + user2.getAccountName());
            return;
        } else {
            try {
                FileWriter fr = new FileWriter(path, true);
                fr.write(user1.getUserName() + ": " + message + "\n");
                fr.close();
                System.out.println("Sent!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //----------------------------------------------
    public void readMail(User user1, String accountName) {
        User user2 = checkExists(accountName);
        if (user2 == null) {
            System.out.println("Account is not exists");
            return;
        }
        String path = checkTruePath(user1, user2);
        if (path == null) {
            System.out.println("No MailBox with This Account");
            return;
        }
        System.out.println();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String str;
            while ((str = br.readLine()) != null) {
                String s = "";
                for (int i = 0; i < str.length(); i++) {
                    s += str.charAt(i);
                    if (s.equals(user1.getUserName())) {
                        System.out.print("                           ");
                        break;
                    }
                }
                System.out.println(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addIntoBasket(User userAdd, Product product, String accountName) {
        if (userAdd.getBasket().containsKey(accountName)) {
            List<Product> tmp = userAdd.getBasket().get(accountName);
            tmp.add(product);
        } else {
            List<Product> tmp = new ArrayList<>();
            tmp.add(product);
            userAdd.getBasket().put(accountName, tmp);
        }

    }


    public void removeFromBasket(User userRemove, int id, String accountName) {
        List<Product> tmp = userRemove.getBasket().get(accountName);
        for (Product product : tmp) {
            if (product.getId() == id) {
                userRemove.getBasket().get(accountName).remove(product);
                if (tmp.isEmpty()) {
                    userRemove.getBasket().remove(accountName);
                }
                return;
            }
        }
    }
    public void showBasket(User userShow){
        if(userShow.getBasket().isEmpty()){
            System.out.println("Basket is empty");
            return;
        }
        for(Map.Entry<String, List<Product>> map : userShow.getBasket().entrySet()){
            System.out.println(map.getKey() + ": ");
            for (Product product : map.getValue()){
                System.out.println("         " + product);
            }
            System.out.println();
        }
    }
    public void pay(Product product, int amount, User userBuy, User userSell) {
        userBuy.getPaymentMethod().pay(product, amount, userBuy, userSell);
        int id = product.getId();
        if(product.getAmount() == 0){
            for(Product x : ((Shop) userSell).getMyProductList()){
                if(product.getId() == x.getId()){
                    ((Shop) userSell).getMyProductList().remove(x);
                    break;
                }
            }
        }

        LocalTime localTime = LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);
        LocalDate localDate = LocalDate.now();
        String buy = localDate.toString() + "   " + localTime.toString() + " Bought " + amount + " " + product.getName() +
                "(ID: " + product.getId() + ") at the Shop with AccountName: " + userSell.getAccountName() + " (" + userSell.getUserName() + ")";
        String sell = localDate.toString() + "   " + localTime.toString() + " Sold " + amount + " " + product.getName() +
                "(ID: " + product.getId() + ") to Account Name: " + userBuy.getAccountName() + " (" + userBuy.getUserName() + ")";

        userBuy.getTransactionHistory().add(buy);
        userSell.getTransactionHistory().add(sell);
        List<Product> tmp = userBuy.getBasket().get(userSell.getAccountName());
        if (tmp == null) {
            System.out.println("Payment success");
            return;
        }
        for(Product x : tmp){
            if(x.getId() == id){
                x.setAmount(x.getAmount() - amount);
                if(x.getAmount() == 0){
                    tmp.remove(x);
                    if(tmp.isEmpty()) {
                        userBuy.getBasket().remove(userSell.getAccountName());
                    }
                    break;
                }
                break;
            }
        }
        System.out.println("Payment success");
    }

    public void addMonneyToAccount(User user, double monney){
            if(user.getAddMoneyMethod() == null){
                System.out.println("Chose Add Method Please");
            } else{
                user.getAddMoneyMethod().add(user, monney);
            }
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
}