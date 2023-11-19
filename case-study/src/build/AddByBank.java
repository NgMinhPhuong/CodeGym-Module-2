package build;

public class AddByBank implements AddMoneyMethod {

    @Override
    public void add(Client client, double monney) {
        client.bankCard -= monney;
        client.account += monney;
    }
}
