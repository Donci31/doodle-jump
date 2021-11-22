package view;

import model.Doodle;

import javax.swing.*;
import java.awt.*;

public class DoodleView implements DrawAble {

    private Doodle source;

    private Image image;

    public DoodleView(Doodle source) {
        this.source = source;

        image = new ImageIcon(new ImageIcon("./resources/doodle.png").getImage().getScaledInstance(125, 150, Image.SCALE_SMOOTH)).getImage();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, source.getX(), source.getY(), null);
    }
}
