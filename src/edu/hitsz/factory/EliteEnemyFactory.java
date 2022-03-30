package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.EliteEnemy;

/**
 * 精英机工厂
 * @author 柯嘉铭
 */
public class EliteEnemyFactory implements ProduceEnemy {

    @Override
    public AbstractAircraft produceEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        return new EliteEnemy(locationX, locationY, speedX, speedY, hp);
    }
}
