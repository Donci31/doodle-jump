package model.powerups;

import model.Doodle;
import model.states.TrampolineState;

public class TrampolinePowerUp implements PowerUp {
    @Override
    public void hitBy(Doodle doodle) {
        doodle.setDoodleState(new TrampolineState(doodle));
    }
}
