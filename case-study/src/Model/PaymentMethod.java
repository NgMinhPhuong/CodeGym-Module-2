package Model;

public interface PaymentMethod {


    void pay(Product product, int amount, User userBuy,User userSell);
}
