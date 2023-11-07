import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ProductManager implements Comparator<Product> {
    private ArrayList<Product> listProduct = new ArrayList<>();
    void addProduct(Product item){
        listProduct.add(item);
    }

    void repairProduct(int index, Product newVal){
        listProduct.set(index, newVal);
    }

    void remove(int index){
        listProduct.remove(index);
    }

    void display(){
        for(int i = 0; i < listProduct.size(); i++){
            System.out.print(listProduct.get(i).name + " ");
        }
        System.out.println();
    }

    boolean indexOf(Object o){
        for(int i = 0; i < listProduct.size(); i++){
            if(listProduct.get(i).name == o) return true;
        }
        return false;
    }


    void sortt(){
        Collections.sort(listProduct, new ProductManager());
    }


    public static void main(String[] args) {
        ProductManager a = new ProductManager();
        a.addProduct(new Product("a"));
        a.addProduct(new Product("d"));
        a.addProduct(new Product("b"));
        a.sortt();
        a.display();
        System.out.println(a.indexOf("a"));
    }


    @Override
    public int compare(Product o1, Product o2) {
        return o2.name.compareTo(o1.name);
    }
}
