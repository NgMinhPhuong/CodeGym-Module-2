public class FactoryPatternDemo {
    public static void main(String[] args) {
        Shape shape1 = new Circle();
        shape1.draw();
        Shape shape2 = ShapeFactory.getShape("Square");
        if(shape2 instanceof Square){
            System.out.println("Yes");
        }
    }
}
