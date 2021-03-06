package edu.hitsz.application;


import java.awt.image.BufferedImage;

/**
 * 用于保存游戏相关参数设定的类
 * 同时可以根据难度设定相关参数
 * 单例模式实现
 * @author 柯嘉铭
 */
public class Settings {

    // 游戏难度常量
    public static final int EASY_MODE = 0;
    public static final int COMMON_MODE = 1;
    public static final int HARD_MODE = 2;

    // 音效开关常量
    public static final boolean SOUND_ON = true;
    public static final boolean SOUND_OFF = false;

    // 单例
    private volatile static Settings instance = null;

    // 默认游戏模式及音效设置
    private int gameMode = EASY_MODE;
    private boolean isSoundOn = SOUND_ON;

    // 相关设置
    public int timeInterval = 40;
    public int enemyMaxNumber = 5;
    public int cycleDuration = 600;
    public int timeToElite = 15 * cycleDuration;
    public int timeToGameLevelUp = 20 * cycleDuration;


    /*
     * 英雄机设置
     */
    public int heroHp = Integer.MAX_VALUE;
    public int maxHeroHp = Integer.MAX_VALUE;
    public int heroSpeedX = 0;
    public int heroSpeedY = 0;
    public int heroPower = 30;
    public int initShootNum = 3;
    public int maxShootNum = 3;
    public boolean isDecreaseShootNum = false;

    /*
     * 普通敌机设置
     */
    public int mobEnemyHp = 30;
    public int mobEnemySpeedX = 0;
    public int mobEnemySpeedY = 5;
    public final int maxMobSpeedY = 20;

    /*
     * 精英敌机设置
     */
    public int eliteEnemyHp = 60;
    public final int maxEliteHp = 100;
    public int eliteEnemySpeedX = 10;
    public int eliteEnemySpeedY = 3;
    public int eliteEnemyPower = 10;
    public int eliteShootNum = 1;
    public final int maxEliteShootNum = 3;
    public final int maxEliteSpeedY = 8;
    public final int maxEliteSpeedX = 10;

    /*
     * Boss机设置
     */
    public boolean isLeverUp = false;
    public double bossHpIncreaseRate = 1.0;
    public int bossHp = 600;
    public int bossSpeedX = 5;
    public int bossSpeedY = 0;
    public int scoreToBoss = 500;
    public int bossPower = 10;
    public final int maxBossPower = 100;

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

    /**
     * 返回游戏模式
     * @return 返回int类型，0为easy，1为common，2为hard
     */
    public int getGameMode() {
        return gameMode;
    }

    /**
     * 设置游戏模式
     * @param gameMode int类型，0为easy，1为common，2为hard
     */
    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    /**
     * 得到难度（String）
     * @return 难度（String）
     */
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

    /**
     * 音效设置，开
     */
    public void setSoundOn() {
        isSoundOn = SOUND_ON;
    }

    /**
     * 音效设置，关
     */
    public void setSoundOff() {
        isSoundOn = SOUND_OFF;
    }

    /**
     * 返回音效状态
     * @return 音效状态（Boolean）
     */
    public boolean getVideoState() {
        return isSoundOn;
    }
}
