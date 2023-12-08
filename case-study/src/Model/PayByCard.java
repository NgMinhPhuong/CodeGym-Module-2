package Model;

import java.io.Serializable;

public class PayByCard implements PaymentMethod, Serializable {

    @Override
    public void pay(Product product, int amount, User userBuy,User userSell) {
        System.out.println("Payment success");
        userBuy.setBankCard(userBuy.getBankCard() - product.getPrice()* amount);
        userSell.setBankCard(userSell.getBankCard() + product.getPrice()* amount);
        ((Shop) userSell).setRevenue(((Shop) userSell).getRevenue() + product.getPrice()* amount);
        product.setAmount(product.getAmount() - amount);
    }
}
