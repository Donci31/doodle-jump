package view;

import logic.Canvas;

import javax.swing.*;

public class CanvasView extends JFrame {

    public CanvasView() {
        add(new Canvas());

        setSize(1600, 900);

        setTitle("logic.Doodle jump");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        CanvasView canvas = new CanvasView();
    }
}
