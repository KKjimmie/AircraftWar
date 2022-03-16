package edu.hitsz.props;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.basic.FlyingObject;

/**
 * 抽象道具类
 * @author 柯嘉铭
 */

public abstract class AbstractProp extends FlyingObject {

    public AbstractProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    /**
     * 抽象道具作用
     * @param heroAircraft 英雄机
     */
    public abstract void work(HeroAircraft heroAircraft);
}
