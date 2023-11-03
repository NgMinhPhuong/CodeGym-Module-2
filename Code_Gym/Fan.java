public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = SLOW;
    private boolean status = false;
    private double radius = 5;
    private String color = "blue";

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSLOW() {
        return SLOW;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isStatus() {
        return status;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public String toString(){
        if(!status) return "Color: " + color + ", Radius: " + radius + ". Fan is off";
        else return "Speed: " + speed + ", Color: " + color + ", Radius: " + radius + ". Fan is on";
    }
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setStatus(true);
        fan2.setSpeed(2);
        fan2.setRadius(5);
        fan2.setColor("blue");


    }
}
