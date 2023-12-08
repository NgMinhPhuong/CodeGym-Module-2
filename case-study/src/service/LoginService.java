package service;

import Model.RegisterAccount;
import Model.User;
import untils.DataBlackList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LoginService {
    private static LoginService instance;
    private LoginService(){

    }

    public static LoginService getInstance() {
        if(instance == null){
            instance = new LoginService();
        }
        return instance;
    }

    public User login(String accountName, String password){
        for (User user : RegisterAccount.getAccountClientList()) {
            if ((user.getAccountName()).equals(accountName) && !(user.getPassword()).equals(password)) {
                int cnt = user.getCntBlock() + 1;
                user.setCntBlock(cnt);
                if(cnt == 3){
                    user.setCntBlock(0);
                    try{
                        List<String[]> blockList = DataBlackList.getInstance().readBlockAccount();
                        LocalDateTime localDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        String [] ss = {accountName, localDateTime.plusSeconds(30).format(formatter)};
                        blockList.add(ss);
                        DataBlackList.getInstance().writeBlockAccount(blockList);
                    } catch (Exception e){
                        e.printStackTrace();
                        //System.out.println("Please Close File. You are opening it");
                    }
                    System.out.println("\u001B[31m" + "Enter Wrongly Password" + "\u001B[0m");
                    System.out.println("\u001B[31m" + "You entered it wrongly 3 time. Your account has been locked" + "\u001B[0m");
                    return null;
                }
                System.out.println("\u001B[31m" + "Enter Wrongly Password" + "\u001B[0m");
                System.out.println("\u001B[31m" +"You entered it wrongly " + cnt + " time" + "\u001B[0m");
                return null;
            }
            if ((user.getAccountName()).equals(accountName) && (user.getPassword()).equals(password)) {
                return user;
            }
        }
        for (User user : RegisterAccount.getAccountShopList()) {
            if ((user.getAccountName()).equals(accountName) && !(user.getPassword()).equals(password)) {
                int cnt = user.getCntBlock() + 1;
                user.setCntBlock(cnt);
                if(cnt == 3){
                    user.setCntBlock(0);
                    try{
                        List<String[]> blockList = DataBlackList.getInstance().readBlockAccount();
                        LocalDateTime localDateTime = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                        String [] ss = {accountName,localDateTime.plusHours(12).format(formatter)};
                        blockList.add(ss);
                        DataBlackList.getInstance().writeBlockAccount(blockList);
                    } catch (Exception e){
                        e.printStackTrace();
                        //System.out.println("Please Close File. You are opening it");
                    }
                    System.out.println("\u001B[31m" + "Enter Wrongly Password" + "\u001B[0m");
                    System.out.println("\u001B[31m" + "You entered it wrongly 3 time. Your account has been locked" + "\u001B[0m");
                    return null;
                }
                System.out.println("\u001B[31m" + "Enter Wrongly Password" + "\u001B[0m");
                System.out.println("\u001B[31m" + "You entered it wrongly " + cnt + " time" + "\u001B[0m");
                return null;
            }
            if ((user.getAccountName()).equals(accountName) && (user.getPassword()).equals(password)) {
                return user;
            }
        }
        System.out.println("Account Name is not exists");
        return null;
    }
}
