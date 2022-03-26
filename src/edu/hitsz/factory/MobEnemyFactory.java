package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.MobEnemy;

/**
 * 普通敌机工厂
 * @author 柯嘉铭
 */
public class MobEnemyFactory implements produceEnemy {
    @Override
    public AbstractAircraft produceEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        return new MobEnemy(locationX, locationY, speedX, speedY, hp);
    }
}
