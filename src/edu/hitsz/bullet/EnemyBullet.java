package edu.hitsz.bullet;

import edu.hitsz.basic.CanBoom;

/**
 * @Author hitsz
 */
public class EnemyBullet extends BaseBullet implements CanBoom {

    public EnemyBullet(int locationX, int locationY, int speedX, int speedY, int power) {
        super(locationX, locationY, speedX, speedY, power);
    }

    @Override
    public void boom() {
        vanish();
    }
}
