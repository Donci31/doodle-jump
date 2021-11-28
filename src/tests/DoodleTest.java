package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import program.model.Doodle;

import java.awt.*;

public class DoodleTest {
    Doodle doodle;
    @Before
    public void setUp() {
        doodle = new Doodle(100, 300);
    }
    @Test
    public void testTickVel() {
        doodle.tick();
        Assert.assertEquals(doodle.getVy(), 1);
    }

    @Test
    public void testTickPos() {
        doodle.tick();
        Assert.assertEquals(doodle.getX(), 100);
        Assert.assertEquals(doodle.getY(), 301);
    }

    @Test
    public void testHitbox() {
        Assert.assertEquals(doodle.getHitbox(), new Rectangle(100, 300, 125, 150));
    }
}