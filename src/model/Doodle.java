package model;

import controller.BulletHandler;
import model.states.DefaultState;
import model.states.DoodleState;
import view.DoodleView;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Doodle implements Fps {
    private int x;
    private int y;

    private double angle;

    private int vx;
    private int vy;

    private final int width = 125;
    private final int height = 150;

    private DoodleState doodleState;

    private DoodleView view;

    private BulletHandler bulletHandler;

    boolean haveShot;

    boolean isAlive;

    public Doodle(int x, int y) {
        this.x = x;
        this.y = y;

        vx = 0;
        vy = 0;

        haveShot = false;
        isAlive = true;

        doodleState = new DefaultState(this);
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

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAngle(double angle) {
        this.angle = angle;
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

    public void setDoodleView(DoodleView view) {
        this.view = view;
    }

    public void setBulletHandler(BulletHandler bulletHandler) {
        this.bulletHandler = bulletHandler;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y + 100, width, height - 100);
    }

    public Rectangle getHitbox() {
        return new Rectangle(x, y, width, height);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void die() {
        isAlive = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            setVx(-5);
        }
        if (key == KeyEvent.VK_RIGHT) {
            setVx(5);
        }
        if (key == KeyEvent.VK_SPACE && !haveShot) {
            haveShot = true;
            view.shoot();
            bulletHandler.newBullet(x + width / 2, y, vx, -33);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            setVx(0);
        }
        if (key == KeyEvent.VK_RIGHT) {
            setVx(0);
        }
        if (key == KeyEvent.VK_SPACE) {
            haveShot = false;
            view.unShoot();
        }
    }

    @Override
    public void tick() {
        if (y > 750) {
            die();
        }

        doodleState.updateState();
    }
}
