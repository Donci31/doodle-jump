package model;

public class Doodle implements Fps {
    private int x;
    private int y;

    private int vx;
    private int vy;

    private final int gravity = 1;

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
