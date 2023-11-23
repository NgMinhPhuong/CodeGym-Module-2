package Model;

import java.io.Serializable;

public class AddByBank implements AddMoneyMethod, Serializable {

    @Override
    public void add(User user, double monney) {
        user.setBankCard(user.getBankCard() - monney);
        user.setAccount(user.getAccount() + monney);
    }
}
