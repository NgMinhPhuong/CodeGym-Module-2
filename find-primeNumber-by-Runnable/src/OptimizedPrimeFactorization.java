public class OptimizedPrimeFactorization implements Runnable{
    String name;
    Thread thread;
    OptimizedPrimeFactorization(String name){
        this.name = name;
        this.start();
    }
    boolean checkPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            if(checkPrime(i)){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(thread.getName() + "   " + i);
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
