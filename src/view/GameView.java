package view;

import controller.GameLoop;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameView extends JPanel {

    private Game source;

    private final ArrayList<DrawAble> drawList;

    public GameView() {

        drawList = new ArrayList<>();

        setSize(500, 750);

        setVisible(true);
    }

    public void setGame(Game source) {
        this.source = source;
    }

    public void addDrawable(DrawAble newElement) {
        drawList.add(newElement);
    }

    public void keyPressed(KeyEvent e) {
        source.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        source.keyReleased(e);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(DrawAble d: drawList) {
            d.draw(g);
        }
    }
}
