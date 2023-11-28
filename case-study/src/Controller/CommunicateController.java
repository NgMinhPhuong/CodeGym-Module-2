package Controller;

import Model.RegisterAccount;
import Model.User;
import service.CommunicateService;

import java.io.File;

public class CommunicateController {
    private static CommunicateController instance;
    private  CommunicateController(){

    }

    public static CommunicateController getInstance() {
        if(instance == null){
            instance = new CommunicateController();
        }
        return instance;
    }

    private User getUserByAccountName(String accountName) {
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

    private String checkTruePath(User user1, User user2) {
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
        User user2 = getUserByAccountName(accountName);
        if (user2 == null) {
            System.out.println("Account Name is not exists");
            return;
        }
        String path = checkTruePath(user1, user2);
        if(path != null){
            System.out.println("You are connected");
        } else{
            CommunicateService.getInstance().connectToAnUser(user1, user2);
        }
    }

    //----------------------------------------
    public void sendMessageTo(User user1, String accountName, String message) {
        User user2 = getUserByAccountName(accountName);
        if (user2 == null) {
            System.out.println("Account Name is not exists. Cannot send this massage");
            return;
        }
        String path = checkTruePath(user1, user2);
        if (path == null) {
            System.out.println("Please Connect To " + user2.getAccountName());
        } else {
            CommunicateService.getInstance().sendMessageTo(user1, user2, message, path);
        }
    }

    //----------------------------------------------
    public void readMail(User user1, String accountName) {
        User user2 = getUserByAccountName(accountName);
        if (user2 == null) {
            System.out.println("Account is not exists");
            return;
        }
        String path = checkTruePath(user1, user2);
        if (path == null) {
            System.out.println("No MailBox with This Account");
        } else {
            CommunicateService.getInstance().readMail(user1, path);
        }
    }
}
