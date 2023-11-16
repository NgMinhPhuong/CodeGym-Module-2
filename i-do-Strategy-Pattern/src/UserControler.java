public class UserControler {
    UserStorage userStorage;
    UserControler(UserStorage userStorage){
        this.userStorage = userStorage;
    }

    public void setUserStorage(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public void store(User user){
        userStorage.store(user);
    }
}
