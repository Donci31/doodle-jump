package view;

import model.Monster;

import javax.swing.*;
import java.awt.*;

/**
 * Szörny kinézete
 */
public class MonsterView implements DrawAble {
    private Monster source;

    private Image image;

    public MonsterView(Monster source) {
        this.source = source;

        image = new ImageIcon(new ImageIcon("./resources/Monster.png").getImage().getScaledInstance(source.getWidth(), source.getHeight(), Image.SCALE_SMOOTH)).getImage();
    }

    /**
     * Kirajzolja a szörnyet
     * @param g Graphics osztály
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, source.getX(), source.getY(), null);
    }
}
