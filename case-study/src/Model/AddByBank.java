package Model;

public class AddByBank implements AddMoneyMethod {

    @Override
    public void add(User user, double monney) {
        user.bankCard -= monney;
        user.account += monney;
    }
}
