package model;

import java.util.ArrayList;

public class Game implements Fps {
    private final int height = 750;
    private final int width = 500;

    private final Doodle doodle;

    private final ArrayList<Monster> monsters;

    private final ArrayList<Platform> platforms;

    private final ArrayList<Fps> movables;

    public Game(Doodle doodle) {
        this.doodle = doodle;
        monsters = new ArrayList<>();
        platforms = new ArrayList<>();
        movables = new ArrayList<>();

        movables.add(doodle);
    }

    @Override
    public void tick() {
        for (Fps f : movables) {
            f.tick();
        }
    }
}
