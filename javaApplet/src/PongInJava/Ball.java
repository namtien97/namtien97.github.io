package PongInJava;

import java.awt.*;

public class Ball {
    double xVe1, yVe1, x, y;

    public Ball() {
        x = 350;
        y = 250;
        xVe1 = getRandomSpeed()*getRandomDirection();
        yVe1 = getRandomSpeed()*getRandomDirection();
    }

    public double getRandomSpeed() {
        return (Math.random() * 1 + 2);
    }

    public int getRandomDirection() {
        int rand = (int) (Math.random() * 2);
        if (rand == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillOval((int) x - 10, (int) y - 10, 20, 20);
    }

    public void checkPaddleCollinsion(Paddle p1, Paddle p2) {
        if (x <= 50) {
            if (y >= p1.getY() && y <= p1.getY() + 80) {
                xVe1 = -xVe1;
            }
        } else if (x >= 650) {
            if (y >= p2.getY() && y <= p2.getY() + 80) {
                xVe1 = -xVe1;
            }
        }
    }

    public void move() {
        x += xVe1;
        y += yVe1;

        if (y < 10) {
            yVe1 = -yVe1;
        }
        if (y > 490) {
            yVe1 = -yVe1;
        }
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }
}
