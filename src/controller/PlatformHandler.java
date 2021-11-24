package controller;

import model.Fps;
import model.FragilePlatform;
import model.MovingPlatform;
import model.Platform;
import view.DrawAble;
import view.FragilePlatformView;
import view.MovingPlatformView;
import view.PlatformView;

import java.util.ArrayList;
import java.util.Random;

public class PlatformHandler {

    CollisionDetector detector;
    ArrayList<DrawAble> drawAbles;
    ArrayList<Fps> movables;


    public PlatformHandler(CollisionDetector detector, ArrayList<DrawAble> drawAbles, ArrayList<Fps> movables) {
        this.detector = detector;
        this.drawAbles = drawAbles;
        this.movables = movables;


        newPlatform(100, 650);
    }

    public void newPlatform(int x, int y) {
        Platform p;

        double outcome = new Random().nextDouble();

        if (outcome < 0.8) {
            p = new Platform(x, y);
            PlatformView pView = new PlatformView(p);
            drawAbles.add(pView);
            p.setView(pView);
        } else if (outcome <= 0.9) {
            p = new MovingPlatform(x, y);
            MovingPlatformView pView = new MovingPlatformView(p);
            drawAbles.add(pView);
            p.setView(pView);
        } else {
            p = new FragilePlatform(x, y);
            FragilePlatformView pView = new FragilePlatformView(p);
            drawAbles.add(pView);
            p.setView(pView);
        }
        detector.addPlatform(p);
        movables.add(p);
    }

    public void checkPlatforms() {
        ArrayList<Platform> platforms = detector.getPlatforms();

        for (int i = 0; i < platforms.size(); i++) {
            Platform plat = platforms.get(i);
            if (plat.getY() > 750) {
                platforms.remove(plat);
                drawAbles.remove(plat.getView());
                movables.remove(plat);
            }
        }
    }
}
