import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Manager {
    ArrayList<Product> listProduct = new ArrayList<>();
    void addToFList(Product p) throws IOException {
        listProduct.add(p);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\manage-product-outBinaryFIle\\src\\Product"));
        os.writeObject(listProduct);
        os.close();
    }

    ArrayList<Product> getListProduct(){
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("C:\\Users\\DELL\\Desktop\\Java_CODEGYM\\manage-product-outBinaryFIle\\src\\Product"));){
            listProduct = (ArrayList<Product>) is.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

        }

        for(Product x : listProduct){
            System.out.println(x);
        }
        return listProduct;
    }
    boolean containsByName(String s){
        for(Product x : listProduct)
        {
            if(x.name.equals(s)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Product a = new Product("phương",4,2,"ds","des");
        Product b = new Product("phú",4,2,"ds","des");
        Product c = new Product("Hùng",4,2,"ds","des");
        Manager manager = new Manager();
        try{
            manager.addToFList(a);
            manager.addToFList(b);
            manager.addToFList(c);
            manager.getListProduct();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(manager.containsByName("Hào"));
    }
}
