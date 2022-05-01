package edu.hitsz.factory;

import edu.hitsz.UI.MainFrame;
import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.MobEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Settings;

/**
 * 普通敌机工厂
 * @author 柯嘉铭
 */
public class MobEnemyFactory implements ProduceEnemy {
    @Override
    public AbstractAircraft produceEnemy() {
        int locationX = (int) (Math.random() * (MainFrame.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth()));
        int locationY = (int) (Math.random() * MainFrame.WINDOW_HEIGHT * 0.2);
        int speedX = Settings.getInstance().mobEnemySpeedX;
        int speedY = Settings.getInstance().mobEnemySpeedY;
        int hp = Settings.getInstance().mobEnemyHp;
        return new MobEnemy(locationX, locationY, speedX, speedY, hp);
    }
}
