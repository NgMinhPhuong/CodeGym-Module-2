package service;

import Model.User;

public class AddMonneyService {
    private static AddMonneyService instance;
    private  AddMonneyService(){

    }

    public static AddMonneyService getInstance() {
        if(instance == null){
            instance = new AddMonneyService();
        }
        return instance;
    }

    public void addMonneyToAccount(User user, double monney){
        user.getAddMoneyMethod().add(user, monney);
    }
}
