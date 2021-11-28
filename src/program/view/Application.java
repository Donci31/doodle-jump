package program.view;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Application extends JFrame {

    GameView gameView;

    private class ArrowsListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            gameView.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            gameView.keyReleased(e);
        }
    }

    public Application(GameView gameView) {
        this.gameView = gameView;

        add(gameView);

        addKeyListener(new ArrowsListener());

        setSize(500, 750);

        setTitle("Doodle jump");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
