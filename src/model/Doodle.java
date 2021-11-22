package model;

import java.awt.*;

public class Doodle implements Fps {
    private int x;
    private int y;

    private final int width = 125;
    private final int height = 150;
    private final int gravity = 1;

    private int vx;
    private int vy;

    public Doodle() {
        x = 100;
        y = 100;

        vx = 0;
        vy = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y + 100, width, height - 100);
    }

    public boolean isDead() {
        return y >= 750;
    }

    @Override
    public void tick() {
        vy += gravity;

        x += vx;
        y += vy;
    }
}
