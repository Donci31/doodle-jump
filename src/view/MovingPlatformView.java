package view;

import model.Platform;

import java.awt.*;

public class MovingPlatformView extends PlatformView {
    public MovingPlatformView(Platform platform) {
        super(platform);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(source.getX(), source.getY(), 100, 20);
        g2d.drawRect(source.getX(), source.getY(), 50, 20);
    }
}
