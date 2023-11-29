package Controller;

import Model.Product;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;
import service.BasketService;
import untils.DataAccount;
import untils.DataProduct;

import java.util.List;
import java.util.Map;

public class BasketController {
    private static BasketController instance;
    private BasketController(){

    }

    public static BasketController getInstance() {
        if(instance == null){
            instance = new BasketController();
        }
        return instance;
    }

    public void addIntoBasket(int id, User userAdd, String accountName) {
        User userSell = null;
        for (User user : RegisterAccount.getAccountShopList()) {
            if (user.getAccountName().equals(accountName)) {
                userSell = user;
                break;
            }
        }

        if (userSell == null) {
            System.out.println("This store is not available");
            return;
        }
        for (Product product : ((Shop) userSell).getMyProductList()) {
            if (id == product.getId()) {
                product = new Product(product);
                BasketService.getInstance().addIntoBasket(userAdd ,product, accountName);
                System.out.println("Add successfully");
                DataAccount.getInstance().writeClient();
                DataAccount.getInstance().writeShop();
                DataProduct.getInstance().writeProduct();
                return;
            }
        }
        System.out.println("Id is not exists");

    }

    //------------------------------------------------------------------

    public void removeFromBasket(int id, User userRemove, String accountName) {
        User userSell = null;
        for (User user : RegisterAccount.getAccountShopList()) {
            if (user.getAccountName().equals(accountName)) {
                userSell = user;
                break;
            }
        }

        if (userSell == null) {
            System.out.println("This store is not available");
            return;
        }

        for (Map.Entry<String, List<Product>> map : userRemove.getBasket().getList().entrySet()){
            for(Product product : map.getValue()){
                if(product.getId() == id){
                    BasketService.getInstance().removeFromBasket(userRemove, id, accountName);
                    System.out.println("Remove from your Basket successfully");
                    DataAccount.getInstance().writeClient();
                    DataAccount.getInstance().writeShop();
                    DataProduct.getInstance().writeProduct();
                    return;
                }
            }
        }
        System.out.println("There is no this Id in your Basket");
    }
}
