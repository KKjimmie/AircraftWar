package edu.hitsz.application;

/**
 * 用于保存游戏相关参数设定的类
 * @author 柯嘉铭
 */
public class Settings {

    /*
     * 英雄机设置
     */
    public static int heroHp = 1000;
    public static int heroSpeedX = 0;
    public static int heroSpeedY = 0;

    /*
     * 普通敌机设置
     */
    public static int mobEnemyHp = 30;
    public static int mobEnemySpeedX = 0;
    public static int mobEnemySpeedY = 10;

    /*
     * 精英敌机设置
     */
    public static int eliteEnemyHp = 60;
    public static int eliteEnemySpeedX = 10;
    public static int eliteEnemySpeedY = 3;

    /*
     * Boss机设置
     */
    public static int bossHp = 600;
    public static int bossSpeedX = 5;
    public static int bossSpeedY = 0;
    public static int scoreToBoss = 1000;

    /*
     * 道具设置
     */
    public static int propSpeedX = 10;
    public static int propSpeedY = 5;
    /**
     * 道具跌落率
     */
    public static double propDropRate = 0.9;



}
