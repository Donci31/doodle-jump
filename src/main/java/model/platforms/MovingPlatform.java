package model.platforms;

import model.Fps;

/**
 * Mozgó platform logikáját kezelő osztály
 */
public class MovingPlatform extends Platform implements Fps {

    private int vx; // Platform x irányú sebessége

    public MovingPlatform(int x, int y) {
        super(x, y);
        vx = 2;
    }

    /**
     * Lejjebb görgeti a platformot, ha kell.
     * Oldal irányba mozog, amíg el nem éri a képernyő szélét,
     * és ott irányt változtat.
     */
    @Override
    public void tick() {
        super.tick();
        if (vx > 0 && x >= 400 || vx < 0 && x <= 0) {
            vx *= -1;
        }
        x += vx;
    }
}
