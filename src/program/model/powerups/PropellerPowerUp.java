package program.model.powerups;

import program.model.Doodle;
import program.model.platforms.Platform;
import program.model.states.PropellerHatState;

/**
 * Egy propeller van a platformon
 */
public class PropellerPowerUp implements PowerUp {
    /**
     * Ütközésnél rárak egy propelert a doodle-re
     * Törli a platformról a propellert
     * @param platform Platform, ami tartalmazza ezt
     * @param doodle Doodle, akivel ütközik
     */
    @Override
    public void hitBy(Platform platform, Doodle doodle) {
        doodle.setDoodleState(new PropellerHatState(doodle));
        platform.removePowerUp();
    }
}
