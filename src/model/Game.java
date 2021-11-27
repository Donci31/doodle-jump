package model;

import controller.CollisionDetector;
import view.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Game implements Fps {
    private final int height = 750;
    private final int width = 500;

    private static int scrollDownSpeed;

    private static final int gravity = 1;

    private final Doodle doodle;

    private final GameView view;

    private final CollisionDetector detector;

    private final ArrayList<Monster> monsters;

    private final ArrayList<Fps> movables;

    public Game(Doodle doodle, GameView view, CollisionDetector detector) {
        this.doodle = doodle;
        this.view = view;
        this.detector = detector;

        monsters = new ArrayList<>();
        movables = new ArrayList<>();

        view.setGame(this);

        DoodleView doodleView = new DoodleView(doodle);

        view.addDrawable(doodleView);

        doodle.setDoodleView(doodleView);

        detector.setDoodle(doodle);

        movables.add(doodle);
    }

    public ArrayList<Fps> getMovables() {
        return movables;
    }

    public static int getGravity() {
        return gravity;
    }

    public static int getScrollDownSpeed() {
        return scrollDownSpeed;
    }

    public static void setScrollDownSpeed(int scrollDownSpeed) {
        Game.scrollDownSpeed = scrollDownSpeed;
    }

    public void keyPressed(KeyEvent e) {
        doodle.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        doodle.keyReleased(e);
    }

    @Override
    public void tick() {
        if (doodle.getY() < 200 && doodle.getVy() < 0) {
            Game.setScrollDownSpeed(-doodle.getVy());
        } else {
            Game.setScrollDownSpeed(0);
        }

        for (Fps f : movables) {
            f.tick();
        }
    }
}
