package build;

public class PayByCard implements PaymentMethod {

    @Override
    public void pay(Client client, Product product, int amount, Shop shop) {
        if (client.bankCard < product.price * amount) {
            System.out.println("Not enought Monney");
        } else if (amount > product.amount) {
            System.out.println("Not Enough Goods, Only " + product.amount + " Of Them");
        } else {
            client.bankCard -= product.price;
            shop.setRevenue(product.price);
            (new Shop()).removeProduct(product.id, amount);
        }
    }
}
