package model.powerups;

import model.Doodle;

public class SpringPowerUp implements PowerUp {
    @Override
    public void hitBy(Doodle doodle) {
        doodle.setVy(-25);
    }
}
