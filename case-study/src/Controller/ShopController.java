package Controller;

import service.ShopService;
import untils.DataAccount;
import Model.Product;
import Model.Shop;
import untils.DataProduct;

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
        ShopService.getInstance().addProduct(shop, name, price, amount, description);
        DataAccount.getInstance().writeShop();
        DataAccount.getInstance().writeClient();
        DataProduct.getInstance().writeProduct();
        System.out.println("Add Successfully");
    }

    public void removeProductFromStore(int id, Shop shop){
        for(Product product : shop.getMyProductList()){
            if(id == product.getId()){
                ShopService.getInstance().removeProduct(shop, id);
                DataAccount.getInstance().writeShop();
                DataAccount.getInstance().writeClient();
                DataProduct.getInstance().writeProduct();
                System.out.println("Remove successfully");
                return;
            }
        }
        System.out.println("In your Store has no this Id");
    }

}
