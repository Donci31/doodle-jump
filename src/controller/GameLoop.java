package controller;

import model.Doodle;
import model.Game;
import view.GameView;

public class GameLoop extends Thread {
    private final Doodle doodle;
    private final GameView view;
    private final Game game;
    private final CollisionDetector collision;

    public GameLoop(Doodle doodle, GameView view, Game game, CollisionDetector collision) {
        this.doodle = doodle;
        this.view = view;
        this.game = game;
        this.collision = collision;

        start();
    }

    @Override
    public void run() {
        while (!doodle.isDead()) {
            try {
                sleep(17);
                view.repaint(0, 0, 500, 750);
                game.tick();
                collision.doodlePlatformCollision();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
