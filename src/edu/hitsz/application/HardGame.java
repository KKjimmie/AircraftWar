package edu.hitsz.application;

import edu.hitsz.aircraft.HeroAircraft;

public class HardGame extends Game{

    public HardGame() {
        super();
    }

    @Override
    protected void initGameMode() {
        // 获取背景
        backGround = ImageManager.BACKGROUND_IMAGE_5;

        Settings.getInstance().enemyMaxNumber = 10;
        // 英雄机
        HeroAircraft.getInstance().setHeroHp(5000);
        HeroAircraft.getInstance().setShootNum(1);
        Settings.getInstance().bulletSpeedY = 15;
        Settings.getInstance().enemyMaxNumber = 10;
        Settings.getInstance().isDecreaseShootNum = true;

        // 精英机
        Settings.getInstance().eliteEnemyHp = 60;
        Settings.getInstance().eliteEnemyPower = 10;
        Settings.getInstance().eliteEnemySpeedX = 5;
        Settings.getInstance().eliteShootNum = 1;

        // 普通敌机
        Settings.getInstance().mobEnemyHp = 60;
        Settings.getInstance().mobEnemySpeedY = 5;

        // 道具
        Settings.getInstance().propSpeedX = 5;
        Settings.getInstance().propDropRate = 0.5;
        Settings.getInstance().propBounceNum = 2;

        // Boss
        Settings.getInstance().isLeverUp = true;
        Settings.getInstance().bossHp = 600;
        Settings.getInstance().bossPower = 10;
        Settings.getInstance().scoreToBoss = 1000;
    }

    @Override
    protected void changeBackground() {
        switch ((bossFactory.getBossLevel() % 3)){
            case 0 :
                if(backGround != ImageManager.BACKGROUND_IMAGE_2) {
                    backGround = ImageManager.BACKGROUND_IMAGE_2;
                }
                break;
            case 1 :
                if(backGround != ImageManager.BACKGROUND_IMAGE_5){
                    backGround = ImageManager.BACKGROUND_IMAGE_5;
                }
                break;
            case 2 :
                if(backGround != ImageManager.BACKGROUND_IMAGE_4){
                    backGround = ImageManager.BACKGROUND_IMAGE_4;
                }
                break;
            default: backGround = ImageManager.BACKGROUND_IMAGE_5;
        }
    }

    @Override
    protected void difficultyLevelUp() {
        if(! bossExistFlag && time % Settings.getInstance().timeToGameLevelUp == 0 && time > 0){
            if(Settings.getInstance().timeToElite > 5 * Settings.getInstance().cycleDuration){
                Settings.getInstance().timeToElite -= (int )(1.5 * cycleDuration);
                System.out.println("精英机产生周期缩短！");
            }
            if(Settings.getInstance().eliteEnemySpeedY <= Settings.getInstance().maxEliteSpeedY){
                System.out.println("精英机速度提升！");
                Settings.getInstance().eliteEnemySpeedY ++;
                Settings.getInstance().eliteEnemySpeedX ++;
            }
            if(Settings.getInstance().mobEnemySpeedY <= Settings.getInstance().maxMobSpeedY){
                System.out.println("普通敌机速度提升！");
                Settings.getInstance().mobEnemySpeedY ++;
            }
            if(time % (5 *Settings.getInstance().timeToGameLevelUp) == 0){
                if(Settings.getInstance().eliteEnemyHp <= Settings.getInstance().maxEliteHp){
                    System.out.println("精英机血量提升！");
                    Settings.getInstance().eliteEnemyHp += 10;
                }
                if(Settings.getInstance().eliteShootNum < Settings.getInstance().maxEliteShootNum){
                    System.out.println("精英机子弹数目提升！");
                    Settings.getInstance().eliteShootNum ++;
                }
                if(Settings.getInstance().eliteEnemyPower < 40){
                    System.out.println("精英机子弹伤害提升！");
                    Settings.getInstance().eliteEnemyPower += 10;
                }
                if(Settings.getInstance().propDropRate > 0.2){
                    Settings.getInstance().propDropRate -= 0.05;
                }
            }
            System.out.println("---------------------------------------");
        }
    }
}
