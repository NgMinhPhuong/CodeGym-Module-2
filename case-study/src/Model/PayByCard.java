package Model;

import java.io.Serializable;
import java.util.List;

public class PayByCard implements PaymentMethod, Serializable {

    @Override
    public void pay(Product product, int amount, User userBuy,User userSell) {
        if(userBuy.getBankCard() < product.getPrice() * amount){
            System.out.println("Your BankCard is not Enough Monney");
            return;
        }
        userBuy.setBankCard(userBuy.getBankCard() - product.getPrice()* amount);
        userSell.setBankCard(userSell.getBankCard() + product.getPrice()* amount);
        ((Shop) userSell).setRevenue(((Shop) userSell).getRevenue() + product.getPrice()* amount);
        product.setAmount(product.getAmount() - amount);
        int id1 = product.getId();
        if(product.getAmount() == 0){
            for(Product x : ((Shop) userSell).myProductList){
                if(product.getId() == x.getId()){
                    ((Shop) userSell).myProductList.remove(x);
                    break;
                }
            }
        }
        List<Product> tmp = userBuy.getBasket().get(userSell.getAccountName());
        if (tmp == null) return;
        for(Product x : tmp){
            if(x.getId() == id1){
                x.setAmount(x.getAmount() - amount);
                if(x.getAmount() == 0){
                    tmp.remove(x);
                    if(tmp.size() == 0) {
                        userBuy.getBasket().remove(userSell.getAccountName());
                    }
                    break;
                }
                break;
            }
        }

        System.out.println("Payment success");
    }
}
