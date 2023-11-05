public class Circle implements Resizeable<Double>{
    public double radius;
    Circle(double radius){
        this.radius = radius;
    }
    public Double getR(){
        return Math.PI * radius * radius;
    }

    @Override
    public void resize(double percent) {
        this.radius *= (percent/100);
    }
}
