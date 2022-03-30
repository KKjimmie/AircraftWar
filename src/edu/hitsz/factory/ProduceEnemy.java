package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;

/**
 * 作为敌机工厂的接口
 * @author 柯嘉铭
 */
public interface ProduceEnemy {
    AbstractAircraft produceEnemy(int locationX, int locationY, int speedX, int speedY, int hp);
}
