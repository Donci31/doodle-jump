package model;

public class JetPackState implements DoodleState {

    private int timer;

    private final Doodle doodle;

    public JetPackState(Doodle doodle) {
        this.doodle = doodle;
        timer = 60;
    }

    @Override
    public void updateState() {
        doodle.setVy(-1);

        timer--;

        if (timer <= 0) {
            doodle.setDoodleState(new DefaultState(doodle));
        }
    }
}
