package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.factory.BloodPropFactory;
import edu.hitsz.factory.BombPropFactory;
import edu.hitsz.factory.BulletPropFactory;
import edu.hitsz.props.AbstractProp;
import edu.hitsz.shootStrategy.ScatteredShoot;

import java.util.List;
import java.util.Random;

/**
 * Boss敌机
 * 可以射击
 * @author 柯嘉铭
 */

public class Boss extends AbstractAircraft {

    private int shootNum = 3;
    private int power = 20;
    private int direction = 1;

    private final BloodPropFactory bloodPropFactory = new BloodPropFactory();
    private final BombPropFactory bombPropFactory = new BombPropFactory();
    private final BulletPropFactory bulletPropFactory = new BulletPropFactory();

    public Boss(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        this.setStrategy(new ScatteredShoot());
    }

    @Override
    public List<BaseBullet> shoot() {
            return strategy.shootMode(false, this.locationX, this.locationY, this.direction, this.power, this.shootNum);
    }


    public AbstractProp genProp(){
        // 击败boss，必掉落装备
        var r = new Random();
        int randProp = r.nextInt(3);
        switch (randProp){
            case 0 : return bloodPropFactory.produceProp(this.locationX, this.locationY);
            case 1 : return bombPropFactory.produceProp(this.locationX, this.locationY);
            case 2 : return bulletPropFactory.produceProp(this.locationX, this.locationY);
            default: return null;
        }
    }
}
