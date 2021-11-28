package view.platformviews;

import model.platforms.Platform;

import java.awt.*;

/**
 * Törékeny platform képe
 */
public class FragilePlatformView extends PlatformView {
    public FragilePlatformView(Platform platform) {
        super(platform);
    }

    /**
     * Kirajzolja a platformot
     * @param g Grapics osztály
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(source.getX(), source.getY(), source.getWidth(), source.getHeight());
        g2d.setColor(Color.black);
        g2d.fillRect(source.getX(), source.getY(), source.getWidth(), source.getHeight());
    }
}
