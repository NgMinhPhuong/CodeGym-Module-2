package Model;

public class PayByCard implements PaymentMethod {

    @Override
    public void pay(Product product, int amount, User userBuy,User userSell) {
        if(userBuy.bankCard < product.price * amount){
            System.out.println("not Enough Monney");
            return;
        }
        userBuy.bankCard -= (product.price * amount);
        userSell.bankCard += (product.price * amount);
        ((Shop) userSell).setRevenue(product.price * amount);
        product.amount -= amount;
        int id1 = product.id;
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
