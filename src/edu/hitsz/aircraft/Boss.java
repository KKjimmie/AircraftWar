package edu.hitsz.aircraft;

import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;
import edu.hitsz.factory.PropFactory;
import edu.hitsz.props.AbstractProp;

import java.util.LinkedList;
import java.util.List;
/**
 * Boss敌机
 * 可以射击
 * @author 柯嘉铭
 */

public class Boss extends AbstractAircraft {

    private int shootNum = 3;
    private int power = 20; // 子弹伤害
    private int direction = 1; //子弹射击方向

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
            baseBullet = new EnemyBullet(x + (i*2 - shootNum + 1)*10, y,  speedX*(i-1), speedY, power);
            res.add(baseBullet);
        }
        return res;
    }

    public AbstractProp genProp(){
        // 击败boss，必掉落装备
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
        return null;
    }
}
