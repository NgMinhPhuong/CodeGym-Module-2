package Controller;

import Model.PayByAccount;
import Model.PayByCard;
import Model.Product;
import Model.RegisterAccount;
import Model.Shop;
import Model.User;
import service.PaymentService;
import untils.DataAccount;
import untils.DataProduct;

public class PaymentController {
    private static PaymentController instance;
    private PaymentController(){

    }

    public static PaymentController getInstance() {
        if(instance == null){
            instance = new PaymentController();
        }
        return instance;
    }
    public void setPaymentMethod(String type, User user){
        if (type.equals("Bank")) {
            user.setPaymentMethod(new PayByCard());
            System.out.println("Selected !");
            DataAccount.getInstance().writeShop();
            DataAccount.getInstance().writeClient();
            DataProduct.getInstance().writeProduct();

            return;
        } else if (type.equals("Account")) {
            user.setPaymentMethod(new PayByAccount());
            System.out.println("Selected !");
            DataAccount.getInstance().writeShop();
            DataAccount.getInstance().writeClient();
            DataProduct.getInstance().writeProduct();
            return;
        }
        System.out.println("Type is Wrong. Type must be ('Bank' or 'Account')");
    }

    public void pay(int id, int amount, String accountName, User userBuy, int idVoucher) {
        if (userBuy.getPaymentMethod() == null) {
            System.out.println("Chose a PaymentMethod please");
            return;
        }
        Product product = null;
        for (User user : RegisterAccount.getAccountShopList()) {
            for (Product x : ((Shop) user).getMyProductList()) {
                if (x.getId() == id) {
                    product = x;
                    break;
                }
            }
        }
        if (product == null) {
            System.out.println("Id is not Exists");
            return;
        }

        User userSell = null;
        for (User x : RegisterAccount.getAccountShopList()) {
            if (x.getAccountName().equals(accountName)) {
                userSell = x;
                break;
            }
        }
        if (userSell == null) {
            System.out.println("This store is not available");
            return;
        }

        if (amount > product.getAmount()) {
            System.out.println("We only have " + product.getAmount() + " of them");
            return;
        }

        if(userBuy.getAccount() < product.getPrice() * amount && userBuy.getPaymentMethod() instanceof PayByAccount){
            System.out.println("Your Account is not Enough Monney");
            return;
        }

        if(userBuy.getBankCard() < product.getPrice() * amount&& userBuy.getPaymentMethod() instanceof PayByCard){
            System.out.println("Your BankCard is not Enough Monney");
            return;
        }

        PaymentService.getInstance().pay(product, amount, userBuy, userSell, idVoucher);
        DataAccount.getInstance().writeClient();
        DataAccount.getInstance().writeShop();
        DataProduct.getInstance().writeProduct();

    }
}
