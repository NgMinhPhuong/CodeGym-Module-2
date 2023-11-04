package PointAndMoveablePoint;

public class MoveablePoint extends Point{
    private float xSpeed;
    private float ySpeed;
    MoveablePoint(){

    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float [] getSpeed(){
        float [] a = {xSpeed, ySpeed};
        return a;
    }

    @Override
    public String toString(){
        return "(" + getX() + "," + getY() +  ") xSpeed: " + xSpeed + ", ySpeed: " + ySpeed;
    }

    MoveablePoint Move(){
        setXY(getX() + xSpeed, getY() +ySpeed);
        return this;
    }
}
