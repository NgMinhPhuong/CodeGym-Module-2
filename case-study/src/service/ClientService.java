package service;

public class ClientService {
    private static ClientService instance;
    private ClientService(){

    }

    public static ClientService getInstance() {
        if (instance == null){
            instance = new ClientService();
        }
        return instance;
    }

}
