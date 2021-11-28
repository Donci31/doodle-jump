package view.platformviews;

import model.platforms.Platform;
import view.DrawAble;
import view.powerupviews.PowerUpView;

import javax.swing.*;
import java.awt.*;

/**
 * Sima platform képe
 */
public class PlatformView implements DrawAble {

    protected Platform source;

    protected Image image;

    protected PowerUpView powerUpView;

    public PlatformView(Platform source) {
        this.source = source;

        image = new ImageIcon(new ImageIcon("./resources/Platform.png").getImage().getScaledInstance(source.getWidth(), source.getHeight(), Image.SCALE_FAST)).getImage();
    }

    public void setPowerUpView(PowerUpView powerUpView) {
        this.powerUpView = powerUpView;
    }

    /**
     * Kirajzolja a platformot
     * @param g Grapics osztály
     */
    @Override
    public void draw(Graphics g) {
        if (source.getY() > 0) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(image, source.getX(), source.getY(), null);
            powerUpView.draw(g, source.getX(), source.getY());
        }
    }
}
