package model;

import java.awt.*;

public class Platform {
    protected int x;
    protected int y;

    protected final int width = 150;
    protected final int height = 20;

    protected PowerUp powerUp;

    public Platform(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void hitBy(Doodle doodle) {
        doodle.setVy(-25);
    }
}
