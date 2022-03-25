package edu.hitsz.factory;

import edu.hitsz.props.AbstractProp;
import edu.hitsz.props.BloodProp;
import edu.hitsz.props.BombProp;
import edu.hitsz.props.BulletProp;

/**
 * 道具工厂类，用于生产道具
 *
 * @author 柯嘉铭
 */
public class PropFactory {

    /**
     * 生产加血道具
     * @param locationX
     * @param locationY
     * @param speedX
     * @param speedY
     * @return BloodProp
     */
    public static AbstractProp produceBloodProp (int locationX, int locationY, int speedX, int speedY){
        return new BloodProp(locationX, locationY, speedX, speedY);
    }

    /**
     * 生产炸弹道具
     * @param locationX
     * @param locationY
     * @param speedX
     * @param speedY
     * @return BombProp
     */
    public static AbstractProp produceBombProp(int locationX, int locationY, int speedX, int speedY){
        return new BombProp(locationX, locationY, speedX, speedY);
    }

    /**
     * 生产子弹道具
     * @param locationX
     * @param locationY
     * @param speedX
     * @param speedY
     * @return BulletProp
     */
    public static AbstractProp produceBulletProp (int locationX, int locationY, int speedX, int speedY){
        return new BulletProp(locationX, locationY, speedX, speedY);
    }


    /**
     * 根据位置及速度参数，随机产生一种道具
     * @param locationX
     * @param locationY
     * @param speedX
     * @param speedY
     * @return AbstractProp
     */
    public static AbstractProp producePropRandomly (int locationX, int locationY, int speedX, int speedY){
        /*
         每种道具产生概率相同
         */
        int randProp = (int)(Math.random() * 3);
        switch (randProp){
            case 0 : return new BloodProp(locationX, locationY, speedX, speedY);
            case 1 : return new BombProp(locationX, locationY, speedX, speedY);
            case 2 : return new BulletProp(locationX, locationY, speedX, speedY);
            default: return null;
        }
    }
}
