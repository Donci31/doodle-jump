package model.states;

import model.Doodle;
import model.Game;
import model.states.DoodleState;

/**
 * Doodle normál állapota
 */
public class DefaultState implements DoodleState {

    private final Doodle doodle;

    public DefaultState(Doodle doodle) {
        this.doodle = doodle;
    }

    /**
     * Változtatja a doodle sebességét a gravitáció függvényében
     * Változtatja az irányát a sebesség és a lejjebb görgetés szerint
     */
    @Override
    public void updateState() {
        doodle.setVy(doodle.getVy() + Game.getGravity());

        doodle.setX(doodle.getX() + doodle.getVx());
        doodle.setY(doodle.getY() + doodle.getVy() + Game.getScrollDownSpeed());
    }
}
