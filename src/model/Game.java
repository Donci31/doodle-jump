package model;

import controller.CollisionDetector;
import view.*;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Fps {
    private final int height = 750;
    private final int width = 500;

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
        view.addDrawable(new DoodleView(doodle));

        detector.setDoodle(doodle);

        movables.add(doodle);
    }

    public ArrayList<Fps> getMovables() {
        return movables;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            doodle.setVx(-5);
        }
        if (key == KeyEvent.VK_RIGHT) {
            doodle.setVx(5);
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            doodle.setVx(0);
        }
        if (key == KeyEvent.VK_RIGHT) {
            doodle.setVx(0);
        }
    }

    @Override
    public void tick() {
        if (doodle.getY() < 200 && doodle.getVy() < 0) {
            Platform.setySpeed(-doodle.getVy());
        } else {
            Platform.setySpeed(0);
        }

        for (Fps f : movables) {
            f.tick();
        }
    }
}
