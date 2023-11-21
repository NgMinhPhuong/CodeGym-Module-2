package Controller;
import Model.Client;
import Model.DataFile;
import Model.Product;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;


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

}
