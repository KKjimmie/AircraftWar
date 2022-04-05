package edu.hitsz.aircraft;

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
    }


    @Override
    public List<BaseBullet> shoot() {
        List<BaseBullet> res = new LinkedList<>();
        int x = this.getLocationX();
        int y = this.getLocationY();
        int speedX = 2;
        int speedY = direction * 5;
        BaseBullet baseBullet;
        for(int i=0; i<shootNum; i++){
            baseBullet = new EnemyBullet(x + (i*2 - shootNum + 1)*50, y,  speedX*(i-1), speedY, power);
            res.add(baseBullet);
        }
        return res;
    }

    public AbstractProp genProp(){
        // 击败boss，必掉落装备
        var r = new Random();
        int randProp = r.nextInt(3);
        switch (randProp){
            case 0 : return bloodPropFactory.produceProp(this.locationX, this.locationY, 10, 5);
            case 1 : return bombPropFactory.produceProp(this.locationX, this.locationY, 10, 5);
            case 2 : return bulletPropFactory.produceProp(this.locationX, this.locationY, 10, 5);
            default: return null;
        }
    }
}
