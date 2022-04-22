package edu.hitsz.application;

import edu.hitsz.aircraft.HeroAircraft;

import java.awt.image.BufferedImage;

/**
 * 用于保存游戏相关参数设定的类
 * @author 柯嘉铭
 */
public class Settings {
    public static final int EASY_MODE = 0;
    public static final int COMMON_MODE = 1;
    public static final int HARD_MODE = 2;

    public static final boolean SOUND_ON = true;
    public static final boolean SOUND_OFF = false;

    private volatile static Settings instance = null;

    private int gameMode = EASY_MODE;
    private boolean isSoundOn = SOUND_ON;

    /*
     * 英雄机设置
     */
    public int heroHp = Integer.MAX_VALUE;
    public int heroSpeedX = 0;
    public int heroSpeedY = 0;
    public int heroPower = 30;
    public int initShootNum = 3;
    public int maxShootNum = 3;

    /*
     * 普通敌机设置
     */
    public int mobEnemyHp = 30;
    public int mobEnemySpeedX = 0;
    public int mobEnemySpeedY = 10;

    /*
     * 精英敌机设置
     */
    public int eliteEnemyHp = 60;
    public int eliteEnemySpeedX = 10;
    public int eliteEnemySpeedY = 3;
    public int eliteEnemyPower = 10;
    public int eliteShootNum = 1;

    /*
     * Boss机设置
     */
    public int bossHp = 600;
    public int bossSpeedX = 5;
    public int bossSpeedY = 0;
    public int scoreToBoss = 500;
    public int bossPower = 20;

    /*
     * 道具设置
     */
    public int propSpeedX = 0;
    public int propSpeedY = 5;
    /**
     * 道具y轴反弹次数
     */
    public int propBounceNum = 0;
    /**
     * 道具跌落率
     */
    public double propDropRate = 0.9;
    /**
     * 子弹道具增加子弹数量
     */
    public int bulletPlus = 1;
    /**
     * 加血道具增加血量数
     */
    public int hpPlus = 10;

    /**
     * 子弹伤害设置
     */
    public int baseBulletPower = 10;
    public int bulletSpeedY = 9;

    private Settings() {
    }

    public static Settings getInstance(){
        if(instance == null){
            synchronized (Settings.class){
                if(instance == null) {
                    instance = new Settings();
                }
            }
        }
        return instance;
    }

    public int getGameMode() {
        return gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
        if (gameMode == 1) {
            // 英雄机
            HeroAircraft.getInstance().setHeroHp(2000);
            HeroAircraft.getInstance().setShootNum(2);

            // 普通敌机
            mobEnemyHp = 2 * mobEnemyHp;
            mobEnemySpeedY = 2 * mobEnemySpeedY;

            // 精英机
            eliteEnemyHp = 2 * eliteEnemyHp;
            eliteEnemyPower = 2 * eliteEnemyPower;
            eliteEnemySpeedX = 2 * eliteEnemySpeedX;
            eliteShootNum = 2;

            // Boss
            bossHp = 2 * bossHp;
            bossPower = 2 * bossPower;
            scoreToBoss = 2 * scoreToBoss;
        }else if (gameMode == 2){
            // 英雄机
            HeroAircraft.getInstance().setHeroHp(5000);
            HeroAircraft.getInstance().setShootNum(1);

            // 普通敌机
            mobEnemyHp = 3 * mobEnemyHp;
            mobEnemySpeedY = 2 * mobEnemySpeedY;

            // 精英机
            eliteEnemyHp = 3 * eliteEnemyHp;
            eliteEnemyPower = 3 * eliteEnemyPower;
            eliteEnemySpeedX = 2 * eliteEnemySpeedX;
            eliteShootNum = 2;

            // Boss
            bossHp = 3 * bossHp;
            bossPower = 2 * bossPower;
            scoreToBoss = 2 * scoreToBoss;
        }
    }

    public String getDiff(){
        String diff;
        switch (gameMode){
            case EASY_MODE:
                diff = "EASY";
                break;
            case COMMON_MODE:
                diff = "COMMON";
                break;
            case HARD_MODE:
                diff = "HARD";
                break;
            default: diff = null;
        }
        return diff;
    }

    public BufferedImage getBackground() {
        BufferedImage bg = null;
        switch(gameMode) {
            case EASY_MODE:
                bg = ImageManager.BACKGROUND_IMAGE_1;
                break;
            case COMMON_MODE:
                bg = ImageManager.BACKGROUND_IMAGE_2;
                break;
            case HARD_MODE:
                bg = ImageManager.BACKGROUND_IMAGE_3;
                break;
            default: bg = ImageManager.BACKGROUND_IMAGE_4;
        }
        return bg;
    }

    public void setSoundOn() {
        isSoundOn = SOUND_ON;
    }

    public void setSoundOff() {
        isSoundOn = SOUND_OFF;
    }
    public boolean getVideoState() {
        return isSoundOn;
    }
}
