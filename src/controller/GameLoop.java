package controller;

import model.Doodle;
import model.Game;
import view.GameView;

public class GameLoop extends Thread {
    private Doodle doodle;
    private GameView view;
    private Game game;

    boolean isGameOver;

    public GameLoop(Doodle doodle, GameView view, Game game) {
        this.doodle = doodle;
        this.view = view;
        this.game = game;
        isGameOver = false;
        start();
    }

    @Override
    public void run() {
        while (!doodle.isDead()) {
            try {
                sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            view.repaint(0, 0, 500, 750);
            game.tick();
        }
     }
}
