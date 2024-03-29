package model.states;

import model.Doodle;
import model.Game;

/**
 * Doodle propelleres állapota
 */
public class PropellerHatState implements DoodleState {

    private int timer; // Időzítő a hatás kezelésére

    private final Doodle doodle; // Doodle, akihez kapcsolódik ez az osztály

    public PropellerHatState(Doodle doodle) {
        this.doodle = doodle;
        timer = 60;
    }

    /**
     * Állandó sebességgel viszi felfele a doodlet
     * 1 másodperc letelte után visszaállítja
     * a doodle állapotát normálisra
     */
    @Override
    public void updateState() {
        doodle.setVy(-10);

        doodle.setX(doodle.getX() + doodle.getVx());
        doodle.setY(doodle.getY() + doodle.getVy() + Game.getScrollDownSpeed());

        timer--;

        if (timer <= 0) {
            doodle.setDoodleState(new DefaultState(doodle));
        }
    }
}
