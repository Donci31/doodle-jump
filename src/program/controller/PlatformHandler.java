package program.controller;

import com.google.gson.Gson;
import program.model.*;
import program.model.platforms.FragilePlatform;
import program.model.platforms.MovingPlatform;
import program.model.platforms.Platform;
import program.model.powerups.*;
import program.view.DrawAble;
import program.view.platformviews.FragilePlatformView;
import program.view.platformviews.MovingPlatformView;
import program.view.platformviews.PlatformView;
import program.view.powerupviews.*;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Platformok fileból való beolvasása, karbantartása
 */
public class PlatformHandler {

    private final CollisionDetector detector;
    private final ArrayList<DrawAble> drawAbles;
    private final ArrayList<Fps> movables;

    private final Map<String, AddPlatform> platChooser;

    private final Map<String, AddPowerUp> chooser;

    public PlatformHandler(CollisionDetector detector, ArrayList<DrawAble> drawAbles, ArrayList<Fps> movables) {
        this.detector = detector;
        this.drawAbles = drawAbles;
        this.movables = movables;

        platChooser = new TreeMap<>();

        chooser = new TreeMap<>();

        platChooser.put("default", this::addDefault);
        platChooser.put("moving", this::addMoving);
        platChooser.put("fragile", this::addFragile);

        chooser.put("default", this::addDefault);
        chooser.put("jetpack", this::addJetPack);
        chooser.put("propeller", this::addPropeller);
        chooser.put("trampoline", this::addTrampoline);
        chooser.put("spring", this::Spring);

        PlatformData[] data = platformLoader();

        for(PlatformData plat : data) {
            newPlatform(plat.type, plat.powerUp, plat.x, plat.y);
        }

        for(PlatformData plat : data) {
            newPlatform(plat.type, plat.powerUp, plat.x, plat.y - 2800);
        }

        for(PlatformData plat : data) {
            newPlatform(plat.type, plat.powerUp, plat.x, plat.y - 4500);
        }
    }

    /**
     * Új platformot rak a játékba
     * @param type Platform típusa szövegként
     * @param powerUp Powerup típusa szövegként
     * @param x Platform x koordinátája
     * @param y Platform y koordinátája
     */
    private void newPlatform(String type, String powerUp, int x, int y) {
        platChooser.get(type).add(powerUp, x, y);
    }

    private void addDefault(String powerUp, int x, int y) {
        Platform p = new Platform(x, y);
        chooser.get(powerUp).add(p);

        detector.addPlatform(p);
        movables.add(p);
    }

    private void addMoving(String powerUp, int x, int y) {
        Platform p = new MovingPlatform(x, y);
        MovingPlatformView pView = new MovingPlatformView(p);
        pView.setPowerUpView(new PowerUpView());
        drawAbles.add(pView);
        p.setView(pView);

        detector.addPlatform(p);
        movables.add(p);
    }

    private void addFragile(String powerUp, int x, int y) {
        Platform p = new FragilePlatform(x, y);
        FragilePlatformView pView = new FragilePlatformView(p);
        pView.setPowerUpView(new PowerUpView());
        drawAbles.add(pView);
        p.setView(pView);

        detector.addPlatform(p);
        movables.add(p);
    }

    private void addDefault(Platform p) {
        p.setPowerUp(new DefaultPowerUp());
        PlatformView pView = new PlatformView(p);
        pView.setPowerUpView(new PowerUpView());
        drawAbles.add(pView);
        p.setView(pView);
    }

    private void addJetPack(Platform p) {
        p.setPowerUp(new JetPackPowerUp());
        PlatformView pView = new PlatformView(p);
        pView.setPowerUpView(new JetPackView());
        drawAbles.add(pView);
        p.setView(pView);
    }

    private void addPropeller(Platform p) {
        p.setPowerUp(new PropellerPowerUp());
        PlatformView pView = new PlatformView(p);
        pView.setPowerUpView(new PropellerView());
        drawAbles.add(pView);
        p.setView(pView);
    }

    private void addTrampoline(Platform p) {
        p.setPowerUp(new TrampolinePowerUp());
        PlatformView pView = new PlatformView(p);
        pView.setPowerUpView(new TrampolineView());
        drawAbles.add(pView);
        p.setView(pView);
    }

    private void Spring(Platform p) {
        p.setPowerUp(new SpringPowerUp());
        PlatformView pView = new PlatformView(p);
        pView.setPowerUpView(new SpringView());
        drawAbles.add(pView);
        p.setView(pView);
    }

    /**
     * Segédfüggvény a filebeolvasásra
     * @return platform adatokat tartalmazó tömb
     */
    private PlatformData[] platformLoader() {
        String content = null;

        try {
            content = Files.readString(Path.of("./resources/platforms.json"), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();

        return gson.fromJson(content, PlatformData[].class);
    }

    /**
     * Ha egy paltform kikerül a képernyőről akkor kitörli.
     * Kevés platform esetén újakat olvas be fileból.
     */
    public void checkPlatforms() {
        ArrayList<Platform> platforms = detector.getPlatforms();

        for (int i = 0; i < platforms.size(); i++) {
            Platform plat = platforms.get(i);
            if (plat.getY() > 700) {
                platforms.remove(plat);
                drawAbles.remove(plat.getView());
                movables.remove(plat);
            }
        }

        if (platforms.size() <= 20) {
            PlatformData[] data = platformLoader();
            int relativeY = platforms.get(platforms.size() - 1).getY() - 1100;

            for (PlatformData plat : data) {
                plat.y += relativeY;
                newPlatform(plat.type, plat.powerUp, plat.x, plat.y);
            }
        }
    }
}
