package model;

import view.BulletView;

import java.awt.*;

public class Bullet implements Fps {
    private int x;
    private int y;

    private int vx;
    private int vy;

    private final int width = 20;
    private final int height = 20;

    private BulletView view;

    public Bullet(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;

        this.vx = vx;
        this.vy = vy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public BulletView getView() {
        return view;
    }

    public void setView(BulletView view) {
        this.view = view;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void tick() {
        vy += Game.getGravity();

        x += vx;
        y += vy + Game.getScrollDownSpeed();
    }
}
