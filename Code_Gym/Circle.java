public class Circle {
    private double radius = 1.0;
    private String color = "red";
    Circle(){

    }
    Circle(int r){
        this.radius = r;
    }

    public double getRadius(){
        return this.radius;
    }

    public double getArea(){
        return this.radius*radius * Math.PI;
    }

    public static void main(String[] args) {
        Circle a = new Circle();
    }
}
