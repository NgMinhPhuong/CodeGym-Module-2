package build;

public interface PaymentMethod {


    void pay(Client client, Product product, int amount, Shop shop);
}
