package model.states;

import model.Doodle;
import model.Game;
import model.states.DoodleState;

public class DefaultState implements DoodleState {

    private final int gravity = 1;

    private final Doodle doodle;

    public DefaultState(Doodle doodle) {
        this.doodle = doodle;
    }

    @Override
    public void updateState() {
        doodle.setVy(doodle.getVy() + Game.getGravity());

        doodle.setX(doodle.getX() + doodle.getVx());
        doodle.setY(doodle.getY() + doodle.getVy() + Game.getScrollDownSpeed());
    }
}
