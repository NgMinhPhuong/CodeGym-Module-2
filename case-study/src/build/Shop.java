package build;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Shop extends User implements Serializable {

    private double revenue = 0;
    List<Product> myProductList;
    Shop shop;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Shop(){
        super("","","");
        myProductList = new ArrayList<>();
    }

    Shop(String userName, String accountName, String password){
        super(userName, accountName, password);
        myProductList = new ArrayList<>();
    }

    void writeData(){
        RegisterAccount.writeData1();
    }
    void readData(){
                RegisterAccount.readData();
                for(User user : RegisterAccount.accountList){
                    if(this.accountName.equals(user.accountName)){
                        shop = ((Shop) user);
                        break;
                    }
        }

    }
    public void addProduct(String name, double price, String description, int amount){
        Product product = new Product(name, price, description, amount);
        readData();//
        shop.myProductList.add(product);
        System.out.println("Add successfully");
        writeData();
    }
    //------------------------------------------------
    public void removeProduct(int id, int amount){
        readData();
        Product product = shop.myProductList.get(id);
        product.amount -= amount;
            if (product.amount == 0) {
                myProductList.remove(id);fdsfsd
            }
            writeData();
            Product.cnt--;
    }
    //------------------------------------------------
    void setRevenue(double monney){
        this.revenue += monney;
    }

    public double getRevenue() {
        return revenue;
    }

    public void repairProduct(int id, Product product) {
        readData();
        myProductList.set(id, product);
        writeData();
    }

    public Product getProduct(int id){
        readData();
        return myProductList.get(id);
    }

    public List<Product> getMyProductList(){
        readData();
        return this.myProductList;
    }
    public void showProductList(){
        readData();
        for(Product x : myProductList) System.out.println(x);
        System.out.println();
    }
}
