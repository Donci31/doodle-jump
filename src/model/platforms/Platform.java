package model.platforms;

import model.Doodle;
import model.Fps;
import model.Game;
import model.powerups.DefaultPowerUp;
import model.powerups.PowerUp;
import view.platformviews.PlatformView;
import view.powerupviews.PowerUpView;

import java.awt.*;

/**
 * Platform logikáját kezelő osztály
 */
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

    /**
     * Elveszi a platform powerup-ját
     */
    public void removePowerUp() {
        powerUp = new DefaultPowerUp();
        view.setPowerUpView(new PowerUpView());
    }

    /**
     * Visszaadja a platform hitboxát
     * @return Hitbox méretű és pozíciójú téglalap
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * Ha a doodle-el ütközik, akkor a poweruptól függően
     * valamilyen hatást tesz a doodle-re.
     * @param doodle Platformmal ütköző doodle
     */
    public void hitBy(Doodle doodle) {
        powerUp.hitBy(this, doodle);
    }

    /**
     * Lejjebb görgeti a platformot, ha kell.
     */
    @Override
    public void tick() {
        y += Game.getScrollDownSpeed();
    }
}
