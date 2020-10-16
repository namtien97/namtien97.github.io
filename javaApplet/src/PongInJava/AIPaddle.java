package PongInJava;

import java.awt.*;

public class AIPaddle implements Paddle {
    double y, yVe1;
    boolean upAcce1, downAcce1;
    int player, x;
    final double GRAVITY = 0.94;
    Ball b1;

    public AIPaddle(int player,Ball b) {
        upAcce1 = false;
        downAcce1 = false;
        b1 = b;
        y = 210;
        yVe1 = 0;
        if (player == 1) {
            x = 20;
        } else {
            x = 660;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, (int) y, 20, 80);
    }

    @Override
    public void move() {
        y = b1.getY()-40;

        if (y < 0) {
            y = 0;
        }
        if (y > 420) {
            y = 420;
        }
    }

    public void setUpAcce1(boolean input) {
        upAcce1 = input;
    }

    public void setDownAcce1(boolean input) {
        downAcce1 = input;
    }

    @Override
    public int getY() {
        return (int) y;
    }
}
