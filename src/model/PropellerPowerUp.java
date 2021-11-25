package model;

public class PropellerPowerUp implements PowerUp {
    @Override
    public void hitBy(Doodle doodle) {
        doodle.setDoodleState(new PropellerHatState(doodle));
    }
}
