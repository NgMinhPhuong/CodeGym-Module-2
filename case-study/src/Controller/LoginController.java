package Controller;

import Model.Client;
import Model.Shop;
import Model.User;
import service.LoginService;
import untils.DataBlackList;
import untils.DataAccount;
import untils.DataProduct;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LoginController {
    private static LoginController instance;
    private LoginController(){

    }

    public static LoginController getInstance() {
        if(instance == null){
            instance = new LoginController();
        }
        return instance;
    }

    public User login(String accountName, String password) {
        List<String[]> blockList = DataBlackList.getInstance().readBlockAccount();
        LocalDateTime localDateTimeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime blockTime;
        for(int i = 0; i < blockList.size(); i++){
            if(blockList.get(i)[0].equals(accountName)){
                blockTime = LocalDateTime.parse(blockList.get(i)[1], formatter);
                int time = localDateTimeNow.compareTo(blockTime);
                if(time > 0){
                    blockList.remove(i);
                    try{
                        DataBlackList.getInstance().writeBlockAccount(blockList);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                }
                System.out.println("Account: " + accountName + " is locked until " + blockList.get(i)[1]);
                return null;
            }
        }

        User user = LoginService.getInstance().login(accountName, password);
        if(user instanceof Client) {
            System.out.println("Login successfully. Welcome My Client " + user.getUserName());
            user.setCntBlock(0);
            DataAccount.getInstance().writeClient();
            DataAccount.getInstance().writeShop();
            DataProduct.getInstance().writeProduct();
            return user;
        }
        if(user instanceof Shop) {
            System.out.println("Login successfully. Welcome My Shop " + user.getUserName());
            user.setCntBlock(0);
            DataAccount.getInstance().writeClient();
            DataAccount.getInstance().writeShop();
            DataProduct.getInstance().writeProduct();
            return user;
        }
        DataAccount.getInstance().writeClient();
        DataAccount.getInstance().writeShop();
        DataProduct.getInstance().writeProduct();
        return null;
    }
}
