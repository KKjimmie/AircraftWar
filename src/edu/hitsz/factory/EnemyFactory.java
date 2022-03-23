package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.Boss;
import edu.hitsz.aircraft.EliteEnemy;
import edu.hitsz.aircraft.MobEnemy;

/**
 * 敌机工厂类，用于生产敌机
 */
public class EnemyFactory {

    /**
     * 生产普通敌机
     * @param locationX
     * @param locationY
     * @param speedX
     * @param speedY
     * @param hp
     * @return MobEnemy
     */
    public static AbstractAircraft produceMobEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        return new MobEnemy(locationX, locationY, speedX, speedY, hp);
    }

    /**
     * 生产精英敌机
     * @param locationX
     * @param locationY
     * @param speedX
     * @param speedY
     * @param hp
     * @return EliteEnemy
     */
    public static AbstractAircraft produceEliteEnemy(int locationX, int locationY, int speedX, int speedY, int hp) {
        return new EliteEnemy(locationX, locationY, speedX, speedY, hp);
    }

    /**
     * 生产boss敌机
     * @param locationX
     * @param locationY
     * @param speedX
     * @param speedY
     * @param hp
     * @return Boss
     */
    public static AbstractAircraft produceBoss(int locationX, int locationY, int speedX, int speedY, int hp) {
        return new Boss(locationX, locationY, speedX, speedY, hp);
    }
}
