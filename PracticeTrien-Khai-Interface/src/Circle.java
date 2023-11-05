public class Circle implements Resizeable{
    public double radius;
    Circle(double radius){
        this.radius = radius;
    }
    @Override
    public void resize(double percent) {
        this.radius *= (percent/100);
    }
}
