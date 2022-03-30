package edu.hitsz.aircraft;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.factory.BloodPropFactory;
import edu.hitsz.factory.BombPropFactory;
import edu.hitsz.factory.BulletPropFactory;
import edu.hitsz.props.AbstractProp;
import edu.hitsz.props.BloodProp;
import edu.hitsz.props.BombProp;
import edu.hitsz.props.BulletProp;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 精英敌机，会射出子弹
 * @author 柯嘉铭
 */
public class EliteEnemy extends AbstractAircraft{

    /** 攻击方式 */
    private int power = 10;
    private int direction = 1;

    private final BloodPropFactory bloodPropFactory = new BloodPropFactory();
    private final BombPropFactory bombPropFactory = new BombPropFactory();
    private final BulletPropFactory bulletPropFactory = new BulletPropFactory();


    public EliteEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    @Override
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }

    @Override
    public List<BaseBullet> shoot() {
        List<BaseBullet> res = new LinkedList<>();
        int x = this.getLocationX();
        int y = this.getLocationY() + direction*2;
        int speedX = 0;
        int speedY = this.getSpeedY() + direction*5;
        BaseBullet baseBullet = new EnemyBullet( x, y, speedX, speedY, power);
        res.add(baseBullet);
        return res;
    }

    /**
     * 精英敌机产生道具
     */
    public AbstractProp genProp () {
        // 击败精英敌机，有50%概率产生道具
        var r = new Random();
        int rand = r.nextInt(2);
        if (rand == 0){
            int randProp = r.nextInt(3);
            switch (randProp){
                case 0 : return bloodPropFactory.produceProp(this.locationX, this.locationY, 10, 5);
                case 1 : return bombPropFactory.produceProp(this.locationX, this.locationY, 10, 5);
                case 2 : return bulletPropFactory.produceProp(this.locationX, this.locationY, 10, 5);
                default: return null;
            }
        }
        return null;
    }
}
