class Main{

    public static void main(String[] args) {
        Thread one = new Thread(() -> {

           for(int i = 0; i < 5; i++){
               System.out.println("Task One: " + i);
               try {
                   Thread.sleep(2000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });

        Thread two = new Thread(() -> {
           for(int i = 0; i < 5; i++){
               System.out.println("Task Two: " + i);
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        });
        one.start();
        two.start();
    }
}