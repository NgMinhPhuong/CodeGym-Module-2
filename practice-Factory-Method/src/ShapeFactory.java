public class ShapeFactory {
    public static Shape getShape(String s){
        if(s == "Circle") return new Circle();
        else if(s == "Square") return new Square();
        else return new Rectangle();
    }
}
