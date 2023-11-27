package Model;
import untils.DataFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class User implements Serializable {
    private String userName;
    private String accountName;
    private String password;
    private PaymentMethod paymentMethod;
    private AddMoneyMethod addMoneyMethod;
    private double account = 0;
    private double bankCard = 1000000;
    private Map<String, List<Product>> basket = new HashMap<>();

    private List<String> transactionHistory = new ArrayList<>();

    private int cntBlock = 0;

    private String email;

    private String phoneNumber;

    //------------------------------------------------------
    public User(String userName, String accountName, String password) {
        this.userName = userName;
        this.accountName = accountName;
        this.password = password;
    }
    //----------------------------------------------------------
    public String getUserName() {
        return userName;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public AddMoneyMethod getAddMoneyMethod() {
        return addMoneyMethod;
    }

    public double getAccount() {
        return account;
    }

    public double getBankCard() {
        return bankCard;
    }

    public Map<String, List<Product>> getBasket() {
        return basket;
    }


    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public int getCntBlock() {
        return cntBlock;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //------------------------------------------


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAddMoneyMethod(AddMoneyMethod addMoneyMethod) {
        this.addMoneyMethod = addMoneyMethod;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public void setBankCard(double bankCard) {
        this.bankCard = bankCard;
    }

    public void setBasket(Map<String, List<Product>> basket) {
        this.basket = basket;
    }


    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void setCntBlock(int cntBlock) {
        this.cntBlock = cntBlock;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //----------------------------------------------------------------------------------------------
    User checkExists(String accountName){
        User user = null;
        DataFile.getInstance().readClient();
        for(User x : RegisterAccount.getAccountClientList()){
            if((x.accountName).equals(accountName)){
                user = x;
                return user;
            }
        }
        DataFile.getInstance().readShop();
        for(User x : RegisterAccount.getAccountShopList()){
            if((x.accountName).equals(accountName)){
                user = x;
                return user;
            }
        }
        return user;
    }
    //------------------------------------
    public String  checkTruePath(User user){

        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + this.userName
                + "_And_" + user.userName + ".txt";
        String path1 = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + user.userName
                + "_And_" + this.userName + ".txt";

        if(new File(path).exists()){
            return path;
        } else if(new File(path1).exists()){
            return path1;
        } else{
            return null;
        }
    }
    //--------------------------------------

    //--------------------------------------
    public void connectToAnUser(String accountName){
        User user = checkExists(accountName);
        if(user == null){
            System.out.println("Account Name is not exists");
            return;
        }
        String path = checkTruePath(user);
            if(path == null){
                String newPath = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\" + "MailBox_" + this.userName
                        + "_And_" + user.userName + ".txt";
                File fileConnect = new File(newPath);

                try{
                    fileConnect.createNewFile();
                    System.out.println("Connect To " + user.accountName + "(" + user.userName + ") Successfully");
                    return;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            System.out.println("You are connected");

    }
    //----------------------------------------
    public void sendMessageTo(String accountName, String message){
        User user = checkExists(accountName);
        if(user == null){
            System.out.println("Account Name is not exists. Cannot send this massage");
            return;
        }
        String path = checkTruePath(user);
        if(path == null){
            System.out.println("Please Connect To " + user.accountName);
            return;
        } else {
            try {
                FileWriter fr = new FileWriter(path, true);
                fr.write(this.userName + ": " + message + "\n");
                fr.close();
                System.out.println("Sent!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //----------------------------------------------
    public void readMail(String accountName){
        User user = checkExists(accountName);
        if(user == null){
            System.out.println("Account is not exists");
            return;
        }
        String path = checkTruePath(user);
        if(path == null){
            System.out.println("No MailBox with This Account");
            return;
        }
        System.out.println();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String str;
            while((str = br.readLine()) != null){
                String s = "";
                for(int i = 0; i < str.length(); i++){
                    s += str.charAt(i);
                    if(s.equals(this.userName)){
                        System.out.print("                           ");
                        break;
                    }
                }
                System.out.println(str);
            }
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
