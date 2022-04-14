package edu.hitsz.aircraft;

import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;
import edu.hitsz.application.Settings;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.shootStrategy.DirectShoot;

import java.util.List;

/**
 * 英雄飞机，游戏玩家操控
 * @author hitsz
 */
public class HeroAircraft extends AbstractAircraft {

    /**
     * shootNum 子弹一次发射的数量
     */
    private int shootNum = 1;
    /**
     * power 子弹伤害
     */
    private int power = 30;
    /**
     * direction 子弹射击方向 (向上发射：-1，向下发射：1)
     */
    private int direction = -1;
    /**
     * maxShootNUm 子弹一次最多发射的数量
     */
    private final int maxShootNum = 3;
    private volatile static HeroAircraft instance = null;
    /**
     * @param locationX 英雄机位置x坐标
     * @param locationY 英雄机位置y坐标
     * @param speedX 英雄机射出的子弹的基准速度（英雄机无特定速度）
     * @param speedY 英雄机射出的子弹的基准速度（英雄机无特定速度）
     * @param hp    初始生命值
     */
    private HeroAircraft(int locationX, int locationY, int speedX, int speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        this.setStrategy(new DirectShoot());
    }

    public static HeroAircraft getInstance(){
        if (instance == null) {
            synchronized (HeroAircraft.class){
                if (instance == null) {
                    int locationX = Main.WINDOW_WIDTH / 2;
                    int locationY = Main.WINDOW_HEIGHT - ImageManager.HERO_IMAGE.getHeight();
                    int speedX = Settings.heroSpeedX;
                    int speedY = Settings.heroSpeedY;
                    int hp = Settings.heroHp;
                    instance = new HeroAircraft(locationX, locationY, speedX, speedY, hp);
                }
            }
        }
        return instance;
    }
    public static HeroAircraft getInstance(int locationX, int locationY, int speedX, int speedY, int hp){
        if (instance == null) {
            synchronized (HeroAircraft.class){
                if (instance == null) {
                    instance = new HeroAircraft(locationX, locationY, speedX, speedY, hp);
                }
            }
        }
        return instance;
    }

    public int getShootNum() {
        return shootNum;
    }

    public int getMaxShootNum() {
        return maxShootNum;
    }

    @Override
    public void forward() {
        // 英雄机由鼠标控制，不通过forward函数移动
    }

    @Override
    public List<BaseBullet> shoot() {
        return strategy.shootMode(true, this.locationX, this.locationY, this.direction, this.power, this.shootNum);
    }

    public void setShootNum(int num){
        if (this.shootNum <this.maxShootNum && this.shootNum >=1){
            this.shootNum += num;
        }
    }

}
