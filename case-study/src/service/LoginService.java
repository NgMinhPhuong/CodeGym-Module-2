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
                    System.out.println("You entered it wrongly 3 time. Your account has been locked");
                    return null;
                }
                System.out.println("You entered it wrongly " + cnt + " time");
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
                    System.out.println("Enter Wrongly Password");
                    System.out.println("You entered it wrongly 3 time. Your account has been locked");
                    return null;
                }
                System.out.println("Enter Wrongly Password");
                System.out.println("You entered it wrongly " + cnt + " time");
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
