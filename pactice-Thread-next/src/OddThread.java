public class OddThread extends Thread{
    private Thread thread;
    String name;
    OddThread(String name){
        this.name = name;
        start();
    }
    @Override
    public void  run(){
        for(int i = 1; i < 11; i++){
            if(i % 2 != 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(thread.getName() + ": " + i);
            }

        }
    }
    public Thread getThread(){
        return this.thread;
    }
    public void start(){
        if(thread == null){
            thread = new Thread(this, this.name);
        }
        thread.start();
    }
}
