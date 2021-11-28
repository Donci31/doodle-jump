package model;

import view.BulletView;

import java.awt.*;

/**
 * Lövedék logikáját kezelő osztály
 */
public class Bullet implements Fps {
    private int x;
    private int y;

    private final int vx;
    private int vy;

    private final int width = 20;
    private final int height = 20;

    private BulletView view;

    boolean hit;

    public Bullet(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;

        this.vx = vx;
        this.vy = vy;

        hit = false;
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

    public boolean hasHit() {
        return hit;
    }

    public void hit() {
        hit = true;
    }

    public void setView(BulletView view) {
        this.view = view;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * Minden frameben meghívódó függvény,
     * ami változtatja helyzetét, sebességét.
     * Figyelembe kell venni a játék görgetését is.
     */
    @Override
    public void tick() {
        vy += Game.getGravity();

        x += vx;
        y += vy + Game.getScrollDownSpeed();
    }
}
