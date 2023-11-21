package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client extends User implements Serializable, Cloneable {

    List<Product> basket = new ArrayList<>();
    Client(String userName, String accountName, String password){
        super(userName, accountName, password);
    }

    public void addIntoBasket(Product product){
        basket.add(product);

    }


    public void removeFromBasket(int id){
        DataFile.readData();
        for(Product product : basket){
            if(product.id == id){
                basket.remove(product);
                break;
            }
        }
        for(User user : RegisterAccount.accountClientList){
            for(Product product : ((Client) user).basket){
                if(product.id == id){
                    ((Client) user).basket.remove(product);
                    return;
                }
            }
        }
    }




    public void showBasket(){
        DataFile.readData();
        for(Product x : basket){
            System.out.println(x);
        }
    }



}
