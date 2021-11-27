package model.platforms;

import model.Doodle;
import model.Fps;
import model.Game;
import model.powerups.DefaultPowerUp;
import model.powerups.PowerUp;
import view.PlatformView;

import java.awt.*;

public class Platform implements Fps {
    protected int x;
    protected int y;

    protected final int width = 100;
    protected final int height = 20;


    protected PlatformView view;

    protected PowerUp powerUp;

    public Platform(int x, int y) {
        this.x = x;
        this.y = y;
        powerUp = new DefaultPowerUp();
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

    public PlatformView getView() {
        return view;
    }

    public void setView(PlatformView view) {
        this.view = view;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void hitBy(Doodle doodle) {
        powerUp.hitBy(doodle);
    }

    @Override
    public void tick() {
        y += Game.getScrollDownSpeed();
    }
}
