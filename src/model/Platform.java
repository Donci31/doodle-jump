package model;

import view.PlatformView;

import java.awt.*;

public class Platform implements Fps {
    protected int x;
    protected int y;

    protected final int width = 100;
    protected final int height = 20;

    protected static int ySpeed;

    protected PlatformView view;

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

    public PlatformView getView() {
        return view;
    }

    public void setView(PlatformView view) {
        this.view = view;
    }

    public static void setySpeed(int ySpeed) {
        Platform.ySpeed = ySpeed;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void hitBy(Doodle doodle) {
        doodle.setVy(-22);
    }

    @Override
    public void tick() {
        y += ySpeed;
    }
}
