package service;

import Model.Product;
import Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasketService {
    private static BasketService instance;

    private BasketService(){

    }
    public static BasketService getInstance() {
        if(instance == null){
            instance = new BasketService();
        }
        return instance;
    }
    public void addIntoBasket(User userAdd, Product product, String accountName) {
        if (userAdd.getBasket().getList().containsKey(accountName)) {
            List<Product> tmp = userAdd.getBasket().getList().get(accountName);
            tmp.add(product);
        } else {
            List<Product> tmp = new ArrayList<>();
            tmp.add(product);
            userAdd.getBasket().getList().put(accountName, tmp);
        }

    }


    public void removeFromBasket(User userRemove, int id, String accountName) {
        List<Product> tmp = userRemove.getBasket().getList().get(accountName);
        for (Product product : tmp) {
            if (product.getId() == id) {
                userRemove.getBasket().getList().get(accountName).remove(product);
                if (tmp.isEmpty()) {
                    userRemove.getBasket().getList().remove(accountName);
                }
                return;
            }
        }
    }
    public void showBasket(User userShow){
        if(userShow.getBasket().getList().isEmpty()){
            System.out.println("Basket is empty");
            return;
        }
        for(Map.Entry<String, List<Product>> map : userShow.getBasket().getList().entrySet()){
            System.out.println(map.getKey() + ": ");
            for (Product product : map.getValue()){
                System.out.println("         " + product);
            }
            System.out.println();
        }
    }
}
