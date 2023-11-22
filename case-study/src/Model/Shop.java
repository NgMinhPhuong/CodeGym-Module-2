package Model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class
Shop extends User implements Serializable {
    int cnt = 1;
    private double revenue = 0;
    List<Product> myProductList;

    ObjectOutputStream oos;
    ObjectInputStream ois;
    Shop(){
        super("","","");
        myProductList = new ArrayList<>();
    }

    public Shop(String userName, String accountName, String password){
        super(userName, accountName, password);
        myProductList = new ArrayList<>();
    }


    public void addProduct(String name, double price, int amount, String description){
        Product product = new Product(cnt++, name, price, amount, description);
        myProductList.add(product);
    }
    //------------------------------------------------
    public void removeProduct(int id){
        for(int i = 0; i < myProductList.size(); i++){
            if(id == myProductList.get(i).id){
                myProductList.remove(i);
                return;
            }
        }

    }
    //------------------------------------------------
    void setRevenue(double monney){
        this.revenue += monney;
    }

    public double getRevenue() {
        return revenue;
    }

    public void repairProduct(int id) {
        for(int i = 0; i < myProductList.size(); i++){
            if(id == myProductList.get(i).id){
                myProductList.remove(i);
                return;
            }
        }

    }

    public Product getProduct(int id){
        return myProductList.get(id);
    }

    public List<Product> getMyProductList(){
        return this.myProductList;
    }
    public void showProductList(){
        if(myProductList.size() == 0){
            System.out.println("You don't have any products yet");
            return;
        }
        for(Product x : myProductList) System.out.println(x);
        System.out.println();
    }
}
