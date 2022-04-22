package edu.hitsz.aircraft;

import edu.hitsz.application.Main;
import edu.hitsz.application.Settings;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.factory.BloodPropFactory;
import edu.hitsz.factory.BombPropFactory;
import edu.hitsz.factory.BulletPropFactory;
import edu.hitsz.props.AbstractProp;
import edu.hitsz.shootStrategy.DirectShoot;

import java.util.List;
import java.util.Random;

/**
 * 精英敌机，会射出子弹
 * @author 柯嘉铭
 */
public class EliteEnemy extends AbstractAircraft{

    /** 攻击方式 */
    private int power = Settings.getInstance().eliteEnemyPower;
    private int direction = 1;
    private int shootNum = Settings.getInstance().eliteShootNum;

    private final BloodPropFactory bloodPropFactory = new BloodPropFactory();
    private final BombPropFactory bombPropFactory = new BombPropFactory();
    private final BulletPropFactory bulletPropFactory = new BulletPropFactory();


    public EliteEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        this.setStrategy(new DirectShoot());
    }

    @Override
    public void forward() {
        super.forward();
        // 判定 y 轴向下飞行出界
        if (locationY >= Main.WINDOW_HEIGHT ) {
            vanish();
        }
    }

    /**
     * 精英敌机产生道具
     */
    public AbstractProp genProp () {
        var r = new Random();
        double rand = r.nextDouble();
        if (rand < Settings.getInstance().propDropRate){
            int randProp = r.nextInt(3);
            switch (randProp){
                case 0 : return bloodPropFactory.produceProp(this.locationX, this.locationY);
                case 1 : return bombPropFactory.produceProp(this.locationX, this.locationY);
                case 2 : return bulletPropFactory.produceProp(this.locationX, this.locationY);
                default: return null;
            }
        }
        return null;
    }

    @Override
    public List<BaseBullet> shoot() {
        return strategy.shootMode(false, this.locationX, this.locationY, this.direction, this.power, this.shootNum);
    }
}
