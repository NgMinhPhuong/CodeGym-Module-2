import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main{

    public static void main(String[] args) {

        String s = "nguyenminhphuongaaaaa831@gmail.com";
        String s1 = "22/2/2000";
        String s2 = "(";
        String pattern = "\\(";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(s2);
        System.out.println(s.matches(pattern));
        System.out.println(s1.matches(pattern));
        System.out.println(s2.matches(pattern));
    }
}