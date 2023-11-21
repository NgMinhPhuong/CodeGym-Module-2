package Model;

public class AddByPhoneCard implements AddMoneyMethod {
    @Override
    public void add(User user, double monney) {
        System.out.println("Add With PhoneCard");
        user.account += (monney * 80/100);
    }
}
