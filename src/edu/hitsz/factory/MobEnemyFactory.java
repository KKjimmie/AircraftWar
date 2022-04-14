package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.MobEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.application.Settings;

/**
 * 普通敌机工厂
 * @author 柯嘉铭
 */
public class MobEnemyFactory implements ProduceEnemy {
    @Override
    public AbstractAircraft produceEnemy() {
        int locationX = (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth()));
        int locationY = (int) (Math.random() * Main.WINDOW_HEIGHT * 0.2);
        int speedX = Settings.mobEnemySpeedX;
        int speedY = Settings.mobEnemySpeedY;
        int hp = Settings.mobEnemyHp;
        return new MobEnemy(locationX, locationY, speedX, speedY, hp);
    }
}
