package model;

public class JetPackPowerUp implements PowerUp {
    @Override
    public void hitBy(Doodle doodle) {
        doodle.setDoodleState(new JetPackState(doodle));
    }
}
