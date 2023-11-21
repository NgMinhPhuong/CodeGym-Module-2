package Model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class User implements Serializable {
    String userName;
    String accountName;
    String password;
    PaymentMethod paymentMethod;
    AddMoneyMethod addMoneyMethod;
    double account = 0;
    double bankCard = 1000000;
    List<Product> basket = new ArrayList<>();
    //------------------------------------------
    public String getAccountName() {
        return accountName;
    }

    //------------------------------------------
    public User(String userName, String accountName, String password) {
        this.userName = userName;
        this.accountName = accountName;
        this.password = password;
    }

    public double getBankCard() {
        return bankCard;
    }

    public double getAccount() {
        return account;
    }

    //--------------------------------
    User checkExists(String accountName){
        User user = null;
        DataFile.readClient();
        for(User x : RegisterAccount.accountClientList){
            if((x.accountName).equals(accountName)){
                user = x;
                return user;
            }
        }
        DataFile.readShop();
        for(User x : RegisterAccount.accountShopList){
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
    public void setPaymentMethod(String type){
        if(type.equals("Bank")) {
            this.paymentMethod = new PayByCard();
        } else if(type.equals("Account")){
            this.paymentMethod = new PayByAccount();
            return;
        }
        System.out.println("Type is Wrong. Type must be ('Bank' or 'Account')");

    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void pay(Product product, int amount, User userSell){
        paymentMethod.pay(product, amount,this, userSell);
    }

    public void setAddMoneyMethod(String type){
        if(type.equals("PhoneCard")) {
            this.addMoneyMethod = new AddByPhoneCard();
        } else if(type.equals("Bank")){
            this.addMoneyMethod = new AddByBank();
        }
        System.out.println("Type is Wrong. Type must be ('Bank' or 'PhoneCard')");
    }

    public void addMonneyToAccount(double monney){
        if(addMoneyMethod == null){
            System.out.println("Chose Add Method Please");
        } else{
            addMoneyMethod.add(this, monney);
        }
    }
    public void addIntoBasket(Product product){
        basket.add(product);

    }


    public void removeFromBasket(int id) {
        for (Product product : basket) {
            if (product.id == id) {
                basket.remove(product);
                break;
            }
        }
        for (User user : RegisterAccount.accountClientList) {
            for (Product product : user.basket) {
                if (product.id == id) {
                    user.basket.remove(product);
                    return;
                }
            }
        }
    }

    public void showBasket(){
        DataFile.readShop();
        DataFile.readClient();
        for(Product x : basket){
            System.out.println(x);
        }
    }
}
