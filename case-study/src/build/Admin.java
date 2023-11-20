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

public class Admin extends User implements Serializable {

    private static double revenue = 0;
    private static List<Product> myProductList;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    Admin(){
        super("","","");
        myProductList = new ArrayList<>();
    }

    Admin(String userName, String accountName, String password){
        super(userName, accountName, password);
        myProductList = new ArrayList<>();
    }

    void writeData(){
        try{
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\ProductData.csv"));
            oos.writeObject(myProductList);
            oos.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    void readData(){
        File file = new File("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\ProductData.csv");
        if(file.length() != 0) {
            try {
                ois = new ObjectInputStream(new FileInputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\ProductData.csv"));
                myProductList = (List<Product>) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error Read ProductData.csv");
            }
        }

    }
    public void addProduct(String name, double price, String description, int amount){
        Product product = new Product(name, price, description, amount);
        readData();//
        myProductList.add(product);
        System.out.println("Add successfully");
        writeData();
    }
    public void removeProduct(int id, int amount){
        readData();
        Product a = myProductList.get(id);
        a.amount -= amount;
            if (a.amount == 0) {
                myProductList.remove(id);
                int count = 0;
                for (Product x : myProductList) x.id = count++;
            }
            writeData();
            Product.cnt--;
    }

    static void setRevenue(double monney){
        revenue += monney;
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
