package program.model.states;

import program.model.Doodle;
import program.model.Game;

/**
 * Doodle jetpackes állapota
 */
public class JetPackState implements DoodleState {

    private int timer; // Időzítő a hatás kezelésére

    private final Doodle doodle; // Doodle, akihez kapcsolódik ez az osztály

    public JetPackState(Doodle doodle) {
        this.doodle = doodle;
        timer = 120;
    }

    /**
     * Állandó sebességgel viszi felfele a doodlet
     * 2 másodperc letelte után visszaállítja
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
