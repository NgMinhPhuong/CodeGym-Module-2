import java.io.File;

public class test {
    public static void main(String[] args) {
        Admin admin1 = new Admin();
        admin1.addProduct(new Product("quần jean", 5, "Quần xịn", 4));
        admin1.addProduct(new Product("áo xách nách", 3, "Áo xịn", 2));
        Client An = new Client("hậu");
        An.setPaymentMethod(new PayByCard());
        An.pay(admin1.getProduct(0), 5);
        admin1.showProductList();


    }
}

