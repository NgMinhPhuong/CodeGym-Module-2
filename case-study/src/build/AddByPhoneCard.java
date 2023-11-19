package build;

public class AddByPhoneCard implements AddMoneyMethod {
    @Override
    public void add(Client client, double monney) {
        System.out.println("Add With PhoneCard");
        client.account += monney;
    }
}
