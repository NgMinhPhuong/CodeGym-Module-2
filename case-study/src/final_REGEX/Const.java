package final_REGEX;

public class Const {
    private static Const instance;
    public final String REGEX_ACCOUNT_NAME = "([a-z]){5,13}(\\d){2,5}";
    public final String REGEX_EMAIL = "([a-z]){6,20}(\\d){1,6}@gmail\\.com";
    public final String REGEX_PHONE_NUMBER = "([\\d]){10,11}";
    public final String REGEX_PASSWORD = "\\d+";
    private Const(){

    }

    public static Const getInstance() {
        if(instance == null){
            instance = new Const();
        }
        return instance;
    }
}
//---------------------------------------------------------------

