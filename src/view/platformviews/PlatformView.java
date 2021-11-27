package view.platformviews;

import model.platforms.Platform;
import view.DrawAble;
import view.powerupviews.PowerUpView;

import javax.swing.*;
import java.awt.*;

public class PlatformView implements DrawAble {

    protected Platform source;

    protected Image image;

    protected PowerUpView powerUpView;

    public PlatformView(Platform source) {
        this.source = source;

        image = new ImageIcon(new ImageIcon("./resources/Platform.png").getImage().getScaledInstance(source.getWidth(), source.getHeight(), Image.SCALE_SMOOTH)).getImage();
    }

    public void setPowerUpView(PowerUpView powerUpView) {
        this.powerUpView = powerUpView;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, source.getX(), source.getY(), null);
        powerUpView.draw(g, source.getX(), source.getY());
    }
}