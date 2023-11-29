package Main;

public class Run implements Runnable{
    public synchronized void run(){
        for (int i = 0; i < 10; i++){
            System.out.println(i);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Run r = new Run();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);

        thread1.start();
        thread2.start();
    }
}
