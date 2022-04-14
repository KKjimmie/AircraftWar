package edu.hitsz.factory;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.Boss;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.application.Settings;

/**
 * Boss工厂
 * @author 柯嘉铭
 */
public class BossFactory implements ProduceEnemy {

    private int bossLevel = 1;

    private void bossLevelUp() {
        this.bossLevel ++;
    }

    public int getBossLevel() {
        return bossLevel;
    }

    public void setBossLevel(int bossLevel) {
        this.bossLevel = bossLevel;
    }

    @Override
    public AbstractAircraft produceEnemy() {
        int locationX = (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.BOSS_IMAGE.getWidth()));
        int locationY = (int) (Math.random() * Main.WINDOW_WIDTH * 0.1);
        int speedX = Settings.bossSpeedX;
        int speedY = Settings.bossSpeedY;
        int hp = Settings.bossHp * bossLevel;
        bossLevelUp();
        return new Boss(locationX, locationY, speedX, speedY, hp);
    }
}
