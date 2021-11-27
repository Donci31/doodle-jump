package view;

import model.Doodle;

import javax.swing.*;
import java.awt.*;

public class DoodleView implements DrawAble {

    private Doodle source;

    private Image currentImage;

    Image normalImage;
    Image shootImage;

    public DoodleView(Doodle source) {
        this.source = source;

        normalImage = new ImageIcon(new ImageIcon("./resources/Doodle2.png").getImage().getScaledInstance(source.getWidth(), source.getHeight(), Image.SCALE_SMOOTH)).getImage();
        shootImage = new ImageIcon(new ImageIcon("./resources/DoodleShoot.png").getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH)).getImage();
        currentImage = normalImage;
    }

    public void shoot() {
        currentImage = shootImage;
    }

    public void unShoot() {
        currentImage = normalImage;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(currentImage, source.getX(), source.getY(), null);
    }
}
