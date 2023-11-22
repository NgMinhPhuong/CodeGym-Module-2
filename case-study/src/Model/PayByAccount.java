package Model;

import java.io.Serializable;

public class PayByAccount implements PaymentMethod, Serializable {


    public PayByAccount() {

    }

    @Override
    public void pay(Product product, int amount, User userBuy,User userSell) {
        if(userBuy.account < product.price * amount){
            System.out.println("Your Account is not Enough Monney");
            return;
        }
        userBuy.account -= product.price * amount;
        userSell.account += product.price * amount;
        ((Shop) userSell).setRevenue(product.price * amount);
        int id1 = product.id;
        product.amount -= amount;
        if(product.amount == 0){
            for(Product x : ((Shop) userSell).myProductList){
                if(product.id == x.id){
                    ((Shop) userSell).myProductList.remove(x);
                    break;
                }
            }
        }
        for(Product x : userBuy.basket){
            if(x.id == id1){
                x.amount -= amount;
                if(x.amount == 0){
                    userBuy.basket.remove(x);
                }
                break;
            }
        }

        System.out.println("Payment success");
    }
}
