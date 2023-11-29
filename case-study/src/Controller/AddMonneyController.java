package Controller;

import Model.AddByBank;
import Model.AddByPhoneCard;
import Model.User;
import service.AddMonneyService;
import untils.DataAccount;
import untils.DataProduct;

public class AddMonneyController {
    private static AddMonneyController instance;
     private AddMonneyController(){

     }

    public static AddMonneyController getInstance() {
        if(instance == null){
            instance = new AddMonneyController();
        }
        return instance;
    }
    public void setAddMoneyMethod(String type, User user){
        if (type.equals("Bank")) {
            user.setAddMoneyMethod(new AddByBank());
            System.out.println("Selected !");
            DataAccount.getInstance().writeShop();
            DataAccount.getInstance().writeClient();
            DataProduct.getInstance().writeProduct();
            return;
        } else if (type.equals("PhoneCard")) {
            user.setAddMoneyMethod(new AddByPhoneCard());
            System.out.println("Selected !");
            DataAccount.getInstance().writeShop();
            DataAccount.getInstance().writeClient();
            DataProduct.getInstance().writeProduct();
            return;
        }
        System.out.println("Type is Wrong. Type must be ('Bank' or 'PhoneCard')");
    }

    public void addMonneyToAccount(double monney, User user){
        if(user.getAddMoneyMethod() == null){
            System.out.println("Please Choose a Method to Add Monney");
            return;
        }
        if(user.getAddMoneyMethod() instanceof AddByBank) {
            if (monney > user.getBankCard()) {
                System.out.println("Your BankAccount is not enough monney");
                return;
            }
        }
        AddMonneyService.getInstance().addMonneyToAccount(user, monney);
        System.out.println("Add successfully");
        DataAccount.getInstance().writeShop();
        DataAccount.getInstance().writeClient();
        DataProduct.getInstance().writeProduct();
    }
}
