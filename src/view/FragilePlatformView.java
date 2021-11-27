package view;

import model.platforms.Platform;

import java.awt.*;

public class FragilePlatformView extends PlatformView {
    public FragilePlatformView(Platform platform) {
        super(platform);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(source.getX(), source.getY(), 100, 20);
        g2d.drawOval(source.getX(), source.getY(), 100, 20);
    }
}
