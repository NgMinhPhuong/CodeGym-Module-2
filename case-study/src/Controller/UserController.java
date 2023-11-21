package Controller;

import Model.DataFile;
import Model.Product;
import Model.Shop;
import Model.User;

public class UserController extends User{
    private static UserController instance;
    private UserController(){
        super("","","");

    }
    public static UserController getInstance(){
        if(instance == null){
            instance = new UserController();
        }
        return instance;
    }
    public void pay(int id, Shop shop){
        DataFile.readData();
        if(getInstance().getPaymentMethod() == null)  {
            System.out.println("Chose a PaymentMethod please");
            return;
        }
        for(Product product : Product.productList){
            if(product.getId() == id){
                client.addIntoBasket(product);
                return;
            }
        }
        System.out.println("Id is not exists");


    }
}
