package edu.hitsz.shootStrategy;

import edu.hitsz.application.Settings;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 柯嘉铭
 */
public class DirectShoot implements ShootStrategy {
    /**
     * 射击模式：直射
     */
    @Override
    public List<BaseBullet> shootMode(boolean isHero, int locationX, int locationY, int direction, int power, int shootNum) {
        List<BaseBullet> res = new LinkedList<>();
        int x = locationX;
        int y = locationY + direction*2;
        int speedX = 0;
        int speedY = Settings.getInstance().bulletSpeedY * direction;
        BaseBullet baseBullet;
        for(int i=0; i<shootNum; i++){
            // 子弹发射位置相对飞机位置向前偏移
            // 多个子弹横向分散
            if(isHero){
                baseBullet = new HeroBullet(x + (i*2 - shootNum + 1)*10, y,  speedX, speedY, power);
            }else{
                baseBullet = new EnemyBullet(x + (i*2 - shootNum + 1)*10, y,  speedX, speedY*2, power);
            }
            res.add(baseBullet);
        }
        return res;
    }
}
