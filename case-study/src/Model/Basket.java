package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private Map<String, List<Product>> list = new HashMap<>();

    public Map<String, List<Product>> getList() {
        return list;
    }

    public void setList(Map<String, List<Product>> list) {
        this.list = list;
    }
}
