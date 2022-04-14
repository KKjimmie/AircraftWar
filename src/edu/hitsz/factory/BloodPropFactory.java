package edu.hitsz.factory;

import edu.hitsz.application.Settings;
import edu.hitsz.props.AbstractProp;
import edu.hitsz.props.BloodProp;

/**
 * 加血道具工厂
 * @author 柯嘉铭
 */
public class BloodPropFactory implements ProduceProp {
    @Override
    public AbstractProp produceProp(int locationX, int locationY) {
        int speedX = Settings.propSpeedX;
        int speedY = Settings.propSpeedY;
        return new BloodProp(locationX, locationY, speedX, speedY);
    }
}
