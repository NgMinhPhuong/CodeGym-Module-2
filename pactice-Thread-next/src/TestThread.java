public class TestThread {
    public static void main(String[] args) {
        OddThread ot = new OddThread("Task Odd");
        try {
            ot.getThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        EvenThread et = new EvenThread("Task Even");

    }
}
