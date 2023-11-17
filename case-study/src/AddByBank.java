public class AddByBank implements AddMoneyMethod {

    @Override
    public AddMoneyMethod add() {
        return new AddByBank();
    }
}
