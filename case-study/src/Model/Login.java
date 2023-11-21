package Model;

public class Login {
    public Login(){

    }

    public User login(String accountName, String password){
                DataFile.readData();
                for(User user : RegisterAccount.accountClientList) {
                    if ((user.accountName).equals(accountName) && (user.password).equals(password)) {
                        System.out.println("Login successfully. Welcome My Client " + user.userName);
                        return user;
                    }
                }
                for(User user : RegisterAccount.accountShopList) {
                    if ((user.accountName).equals(accountName) && (user.password).equals(password)) {
                        System.out.println("Login successfully. Welcome My Shop " + user.userName);
                        return user;
                    }
                }
        System.out.println("Wrong Account or Password. Please Enter Again!");
        return null;
    }
}
