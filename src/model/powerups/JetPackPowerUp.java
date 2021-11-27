package model.powerups;

import model.Doodle;
import model.states.JetPackState;

public class JetPackPowerUp implements PowerUp {
    @Override
    public void hitBy(Doodle doodle) {
        doodle.setDoodleState(new JetPackState(doodle));
    }
}
