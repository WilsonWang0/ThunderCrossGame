import java.util.Random;
public class Plane {

    private double x;
    private double y;
    private boolean isFriendly;
    private double speed;


    public Plane( ) {
        this.x = 0.5;
        this.y = 0.5;
        this.isFriendly = true;
        this.speed = 0.1;
    }

    public Plane(double x, double y, boolean friendly) {
        this.x = x;
        this.y = y;
        this.isFriendly = friendly;
        this.speed = 0.01;
    }

    public void setX(double x) {
        this.x = x; //set x for user plane
    }

    public void setY(double y) {
        this.y = y; //set y for user plane
    }

    public void setSpeed(double speed) {
        this.speed = speed; //set y for user plane
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void draw( ) {

        if (isFriendly) {
            StdDraw.picture(this.getX(), this.getY(), "pplane.png", 0.3, 0.3);
        } else {
            StdDraw.picture(this.getX(), this.getY(), "eplane.png", 0.3, 0.3,-180);

        }
    }
}