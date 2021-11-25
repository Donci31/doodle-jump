package model;

public class SpringPowerUp implements PowerUp {
    @Override
    public void hitBy(Doodle doodle) {
        doodle.setVy(-44);
    }
}
