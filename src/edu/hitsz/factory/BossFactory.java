package edu.hitsz.factory;

import edu.hitsz.UI.MainFrame;
import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.Boss;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Settings;

/**
 * Boss工厂
 * @author 柯嘉铭
 */
public class BossFactory implements ProduceEnemy {

    private int bossLevel = 1;

    private void bossLevelUp() {
        System.out.println("Boss等级：" + bossLevel);
        this.bossLevel ++;
        if(Settings.getInstance().isLeverUp){
            if(Settings.getInstance().bossPower < 100){
                Settings.getInstance().bossPower += 10;
            }
        }
    }

    public int getBossLevel() {
        return bossLevel;
    }

    public void setBossLevel(int bossLevel) {
        this.bossLevel = bossLevel;
    }

    @Override
    public AbstractAircraft produceEnemy() {
        int locationX = (int) (Math.random() * (MainFrame.WINDOW_WIDTH - ImageManager.BOSS_IMAGE.getWidth()));
        int locationY = (int) (Math.random() * MainFrame.WINDOW_WIDTH * 0.1);
        int speedX = Settings.getInstance().bossSpeedX;
        int speedY = Settings.getInstance().bossSpeedY;
        int hp = Settings.getInstance().bossHp * bossLevel;
        bossLevelUp();
        return new Boss(locationX, locationY, speedX, speedY, hp);
    }
}
