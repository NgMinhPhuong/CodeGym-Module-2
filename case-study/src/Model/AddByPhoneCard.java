package Model;

import java.io.Serializable;

public class AddByPhoneCard implements AddMoneyMethod, Serializable {
    @Override
    public void add(User user, double monney) {
        System.out.println("Add With PhoneCard");
        user.setAccount(user.getAccount() + (monney * 80/100));
    }
}
