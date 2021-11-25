package model;

import view.DoodleView;

import java.awt.*;

public class Doodle implements Fps {
    private int x;
    private int y;

    private double angle;

    private int vx;
    private int vy;

    private final int width = 125;
    private final int height = 150;

    private DoodleState doodleState;

    private DoodleView doodleView;

    public Doodle() {
        x = 100;
        y = 0;

        vx = 0;
        vy = 0;

        doodleState = new TrampolineState(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public void setDoodleState(DoodleState doodleState) {
        this.doodleState = doodleState;
    }

    public void setDoodleView(DoodleView doodleView) {
        this.doodleView = doodleView;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y + 100, width, height - 100);
    }

    public boolean isDead() {
        return y >= 750;
    }

    @Override
    public void tick() {
        doodleState.updateState();
    }
}
