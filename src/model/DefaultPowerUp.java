package model;

public class DefaultPowerUp implements PowerUp {
    @Override
    public void hitBy(Doodle doodle) {
        doodle.setVy(-22);
    }
}
