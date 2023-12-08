package service;

import Model.PayByAccount;
import Model.Product;
import Model.Shop;
import Model.User;
import Model.Voucher;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class PaymentService {
    private static PaymentService instance;
    private PaymentService(){

    }

    public static PaymentService getInstance() {
        if(instance == null){
            instance = new PaymentService();
        }
        return instance;
    }


    public void pay(Product product, int amount, User userBuy, User userSell, int idVoucher) {
        userBuy.getPaymentMethod().pay(product, amount, userBuy, userSell);
        int id = product.getId();
        if(product.getAmount() == 0){
            for(Product x : ((Shop) userSell).getMyProductList()){
                if(product.getId() == x.getId()){
                    ((Shop) userSell).getMyProductList().remove(x);
                    break;
                }
            }
        }

        LocalTime localTime = LocalTime.now().truncatedTo(java.time.temporal.ChronoUnit.SECONDS);
        LocalDate localDate = LocalDate.now();
        String buy = localDate + "   " + localTime.toString() + "   Bought " + amount + " " + product.getName() +
                "(ID: " + product.getId() + ") at the Shop with AccountName: " + userSell.getAccountName() + " (" + userSell.getUserName() + ")";
        String sell = localDate + "   " + localTime.toString() + "   Sold " + amount + " " + product.getName() +
                "(ID: " + product.getId() + ") to Account Name: " + userBuy.getAccountName() + " (" + userBuy.getUserName() + ")";

        userBuy.getTransactionHistory().add(buy);
        userSell.getTransactionHistory().add(sell);
        if(userBuy.getBasket().getList().size() != 0) {
            List<Product> tmp = userBuy.getBasket().getList().get(userSell.getAccountName());
            for (Product x : tmp) {
                if (x.getId() == id) {
                    x.setAmount(x.getAmount() - amount);
                    if (x.getAmount() == 0) {
                        tmp.remove(x);
                        if (tmp.isEmpty()) {
                            userBuy.getBasket().getList().remove(userSell.getAccountName());
                        }
                        break;
                    }
                    break;
                }
            }
        }


        for(Voucher voucher : userBuy.getVoucherList()){
            if(voucher.getId() == idVoucher){
                if(userBuy.getPaymentMethod() instanceof PayByAccount){
                    userBuy.setAccount(userBuy.getAccount() + voucher.getPrice());
                } else {
                    userBuy.setBankCard(userBuy.getBankCard() + voucher.getPrice());
                }
                userBuy.getVoucherList().remove(voucher);
                if(product.getPrice() * amount > 100000) {
                    userBuy.getVoucherList().add(new Voucher(product.getPrice() * amount * 0.05));
                    System.out.println("Received a Voucher");
                }
                return;
            }
        }
        if(product.getPrice() * amount > 100000) {
            userBuy.getVoucherList().add(new Voucher(product.getPrice() * amount * 0.05));
            System.out.println("Received a Voucher");
        }
    }
}
