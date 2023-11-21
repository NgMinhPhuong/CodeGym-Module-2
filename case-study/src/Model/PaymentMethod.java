package Model;

public interface PaymentMethod {


    void pay(User user, Product product, int amount, Shop shop);
}
