public class Rectangle implements Resizeable{
    public int width;
    public int height;
    Rectangle(int x , int y){
        this.width = x;
        this.height = y;
    }

    @Override
    public void resize(double percent) {
        this.width *= (percent/100);
        this.height *= (percent/100);
    }
}
