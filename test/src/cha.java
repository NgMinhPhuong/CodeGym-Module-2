import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class cha  {
    public static void main(String[] args) {
        Map<String, Integer> mp = new HashMap<>();
        mp.put("ph", 1);
        mp.put("pa", 2);
        mp.put("pb", 3);
        mp.put("pp", 5);


        Set<String> s = new HashSet<>();
        s = mp.keySet();
        s.remove("pp");
        for(Map.Entry<String, Integer> x : mp.entrySet()){
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
}
