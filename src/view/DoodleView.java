package view;

import model.Doodle;

import javax.swing.*;
import java.awt.*;

public class DoodleView implements DrawAble {

    private Doodle source;

    private Image image;

    public DoodleView(Doodle source) {
        this.source = source;

        image = new ImageIcon(new ImageIcon("./resources/Doodle2.png").getImage().getScaledInstance(source.getWidth(), source.getHeight(), Image.SCALE_SMOOTH)).getImage();
    }

    public void shoot() {
        image = new ImageIcon(new ImageIcon("./resources/DoodleShoot.png").getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)).getImage();
    }

    public void unShoot() {
        image = new ImageIcon(new ImageIcon("./resources/Doodle2.png").getImage().getScaledInstance(source.getWidth(), source.getHeight(), Image.SCALE_SMOOTH)).getImage();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, source.getX(), source.getY(), null);
    }
}
