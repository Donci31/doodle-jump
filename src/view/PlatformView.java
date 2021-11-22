package view;

import model.Platform;

import java.awt.*;

public class PlatformView implements DrawAble {

    private Platform source;

    public PlatformView(Platform source) {
        this.source = source;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(source.getX(), source.getY(), 100, 20);
    }
}
