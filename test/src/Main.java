import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main{

    public static void main(String[] args) {

        String s = "1-2-2000";
        String s1 = "22/2/2000";
        String s2 = "abcdef";
        String pattern = "\\d{1,2}[/-]\\d{1,2}[/-]\\d{4}";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(s2);
        System.out.println(matcher.matches());
        System.out.println(s.matches(pattern));
        System.out.println(s1.matches(pattern));
        System.out.println(s2.matches(pattern));
        System.out.println(s2.replace("a", "aaa"));
    }
}