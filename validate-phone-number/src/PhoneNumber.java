import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    public static final String REGEX = "^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)";
    public static boolean check(String s){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
