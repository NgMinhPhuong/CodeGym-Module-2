import java.io.Serializable;

public class Product implements Serializable {
    static int cnt = -1;
    int id;
    String name;
    int amount;
    double price;
    String description;

    public Product(String name, double price, String description, int amount) {
        cnt++;
        id = cnt;
        this.name = name;
        this.price = price;
        this.description = description;
        this.amount = amount;
    }

    public String toString(){
        return "ID: " + id + ", NAME: " + name + ", Price: " + price + ", AMOUNT: " + amount + "\nDESCRIPTION: " + description;
    }
}
