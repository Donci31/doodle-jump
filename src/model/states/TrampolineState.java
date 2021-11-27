package model.states;

import model.Doodle;
import model.Game;

public class TrampolineState implements DoodleState {

    private int timer;

    private final Doodle doodle;

    public TrampolineState(Doodle doodle) {
        this.doodle = doodle;
        timer = 60;
        doodle.setVy(-40);
    }

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
