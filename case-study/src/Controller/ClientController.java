package Controller;

import Model.Client;
import Model.DataFile;
import Model.Product;
import Model.RegisterAccount;
import Model.User;

import java.util.List;

public class ClientController {
    private static ClientController instance;
    private ClientController(){

    }

    public static ClientController getInstance(){
        if(instance == null){
            instance = new ClientController();
        }
        return instance;
    }
    public void addIntoBasket(int id, Client client){
        DataFile.readData();
        for(Product product : Product.productList){
            if(product.getId() == id){
                client.addIntoBasket(product);
                DataFile.writeData();
                return;
            }
        }
        System.out.println("Id is not exists");

    }
    public void removeFromBasket(int id, Client client){
        DataFile.readData();
        for(Product product : Product.productList){
            if(product.getId() == id){
                client.removeFromBasket(id);
                DataFile.writeData();
                return;
            }
        }
        System.out.println("Id is not exists");
    }
}
