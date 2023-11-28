package Model;
import untils.DataFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class User implements Serializable {
    private String userName;
    private String accountName;
    private String password;
    private PaymentMethod paymentMethod;
    private AddMoneyMethod addMoneyMethod;
    private double account = 0;
    private double bankCard = 1000000;
    Basket basket;

    private List<String> transactionHistory = new ArrayList<>();

    private int cntBlock = 0;

    private String email;

    private String phoneNumber;

    private List<Voucher> voucherList = new ArrayList<>();
    //------------------------------------------------------
    public User(String userName, String accountName, String password) {
        this.userName = userName;
        this.accountName = accountName;
        this.password = password;
    }
    //----------------------------------------------------------
    public String getUserName() {
        return userName;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public AddMoneyMethod getAddMoneyMethod() {
        return addMoneyMethod;
    }

    public double getAccount() {
        return account;
    }

    public double getBankCard() {
        return bankCard;
    }

    public Basket getBasket() {
        return basket;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public int getCntBlock() {
        return cntBlock;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Voucher> getVoucherList() {
        return voucherList;
    }

    //------------------------------------------


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAddMoneyMethod(AddMoneyMethod addMoneyMethod) {
        this.addMoneyMethod = addMoneyMethod;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public void setBankCard(double bankCard) {
        this.bankCard = bankCard;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public void setTransactionHistory(List<String> transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void setCntBlock(int cntBlock) {
        this.cntBlock = cntBlock;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setVoucherList(List<Voucher> voucherList) {
        this.voucherList = voucherList;
    }

    //----------------------------------------------------------------------------------------------

}
