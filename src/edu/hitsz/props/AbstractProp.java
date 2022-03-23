package edu.hitsz.props;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.Main;
import edu.hitsz.basic.AbstractFlyingObject;

/**
 * 抽象道具类
 * @author 柯嘉铭
 */

public abstract class AbstractProp extends AbstractFlyingObject {

    protected int bounceNum = 2; // 设置道具y轴反弹次数

    public AbstractProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    /**
     * 抽象道具作用
     * @param heroAircraft 英雄机
     */
    public abstract void work(HeroAircraft heroAircraft);

    @Override
    public void forward () {
        // 让道具能够反弹
        super.forward();
        if (bounceNum >= 0 && (locationY <= 0 || locationY >= Main.WINDOW_HEIGHT)) {
            speedY = -speedY;
            bounceNum --;
        }
        // 没有反弹次数时，道具超出y轴边界消失
        if (bounceNum < 0 && (locationY <= 0 || locationY >= Main.WINDOW_HEIGHT)) {
            vanish();
        }

    }

}
