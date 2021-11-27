package model.powerups;

import model.Doodle;
import model.states.PropellerHatState;

public class PropellerPowerUp implements PowerUp {
    @Override
    public void hitBy(Doodle doodle) {
        doodle.setDoodleState(new PropellerHatState(doodle));
    }
}
