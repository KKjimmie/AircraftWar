package edu.hitsz.aircraft;

import edu.hitsz.bullet.AbstractBullet;
import edu.hitsz.bullet.EnemyBullet;

import java.util.LinkedList;
import java.util.List;
/**
 * Boss敌机
 * 可以射击
 * @author 柯嘉铭
 */

public class Boss extends AbstractAircraft {

    private int shootNum = 3;
    private int power = 10; // 子弹伤害
    private int direction = 1; //子弹射击方向

    public Boss(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }


    @Override
    public List<AbstractBullet> shoot() {
        return null;
    }
}
