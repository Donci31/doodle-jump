package model;

public class TrampolinePowerUp implements PowerUp {
    @Override
    public void hitBy(Doodle doodle) {
        doodle.setDoodleState(new TrampolineState(doodle));
    }
}
