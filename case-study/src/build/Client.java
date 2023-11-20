package build;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client extends User implements Serializable {
    boolean isLogin = false;
    AddMoneyMethod addMoneyMethod;
    PaymentMethod paymentMethod;
    double account = 0;
    double bankCard = 1000000;
    List<Product> basket = new ArrayList<>();
    Client(String userName, String accountName, String password){
        super(userName, accountName, password);
    }

    public void addIntoBasket(Product product){
        basket.add(product);
    }


    public void removeFromBasket(Product product){
        basket.remove(product);
    }

    public void setAddMoneyMethod(AddMoneyMethod addMoneyMethod){
        this.addMoneyMethod = addMoneyMethod;
    }
    public void addMonneyToAccount(double monney){
        if(addMoneyMethod == null){
            System.out.println("Chose Add Method Please");
        } else{
            addMoneyMethod.add(this, monney);
        }
    }

    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    public void pay(Product product, int amount, Shop shop){
        if(paymentMethod == null)  {
            System.out.println("Chose a PaymentMethod please");
            return;
        }
        paymentMethod.pay(this, product, amount, shop);
    }
    public void showBasket(){
        for(Product x : basket) System.out.println(x);
        System.out.println();
    }



}
