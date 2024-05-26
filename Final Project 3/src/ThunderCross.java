import java.util.ArrayList;
import java.util.Random;

public class ThunderCross {

    public static void main(String[] args) {

        int s = 0;

        StdDraw.setPenRadius(0.1);

        StdDraw.setPenColor(StdDraw.BLACK);

        Random rand = new Random();

        ArrayList<Bullet> bullets = new ArrayList<Bullet>();

        Plane player = new Plane();
        Plane enemy1 = new Plane(rand.nextDouble(), 1.0, false);

        StdDraw.enableDoubleBuffering();

        while (true) {

            drawBackground();
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(0.1, 0.9, "Score = " + s);

            player.setX(StdDraw.mouseX());
            player.setY(StdDraw.mouseY());
            player.draw();

            if (bullets.size() < 10) {
                bullets.add(new Bullet(player.getX(), player.getY()));
            }

            if (enemy1.getY() < -0.25) {
                enemy1.setX(rand.nextDouble());
                enemy1.setY(1.10);
            } else {
                enemy1.setY(enemy1.getY() - enemy1.getSpeed());
            }

            enemy1.draw();

            updateBullets(bullets, enemy1);

            if (Math.abs(player.getX() - enemy1.getX()) < 0.13 && Math.abs(player.getY() - enemy1.getY()) < 0.14) {
                break;
            }

            for (int i = 0; i < bullets.size(); i++) {
                if (Math.abs(bullets.get(i).getY() - enemy1.getY()) < 0.09 && Math.abs(bullets.get(i).getX() - enemy1.getX()) < 0.1) {
                    enemy1.setX(rand.nextDouble());
                    enemy1.setY(1.3);
                    enemy1.setSpeed(enemy1.getSpeed() + 0.001);
                    s += 100;
                }
            }

            StdDraw.show();
            StdDraw.pause(10);
            StdDraw.clear();

        }

        StdDraw.text(0.5,0.5, "Game Over");
        StdDraw.show();
    }



    public static void drawBackground() {

        StdDraw.picture(0.5, 0.5, "iiu.jpeg", 1, 1);

    }

    public static void updateBullets(ArrayList<Bullet> bullets, Plane enemy1) {

        for (int i = 0; i < bullets.size(); i++) {
            if (bullets.get(i).getY() > 1.2) {
                bullets.remove(i);
            } else {
                bullets.get(i).update();
                if (bullets.get(i).getY() != enemy1.getY()) {
                    bullets.get(i).draw();
                } else {
                    bullets.remove(i);
                }
            }
        }
    }
}



