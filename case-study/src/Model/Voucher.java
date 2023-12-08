package Model;

import java.io.Serializable;

public class Voucher implements Serializable {
    private int id;
    private double price;
    private static int cnt = 1;

    public Voucher(double price) {
        this.id = cnt++;
        this.price = price;
    }
    public Voucher(){}

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "ID: " + id + ", Price: " + price;
    }
}
