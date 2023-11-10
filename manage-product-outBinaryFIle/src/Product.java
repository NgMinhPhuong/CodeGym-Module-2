import java.io.Serializable;

public class Product implements Serializable {
    String name;
    int ma;
    double price;
    String hangSX;
    String describe;

    public Product(String name, int ma, double price, String hangSX, String describe) {
        this.name = name;
        this.ma = ma;
        this.price = price;
        this.hangSX = hangSX;
        this.describe = describe;
    }

    public  String toString(){
        return "[Mã: " + ma + ", Name: " + name + ", Giá: "
                + price + ", Hãng SX: " + hangSX + ", Mô tả: " + describe + "]";
    }

    public static void main(String[] args) {
        Product a = new Product("phương",4,2,"ds","des");
        Product b = new Product("Phú bcs",4,2,"ds","des");
        Product c = new Product("Phú shit",4,2,"ds","des");
        System.out.println(a);
    }
}
