package service;

import Model.User;
import Model.Voucher;

public class VoucherService {
    private static VoucherService instance;
    private VoucherService(){

    }

    public static VoucherService getInstance() {
        if(instance == null){
            instance = new VoucherService();
        }
        return instance;
    }

    public void showMyVoucher(User user){
        if (user.getVoucherList().isEmpty()){
            System.out.println("There is no Voucher");
            return;
        }
        for(Voucher voucher : user.getVoucherList()){
            System.out.println(voucher);
        }
    }
}
