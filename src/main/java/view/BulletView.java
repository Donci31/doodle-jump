package view;

import model.Bullet;

import java.awt.*;

/**
 * Lövedék kinézete
 */
public class BulletView implements DrawAble {

    private Bullet source;

    public BulletView(Bullet source) {
        this.source = source;
    }

    /**
     * Kirajzolja a lövedéket
     * @param g Graphics osztály
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(source.getX(), source.getY(), source.getWidth(), source.getHeight());
        g2d.fillOval(source.getX(), source.getY(), source.getWidth(), source.getHeight());
    }
}
