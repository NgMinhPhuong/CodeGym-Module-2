import java.util.Scanner;

public class IllegalTriangleException {
    static void createTriangle(int a, int b, int c) throws Exception {
        if(a < 0 || b < 0 || c < 0 || a + b < c || a + c < b || b + c <a){
            throw new Exception("Cannot a Triangle");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        System.out.print("Enter c: ");
        int c = sc.nextInt();

        try{
            createTriangle(a, b, c);
        } catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
