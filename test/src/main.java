import java.util.concurrent.atomic.AtomicInteger;

public class main implements Runnable{
    @Override
    public synchronized void run(){

    }
    static synchronized String in() throws Exception {
        throw  new Exception();
    }
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger(6);
        a.set(2);
        System.out.println(a.get());
    }
}
