package model.powerups;

import model.Doodle;
import model.platforms.Platform;
import model.states.PropellerHatState;

public class PropellerPowerUp implements PowerUp {
    @Override
    public void hitBy(Platform platform, Doodle doodle) {
        doodle.setDoodleState(new PropellerHatState(doodle));
        platform.removePowerUp();
    }
}
