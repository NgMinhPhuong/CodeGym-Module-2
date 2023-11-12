import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassRoom {


    public static final String REGEX = "^[CAP][0-9]{4}[GHIK]";
    static boolean check(String s){
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }

}
