package model.states;

import model.Doodle;
import model.Game;

public class PropellerHatState implements DoodleState {

    private int timer;

    private final Doodle doodle;

    public PropellerHatState(Doodle doodle) {
        this.doodle = doodle;
        timer = 60;
    }

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
