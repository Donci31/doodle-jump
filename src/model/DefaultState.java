package model;

public class DefaultState implements DoodleState {

    private final int gravity = 1;

    private final Doodle doodle;

    public DefaultState(Doodle doodle) {
        this.doodle = doodle;
    }

    @Override
    public void updateState() {
        doodle.setVy(doodle.getVy() + gravity);

        doodle.setX(doodle.getX() + doodle.getVx());
        doodle.setY(doodle.getY() + doodle.getVy());
    }
}
