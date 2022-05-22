package program.view.platformviews;

import program.model.platforms.Platform;
import program.view.DoodleView;
import program.view.DrawAble;
import program.view.powerupviews.PowerUpView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Sima platform képe
 */
public class PlatformView implements DrawAble {

    protected Platform source;

    private static Image image;

    static {
        try {
            image = ImageIO.read(PlatformView.class.getClassLoader().getResource("Platform.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ;

    protected PowerUpView powerUpView;

    public PlatformView(Platform source) {
        this.source = source;
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
            g2d.drawImage(image, source.getX(), source.getY(), source.getWidth(), source.getHeight(), null);
            powerUpView.draw(g, source.getX(), source.getY());
        }
    }
}
