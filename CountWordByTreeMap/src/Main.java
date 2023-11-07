import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> mp = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("The word need to count: ");
        String s = sc.nextLine();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') continue;;
            int newVal;
            if(mp.get(s.charAt(i)) == null){
                mp.put(s.charAt(i), 1);
            }else{
                mp.put(s.charAt(i),  mp.get(s.charAt(i)) + 1);
            }
        }

        for(Map.Entry<Character, Integer> x : mp.entrySet()){
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
}