import java.util.Date;

public class StopWatch {
    private long startTime = System.currentTimeMillis();
    private long endTime = System.currentTimeMillis();

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public void start(){
        startTime = System.currentTimeMillis();
    }

    public void stop(){
        endTime = System.currentTimeMillis();
    }

    public double getElapsedTime(){
        return endTime - startTime;
    }

    public static void main(String[] args) {
        StopWatch a=  new StopWatch();
        a.start();
        for(int i = 0; i < 500000; i++)
        {
            System.out.println("c");
        }
        a.stop();

        System.out.println(a.getElapsedTime());
    }
}
