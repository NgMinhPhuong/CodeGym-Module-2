public class test {
    public static void main(String[] args) {
        Resizeable [] a = {new Circle(2.5), new Square(5), new Rectangle(2,3)};
        for(Resizeable x : a){
            System.out.println(x.getR());
            if(x instanceof Square){
                ((Square) x).howToColor();
            }
        }
    }
}
