package model;

public class TrampolineState implements DoodleState {

    private int timer;

    private final Doodle doodle;

    public TrampolineState(Doodle doodle) {
        this.doodle = doodle;
        timer = 60;
    }

    @Override
    public void updateState() {
        doodle.setVy(-1);

        doodle.setAngle(doodle.getAngle() + Math.PI / 30);

        timer--;

        if (timer <= 0) {
            doodle.setDoodleState(new DefaultState(doodle));
            doodle.setAngle(0);
        }
    }
}
