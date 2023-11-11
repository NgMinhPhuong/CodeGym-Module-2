public class NumberGenerator implements Runnable {

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++){
            System.out.println(i + ". Hashcode: " + this.hashCode());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
