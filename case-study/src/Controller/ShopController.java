package Controller;

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
}
