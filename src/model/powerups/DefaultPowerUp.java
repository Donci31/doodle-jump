package model.powerups;

import model.Doodle;

public class DefaultPowerUp implements PowerUp {
    @Override
    public void hitBy(Doodle doodle) {
        doodle.setVy(-25);
    }
}
