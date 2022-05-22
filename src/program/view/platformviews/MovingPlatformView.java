package program.view.platformviews;

import program.model.platforms.Platform;
import program.view.DoodleView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Mozgó platform képe
 */
public class MovingPlatformView extends PlatformView {

    private static Image image;

    static {
        try {
            image = ImageIO.read(MovingPlatformView.class.getClassLoader().getResource("MovingPlatform.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MovingPlatformView(Platform platform) {
        super(platform);
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
        }
    }
}
