package Model;

import java.io.Serializable;
import java.util.List;

public class PayByAccount implements PaymentMethod, Serializable {


    public PayByAccount() {

    }

    @Override
    public void pay(Product product, int amount, User userBuy,User userSell) {
        if(userBuy.getAccount() < product.getPrice() * amount){
            System.out.println("Your Account is not Enough Monney");
            return;
        }
        userBuy.setAccount(userBuy.getAccount() - product.getPrice()* amount);
        userSell.setAccount(userSell.getAccount() + product.getPrice()* amount);
        ((Shop) userSell).setRevenue(((Shop) userSell).getRevenue() + product.getPrice()* amount);
        int id1 = product.getId();
        product.setAmount(product.getAmount() - amount);
        if(product.getAmount() == 0){
            for(Product x : ((Shop) userSell).myProductList){
                if(product.getId() == x.getId()){
                    ((Shop) userSell).myProductList.remove(x);
                    break;
                }
            }
        }
        List<Product> tmp = userBuy.getBasket().get(userSell.getAccountName());
        if (tmp == null) {
            System.out.println("Payment success");
            return;
        }
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
