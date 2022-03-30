package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.Boss;

/**
 * Boss工厂
 * @author 柯嘉铭
 */
public class BossFactory implements ProduceEnemy {

    @Override
    public AbstractAircraft produceEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        return new Boss(locationX, locationY, speedX, speedY, hp);
    }
}
