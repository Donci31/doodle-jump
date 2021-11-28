package program.model.states;

import program.model.Doodle;
import program.model.Game;

/**
 * Doodle propelleres állapota
 */
public class PropellerHatState implements DoodleState {

    private int timer;

    private final Doodle doodle;

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
