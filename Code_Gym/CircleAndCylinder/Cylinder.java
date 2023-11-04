package CircleAndCylinder;

public class Cylinder extends Circle {
    private double height;
    Cylinder(double r, String color, double height){
        super(r,color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    double getV(){
        return super.getR() * super.getR() * Math.PI * height;
    }

    @Override
    public String toString(){
        return "A circle with radius = "+ super.getR() +", Color: " + super.getColor() + ", S = " + getArea() + ", V = " + this.getV();
    }
}
