package program.view.platformviews;

import program.model.platforms.Platform;

import javax.swing.*;
import java.awt.*;

/**
 * Mozgó platform képe
 */
public class MovingPlatformView extends PlatformView {
    public MovingPlatformView(Platform platform) {
        super(platform);

        image = new ImageIcon(new ImageIcon("./resources/MovingPlatform.png").getImage().getScaledInstance(source.getWidth(), source.getHeight(), Image.SCALE_FAST)).getImage();
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
        }
    }
}
