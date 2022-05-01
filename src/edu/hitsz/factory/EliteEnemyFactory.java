package edu.hitsz.factory;

import edu.hitsz.UI.MainFrame;
import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.EliteEnemy;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Settings;

/**
 * 精英机工厂
 * @author 柯嘉铭
 */
public class EliteEnemyFactory implements ProduceEnemy {

    @Override
    public AbstractAircraft produceEnemy() {
        int locationX = (int) (Math.random() * (MainFrame.WINDOW_WIDTH - ImageManager.ELITE_ENEMY_IMAGE.getWidth()));
        int locationY = (int) (Math.random() * MainFrame.WINDOW_HEIGHT * 0.2);
        int speedX = Settings.getInstance().eliteEnemySpeedX;
        int speedY = Settings.getInstance().eliteEnemySpeedY;
        int hp = Settings.getInstance().eliteEnemyHp;
        return new EliteEnemy(locationX, locationY, speedX, speedY, hp);
    }
}
