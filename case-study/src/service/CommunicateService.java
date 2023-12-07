package service;

import Model.RegisterAccount;
import Model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CommunicateService {
    private static CommunicateService instance;
    private CommunicateService(){

    }

    public static CommunicateService getInstance() {
        if(instance == null){
            instance = new CommunicateService();
        }
        return instance;
    }


    //--------------------------------------
    public void connectToAnUser(User user1, User user2) {
            String newPath = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + user1.getUserName()
                    + "_And_" + user2.getUserName() + ".txt";
            File fileConnect = new File(newPath);

            try {
                fileConnect.createNewFile();
                System.out.println("Connect To " + user2.getAccountName() + "(" + user2.getUserName() + ") Successfully");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    //----------------------------------------
    public void sendMessageTo(User user1, User user2, String message, String path) {
            try {
                FileWriter fr = new FileWriter(path, true);
                fr.write(user1.getUserName() + ": " + message + "\n");
                fr.close();
                System.out.println("Sent!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    //----------------------------------------------
    public void readMail(User user1, String path) {
        System.out.println();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String str;
            while ((str = br.readLine()) != null) {
                String s = "";
                for (int i = 0; i < str.length(); i++) {
                    s += str.charAt(i);
                    if (s.equals(user1.getUserName())) {
                        System.out.print("                           " + "\u001B[31m");
                        break;
                    }
                    System.out.print("\u001B[32m");
                }
                System.out.println(str + "\u001B[0m");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
