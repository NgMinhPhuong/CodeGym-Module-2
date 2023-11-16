public class Main {
    public static void main(String[] args) {
        UserControler userControler  = new UserControler(new XMLStorage());
        User user = new User();
        userControler.store(user);
        userControler.setUserStorage(new MySQLStorage());
        userControler.store(user);
    }
}
