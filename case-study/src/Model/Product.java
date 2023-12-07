package Model;

import java.io.Serializable;

public class Product implements Serializable, Cloneable {
    private int id;
    private String name;
    private int amount;
    private  double price;
    String description;
    public Product(Product another){
        this.id = another.id;
        this.name = another.name;
        this.price = another.price;
        this.description = another.description;
        this.amount = another.amount;
    }


    public Product(int id, String name, double price, int amount, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.amount = amount;

    }
    //---------------------------------

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
    //----------------------------------------

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //-------------------------------------------
    public String toString(){
        return "ID: " + id + ", NAME: " + name + ", Price: " + price + ", AMOUNT: " + amount + " DESCRIPTION: " + description + "\n";
    }
}
