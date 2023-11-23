package service;

import Model.Product;
import Model.RegisterAccount;
import Model.User;
import untils.DataFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {
    private static UserService instance;
    private User user;

    private UserService() {

    }

    public static UserService getInstance() {
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }

    public User getUser() {

        return user;
    }

    //-------------------------------------------


    //-----------------------------------------------------------

    User checkExists(String accountName) {
        User user = null;
        DataFile.readClient();
        for (User x : RegisterAccount.getAccountClientList()) {
            if ((x.getAccountName()).equals(accountName)) {
                user = x;
                return user;
            }
        }
        DataFile.readShop();
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
                if (tmp.size() == 0) {
                    userRemove.getBasket().remove(accountName);
                }
                return;
            }
        }
    }
    public void showBasket(User userShow){
        if(userShow.getBasket().size() == 0){
            System.out.println("Basket is empty");
            return;
        }
        for(Map.Entry<String, List<Product>> map : userShow.getBasket().entrySet()){
            System.out.println(map.getKey() + ": ");
            for (Product product : map.getValue()){
                System.out.println("         " + product);
            }
        }
    }
    public void pay(Product product, int amount, User userBuy, User userSell) {
        userBuy.getPaymentMethod().pay(product, amount, userBuy, userSell);
    }

    public void addMonneyToAccount(User user, double monney){
            if(user.getAddMoneyMethod() == null){
                System.out.println("Chose Add Method Please");
            } else{
                user.getAddMoneyMethod().add(user, monney);
            }
    }


}