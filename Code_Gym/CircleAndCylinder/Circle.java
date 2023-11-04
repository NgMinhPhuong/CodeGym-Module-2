package CircleAndCylinder;

public class Circle {
    private double r;
    private String color;
    Circle(double r, String color){
        this.r = r;
        this.color = color;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getR() {
        return r;
    }

    public String getColor() {
        return color;
    }

    double getArea(){
        return r*r * Math.PI;
    }
    @Override
    public String toString(){
        return "A circle with radius = "+ r +", Color: " + color + ", S = " + getArea();
    }
}
