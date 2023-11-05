public class Square implements Resizeable {
    public int canh;
    Square(int x){
        this.canh = x;
    }

    @Override
    public void resize(double percent) {
        this.canh *= (percent/100);
    }
}
