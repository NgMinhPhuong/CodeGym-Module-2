package Model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class
Shop extends User implements Serializable {
    private int cnt = 1;
    private double revenue = 0;
    List<Product> myProductList;

    Shop(){
        super("","","");
        myProductList = new ArrayList<>();
    }

    public Shop(String userName, String accountName, String password){
        super(userName, accountName, password);
        myProductList = new ArrayList<>();
    }
    //----------------------------------------------------


    public int getCnt() {
        return cnt;
    }

    public double getRevenue() {
        return revenue;
    }

    public List<Product> getMyProductList() {
        return myProductList;
    }
    //--------------------------------------

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public void setMyProductList(List<Product> myProductList) {
        this.myProductList = myProductList;
    }

    //----------------------------------------

}
