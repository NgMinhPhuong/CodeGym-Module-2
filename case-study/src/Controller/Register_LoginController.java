package Controller;

import Model.Client;
import final_REGEX.Const;
import service.Register_LoginService;
import untils.DataFile;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Register_LoginController {
    private static Register_LoginController instance;
    private Register_LoginController(){

    }
    public static Register_LoginController getInstance(){
        if(instance == null){
            instance = new Register_LoginController();
        }
        return instance;
    }

    //--------------------------------------------------------------

    public User login(String accountName, String password) {
        List<String[]> blockList = DataFile.getInstance().readBlockAccount();
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
                        DataFile.getInstance().writeBlockAccount(blockList);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                }
                System.out.println("Account: " + accountName + " is locked until " + blockList.get(i)[1]);
                return null;
            }
        }

        User user = Register_LoginService.getInstance().login(accountName, password);
        if(user instanceof Client) {
            System.out.println("Login successfully. Welcome My Client " + user.getUserName());
            user.setCntBlock(0);
            DataFile.getInstance().writeClient();
            DataFile.getInstance().writeShop();
            return user;
        }
        if(user instanceof Shop) {
            System.out.println("Login successfully. Welcome My Shop " + user.getUserName());
            user.setCntBlock(0);
            DataFile.getInstance().writeClient();
            DataFile.getInstance().writeShop();
            return user;
        }
        DataFile.getInstance().writeClient();
        DataFile.getInstance().writeShop();
        return null;
    }

    //------------------------------------------------------------------------------

    public  void resigter(String userName, String accountName, String password, String type){
        if(!type.equals("Shop") && !type.equals("Client")){
            System.out.println("Type must be 'Shop' or 'Client'");
            return;
        }
        if(accountName.length() > 15 || !accountName.matches(Const.getInstance().REGEX_ACCOUNT_NAME))
        {
            System.out.println("The Account Name must contain letters and numbers and no more than 15 characters");
            return;
        }

        if(!password.matches(Const.getInstance().REGEX_PASSWORD)){
            System.out.println("Password can not be blank");
            return;
        }

        for(User user : RegisterAccount.getAccountShopList()){
            if((user.getAccountName()).equals(accountName)){
                System.out.println("Account Name already exists");
                return;
            }
        }

        for(User user : RegisterAccount.getAccountClientList()){
            if((user.getAccountName()).equals(accountName)){
                System.out.println("Account Name already exists");
                return;
            }
        }

        if(type.equals("Shop")){
            Register_LoginService.getInstance().resigter(new Shop(userName, accountName, password));
            DataFile.getInstance().writeShop();
        } else{
            Register_LoginService.getInstance().resigter(new Client(userName, accountName, password));
            DataFile.getInstance().writeClient();
        }
        System.out.println("Resigter successfully");
    }
}
