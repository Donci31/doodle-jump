package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import program.model.Bullet;

import java.awt.*;

public class BulletTest {
    Bullet bullet;

    @Before
    public void setUp() {
        bullet = new Bullet(100, 100, 2, 2);
    }

    @Test
    public void testBounds() {
        Assert.assertEquals(bullet.getBounds(), new Rectangle(100, 100, 20, 20));
    }

    @Test
    public void testHasHit() {
        Assert.assertFalse(bullet.hasHit());
        bullet.hit();
        Assert.assertNotEquals(bullet.hasHit(), false);
    }

    @Test
    public void testTick() {
        bullet.tick();
        Assert.assertEquals(bullet.getX(), 102);
        Assert.assertEquals(bullet.getY(), 103);
    }
}
