package model.states;

import model.Doodle;
import model.Game;

/**
 * Doodle trambulinos állapota
 */
public class TrampolineState implements DoodleState {

    private int timer; // Időzítő a hatás kezelésére

    private final Doodle doodle; // Doodle, akihez kapcsolódik ez az osztály

    public TrampolineState(Doodle doodle) {
        this.doodle = doodle;
        timer = 60;
        doodle.setVy(-35);
    }

    /**
     * Ad egy nagyobb löketet a doodlenek
     * 1 másodperc letelte után visszaállítja
     * a doodle állapotát normálisra
     */
    @Override
    public void updateState() {

        doodle.setVy(doodle.getVy() + Game.getGravity());

        doodle.setX(doodle.getX() + doodle.getVx());
        doodle.setY(doodle.getY() + doodle.getVy() + Game.getScrollDownSpeed());

        timer--;

        if (timer <= 0) {
            doodle.setDoodleState(new DefaultState(doodle));
            doodle.setAngle(0);
        }
    }
}
