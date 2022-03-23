package edu.hitsz.aircraft;

import edu.hitsz.application.Main;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.factory.PropFactory;
import edu.hitsz.props.AbstractProp;
import edu.hitsz.props.BloodProp;
import edu.hitsz.props.BombProp;
import edu.hitsz.props.BulletProp;

import java.util.LinkedList;
import java.util.List;

/**
 * 精英敌机，会射出子弹
 * @author 柯嘉铭
 */
public class EliteEnemy extends AbstractAircraft{

    /** 攻击方式 */
    private int power = 10;       //子弹伤害
    private int direction = 1;  //子弹射击方向 (向上发射：-1，向下发射：1)


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
        int rand = (int)(Math.random() * 2);
        if (rand == 0){
            // 暂时把不同道具的产生概率设为相同的
            int randProp = (int)(Math.random() * 3);
            switch (randProp){
                case 0 :
                    return PropFactory.produceBloodProp(this.getLocationX(),
                        this.getLocationY(),
                        10,
                        5
                );
                case 1 :
                    return PropFactory.produceBombProp(this.getLocationX(),
                        this.getLocationY(),
                        10,
                        5
                );
                case 2 :
                    return PropFactory.produceBulletProp(this.getLocationX(),
                        this.getLocationY(),
                        10,
                        5
                );
            }
        }
        return null;
    }
}
