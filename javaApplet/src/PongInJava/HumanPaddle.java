package PongInJava;

import java.awt.*;

public class HumanPaddle implements Paddle {
    double y, yVe1;
    boolean upAcce1, downAcce1;
    int player, x;
    final double GRAVITY = 0.94;

    public HumanPaddle(int player) {
        upAcce1 = false;
        downAcce1 = false;
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
        if (upAcce1) {
            yVe1 -= 2;
        } else if (downAcce1) {
            yVe1 += 2;
        } else if (!upAcce1 && !downAcce1) {
            yVe1 *= GRAVITY;
        }
        if (yVe1 >= 5) {
            yVe1 = 5;
        } else if (yVe1 <= -5) {
            yVe1 = -5;
        }
        y += yVe1;

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
