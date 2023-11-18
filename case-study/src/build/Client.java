package build;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    Admin admin = new Admin();
    boolean isLogin = false;
    AddMoneyMethod addMoneyMethod;
    PaymentMethod paymentMethod;
    double account = 0;
    String userName;
    double bankCard = 1000000;
    String accountName;
    String password;
    List<Product> basket = new ArrayList<>();
    Client(String userName, String accountName, String password){
        this.userName = userName;
        this.accountName = accountName;
        this.password = password;
    }

    void addIntoBasket(Product product){
        basket.add(product);
    }


    void removeFromBasket(Product product){
        basket.remove(product);
    }

    void setAddMoneyMethod(AddMoneyMethod addMoneyMethod){
        this.addMoneyMethod = addMoneyMethod;
    }
    void addMonneyToAccount(double monney){
        if(addMoneyMethod == null){
            System.out.println("Chose Add Method Please");

        } else{
            if(addMoneyMethod.add() instanceof AddByPhoneCard){
                System.out.println("Add With PhoneCard");
                this.account += monney;
            } else{
                this.bankCard -= monney;
                this.account += monney;
            }
        }
    }

    void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    void pay(Product product, int amount){
        if(paymentMethod == null)  {
            System.out.println("Chose a PaymentMethod please");
            return;
        }
        paymentMethod.pay(this, product, amount);
    }
    void showBasket(){
        for(Product x : basket) System.out.println(x);
        System.out.println();
    }
    void connectToAdmin(Admin admin){
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File" + "MailBox" + this.userName
                + "_And_" + admin.name + "txt";
        File file = new File(path);
        try{
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    void sendMessageTo(Admin admin, String message){
        String path = "C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File" + "MailBox" + this.userName
                + "_And_" + admin.name + "txt";
        File file = new File(path);
        if(file.exists()){

        }else{

        }
    }
}
