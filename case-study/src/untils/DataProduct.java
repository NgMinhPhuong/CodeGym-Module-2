package untils;

import Model.Product;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class DataProduct {
    private static DataProduct instance;
    private DataProduct(){

    }

    public static DataProduct getInstance() {
        if(instance == null){
            instance = new DataProduct();
        }
        return instance;
    }

    public void writeProduct(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\my_File\\Product.csv"))){
            for (User user : RegisterAccount.getAccountShopList()){
                for (Product product : ((Shop) user).getMyProductList()){
                    bufferedWriter.write(user.getAccountName() + ",");
                    bufferedWriter.write(product.getId() + ",");
                    bufferedWriter.write(product.getName() + ",");
                    bufferedWriter.write(product.getPrice() + ",");
                    bufferedWriter.write(product.getAmount() + ",");
                    bufferedWriter.write(product.getDescription() + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
