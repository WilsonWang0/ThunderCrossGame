public class Bullet {

    private double x;
    private double y;

    public Bullet( ) {
        this.x = 0.5;
        this.y = 0.5;
    }

    public Bullet( double x, double y ) {
        this.x = x;
        this.y = y;
    }

    public void setX( double x ) {
        this.x = x; //set x for user's bullet
    }

    public void setY( double y ) {
        this.y = y; //set y for user's bullet
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void update() {
        this.y += 0.1;
    }

    public void draw() { //user bullet fly method
        StdDraw.picture(this.getX(), this.getY(), "bullet1.png", 0.05, 0.05, 90);
    }
}