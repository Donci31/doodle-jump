package model;

import view.MonsterView;

import java.awt.*;

/**
 * Szörny logikáját kezelő osztály
 */
public class Monster implements Fps {
    private int x; // szörny x koordinátája
    private int y; // szörny y koordinátája

    private int vx; // szörny x komponensű sebessége

    private final int width = 135;
    private final int height = 75;

    private MonsterView view;

    private boolean isAlive; // életben van-e a szörny

    public Monster(int x, int y) {
        this.x = x;
        this.y = y;

        vx = 3;

        isAlive = true;
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

    public MonsterView getView() {
        return view;
    }

    public void setView(MonsterView view) {
        this.view = view;
    }

    /**
     * Visszaadja a szörny hitboxát
     * @return hitbox
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void die() {
        isAlive = false;
    }

    /**
     * Frissíti a szörny állapotát
     */
    @Override
    public void tick() {
        y += Game.getScrollDownSpeed();

        if (vx > 0 && x >= 400 || vx < 0 && x <= 0) {
            vx *= -1;
        }
        x += vx;
    }
}
