package Model;

import java.io.Serializable;

public class PayByAccount implements PaymentMethod, Serializable {


    public PayByAccount() {

    }

    @Override
    public void pay(Product product, int amount, User userBuy,User userSell) {
        System.out.println("Payment success");
        userBuy.setAccount(userBuy.getAccount() - product.getPrice()* amount);
        userSell.setAccount(userSell.getAccount() + product.getPrice()* amount);
        ((Shop) userSell).setRevenue(((Shop) userSell).getRevenue() + product.getPrice()* amount);
        product.setAmount(product.getAmount() - amount);

    }
}
