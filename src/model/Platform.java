package model;

import java.awt.*;

public class Platform {
    protected int x;
    protected int y;

    protected final int width = 100;
    protected final int height = 20;

    protected Game game;

    protected PowerUp powerUp;

    public Platform(Game game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveDown(int y) {
        this.y += y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void hitBy(Doodle doodle) {
        doodle.setVy(-25);
    }
}
