public class AddByPhoneCard implements AddMoneyMethod {
    @Override
    public AddMoneyMethod add() {
        return new AddByPhoneCard();
    }
}
