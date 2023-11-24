package service;

import Model.Product;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;


public class ShopService {
    private static ShopService instance;
    private ShopService(){

    }

    public static ShopService getInstance() {
        if (instance == null){
            instance = new ShopService();
        }
        return instance;
    }

    public void addProduct(Shop shop, String name, double price, int amount, String description){
        Product product = new Product(shop.getCnt(), name, price, amount, description);
        shop.setCnt(shop.getCnt() + 1);
        shop.getMyProductList().add(product);
    }
    //------------------------------------------------
    public void removeProduct(Shop shop, int id){
        for(int i = 0; i < shop.getMyProductList().size(); i++){
            if(id == shop.getMyProductList().get(i).getId()){
                shop.getMyProductList().remove(i);
                return;
            }
        }

    }
    //------------------------------------------------

    public void showProductList(Shop shop){
        if(shop.getMyProductList().size() == 0){
            System.out.println("You don't have any products yet");
            return;
        }
        for(Product x : shop.getMyProductList()) System.out.println(x);
        System.out.println();
    }

    public Product checkIdExists(int id){
        for (User user : RegisterAccount.getAccountShopList()) {
            for (Product x : ((Shop) user).getMyProductList()) {
                if (x.getId() == id) {
                    return x;
                }
            }
        }
        return null;
    }
}
