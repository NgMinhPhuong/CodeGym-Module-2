package Model;

public class PayByAccount implements PaymentMethod {


    public PayByAccount() {

    }

    @Override
    public void pay(User user, Product product, int amount, Shop shop) {
        if (user.account < product.price * amount) {
            System.out.println("Not enought Monney");
        } else if (amount > product.amount) {
            System.out.println("Not Enough Goods, Only " + product.amount + " Of Them");
        } else {
            user.account -= product.price;
            shop.setRevenue(product.price);
            (new Shop()).removeProduct(product.id, amount);
        }
    }
}
