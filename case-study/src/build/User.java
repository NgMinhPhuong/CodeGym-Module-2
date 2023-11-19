package build;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class User implements Serializable {
    String userName;
    String accountName;
    String password;

    Map<String, File> mailList = new HashMap<>();
    public User(String userName, String accountName, String password) {
        this.userName = userName;
        this.accountName = accountName;
        this.password = password;
    }
    public void connectToAnUser(String accountName){
        System.out.println("Map this: ");
        for(Map.Entry<String, File> x : mailList.entrySet()){
            System.out.print(x.getKey() + " ");
        }
        System.out.println();
        User user = null;
        RegisterAccount.readData();
        for(User x : RegisterAccount.accountList){
            if((x.accountName).equals(accountName)){
                user = x;
                break;
            }
        }
        if(user == null){
            System.out.println("Account Name is not exists");
            return;
        }
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + this.userName
                + "_And_" + user.userName + ".txt";
        String path1 = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + user.userName
                + "_And_" + this.userName + ".txt";
        if(mailList.containsKey(path) || mailList.containsKey(path1)){
            System.out.println("You are connected");
            return;
        }
        String newPath = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + this.userName
                + "_And_" + user.userName + ".txt";
        File fileConnect = new File(path);
        try{
            fileConnect.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Connect To " + user.accountName + "(" + user.userName + ") Successfully");
        user.mailList.put(newPath, fileConnect);
        this.mailList.put(newPath, fileConnect);


    }

    public void sendMessageTo(String accountName, String message){
        User user = null;
        RegisterAccount.readData();
        for(User x : RegisterAccount.accountList){
            if((x.accountName).equals(accountName)){
                user = x;
                break;
            }
        }
        if(user == null){
            System.out.println("Account Name is not exists. Cannot send this massage");
            return;
        }
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + this.userName
                + "_And_" + user.userName + ".txt";
        String path1 = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + user.userName
                + "_And_" + this.userName + ".txt";
        if(mailList.containsKey(path)){
            try {
                FileWriter fr = new FileWriter(path, true);
                fr.write(this.userName + ": " + message + "\n");
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if(mailList.containsKey(path1)){
            try {
                FileWriter fr = new FileWriter(path1, true);
                fr.write(this.userName + ": " + message + "\n");
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else{
            System.out.println("Please Connect To " + user.accountName);
        }
    }
}
