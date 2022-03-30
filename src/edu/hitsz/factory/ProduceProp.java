package edu.hitsz.factory;

import edu.hitsz.props.AbstractProp;

/**
 * 生成道具接口
 * @author 柯嘉铭
 */
public interface ProduceProp {
    /**
     *
     * @param locationX x
     * @param locationY y
     * @param speedX x速度
     * @param speedY y速度
     * @return AbstractProp
     */
    AbstractProp produceProp(int locationX, int locationY, int speedX, int speedY);
}
