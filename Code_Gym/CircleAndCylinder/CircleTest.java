package CircleAndCylinder;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CircleTest {
    public static void main(String[] args) {
        Circle [] c = {new Cylinder(2,"red",1),new Cylinder(1,"red",1),new Cylinder(1.5,"blue",1)};
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
    }
}
