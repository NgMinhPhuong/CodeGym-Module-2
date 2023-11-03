public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    double  getDiscriminant(){
        return b*b - 4*a*c;
    }

    String getRoot1(){
        if(getDiscriminant() < 0)
        {
            return "The equation has no roots";
        }
        else if(getDiscriminant() == 0)
        {
            return "x1 = " + -b/2*a;
        }
        else{
            return "x1 = " + (-b + Math.sqrt(getDiscriminant()))/2*a;

        }
    }

    String getRoot2(){
        if(getDiscriminant() < 0)
        {
            return "The equation has no roots";
        }
        else if(getDiscriminant() == 0)
        {
            return "x2 = " + -b/2*a;
        }
        else{
            return "x2 = " + (-b - Math.sqrt(getDiscriminant()))/2*a;

        }

    }
    public static void main(String[] args) {
        QuadraticEquation a=  new QuadraticEquation(1,-3,2);
        System.out.println(a.getRoot1());
        System.out.println(a.getRoot2());
    }
}
