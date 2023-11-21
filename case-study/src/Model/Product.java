package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    int id;
    String name;
    int amount;
    double price;
    String description;
    public static List<Product> productList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Product(int id, String name, double price, int amount, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.amount = amount;
        DataFile.readData();
        productList.add(this);
        DataFile.writeData();
    }

    public String toString(){
        return "ID: " + id + ", NAME: " + name + ", Price: " + price + ", AMOUNT: " + amount + " DESCRIPTION: " + description + "\n";
    }
}
