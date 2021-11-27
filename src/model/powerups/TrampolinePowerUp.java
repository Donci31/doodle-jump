package model.powerups;

import model.Doodle;
import model.platforms.Platform;
import model.states.TrampolineState;

public class TrampolinePowerUp implements PowerUp {
    @Override
    public void hitBy(Platform platform, Doodle doodle) {
        doodle.setDoodleState(new TrampolineState(doodle));
    }
}
