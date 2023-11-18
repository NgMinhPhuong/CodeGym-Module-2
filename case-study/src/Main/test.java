package Main;

import java.io.IOException;
import java.io.RandomAccessFile;

public class test {
    public static void main(String[] args) {

        try (RandomAccessFile file = new RandomAccessFile("C:\\Users\\DELL\\Desktop\\Java_CODEGYM-Module2\\case-study\\src\\ProductData.csv", "rw")) {
            file.setLength(0); // Đặt độ dài file là 0
            //System.out.println("Đã xóa hết nội dung trong file nhị phân.");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Admin admin1 = new Admin();
//        admin1.addProduct(new Product("quần jean", 5, "Quần xịn", 4));
//        admin1.addProduct(new Product("áo xách nách", 3, "Áo xịn", 2));
//      //  Client An = new Client("hậu");
//       // An.setPaymentMethod(new PayByCard());
//       // An.pay(admin1.getProduct(0), 5);
//        admin1.showProductList();
    }
}

