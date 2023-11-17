public class PayByAccount implements PaymentMethod {


    public PayByAccount() {

    }

    @Override
    public void pay(Client client, Product product, int amount) {
        if (client.account < product.price * amount) {
            System.out.println("Not enought Monney");
        } else if (amount > product.amount) {
            System.out.println("Not Enough Goods, Only " + product.amount + " Of Them");
        } else {
            client.account -= product.price;
            Admin.setRevenue(product.price);
            (new Admin()).removeProduct(product.id, amount);
        }
    }
}
