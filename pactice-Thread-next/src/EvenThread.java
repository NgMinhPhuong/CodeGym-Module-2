public class EvenThread extends Thread{
    private Thread thread;
    String name;
    EvenThread(String name){
        this.name = name;
        start();
    }
    @Override
    public void  run(){

        for(int i = 1; i < 11; i++){
            if(i % 2 == 0){
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(thread.getName() + ": " + i);
            }
        }
    }
    public void start(){
        if(thread == null){
            thread = new Thread(this, this.name);
        }
        thread.start();
    }

}
