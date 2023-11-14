public class main implements Runnable{
    @Override
    public synchronized void run(){

    }
    static synchronized String in() throws Exception {
        throw  new Exception();
    }
    public static void main(String[] args) {
        try {
            in();
            System.out.println(123);
        } catch (Exception e){
            System.out.println("lỗi");
        }
        System.out.println("out");
    }
}
