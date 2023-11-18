package build;

public class PayByCard implements PaymentMethod {

    @Override
    public void pay(Client client, Product product, int amount) {
        if (client.bankCard < product.price * amount) {
            System.out.println("Not enought Monney");
        } else if (amount > product.amount) {
            System.out.println("Not Enough Goods, Only " + product.amount + " Of Them");
        } else {
            client.bankCard -= product.price;
            Admin.setRevenue(product.price);
            (new Admin()).removeProduct(product.id, amount);
        }
    }
}
