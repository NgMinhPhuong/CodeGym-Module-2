package Controller;


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
