package Controller;

import Model.DataFile;
import Model.Product;
import Model.Shop;

public class ShopController {
    private static ShopController instance;
    private ShopController(){

    }

    public static ShopController getInstance() {
        if(instance == null){
            instance = new ShopController();
        }
        return instance;
    }

    public void addProductIntoStore(String name, double price, int amount, String description, Shop shop){
        shop.addProduct(name, price, amount, description);
        DataFile.writeShop();
        System.out.println("Add Successfully");
    }

    public void removeProductFromStore(int id, Shop shop){
        for(Product product : shop.getMyProductList()){
            if(id == product.getId()){
                shop.removeProduct(id);
                DataFile.writeShop();
                System.out.println("Remove successfully");
                return;
            }
        }
        System.out.println("In your Store has no this Id");
    }

    public void showMyProduct(Shop shop){
        shop.showProductList();
    }
}
