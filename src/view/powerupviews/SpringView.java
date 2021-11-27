package view.powerupviews;

import java.awt.*;

public class SpringView extends PowerUpView{
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(x + 30, y - 20, 40, 20);
        g2d.setColor(Color.gray);
        g2d.fillRect(x + 30, y - 20, 40, 20);
    }
}
