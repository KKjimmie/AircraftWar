package edu.hitsz.factory;

import edu.hitsz.props.AbstractProp;
import edu.hitsz.props.BulletProp;

/**子弹道具类工厂
 * @author 柯嘉铭
 */
public class BulletPropFactory implements ProduceProp {
    @Override
    public AbstractProp produceProp(int locationX, int locationY, int speedX, int speedY) {
        return new BulletProp(locationX, locationY, speedX, speedY);
    }
}
