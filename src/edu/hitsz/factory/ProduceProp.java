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
     * @return AbstractProp
     */
    AbstractProp produceProp(int locationX, int locationY);
}
