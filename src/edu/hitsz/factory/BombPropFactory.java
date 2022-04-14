package edu.hitsz.factory;

import edu.hitsz.application.Settings;
import edu.hitsz.props.AbstractProp;
import edu.hitsz.props.BombProp;

/**
 * 炸弹道具工厂
 * @author 柯嘉铭
 */
public class BombPropFactory implements ProduceProp {
    @Override
    public AbstractProp produceProp(int locationX, int locationY) {
        int speedX = Settings.propSpeedX;
        int speedY = Settings.propSpeedY;
        return new BombProp(locationX, locationY, speedX, speedY);
    }
}
