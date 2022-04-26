package edu.hitsz.shootStrategy;

import edu.hitsz.application.Settings;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;
import edu.hitsz.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

/**
 * 散射
 * @author 柯嘉铭
 */
public class ScatteredShoot implements ShootStrategy {
    /**
     * 射击模式,三弹散射
     */
    @Override
    public List<BaseBullet> shootMode(boolean isHero, int locationX, int locationY, int direction, int power, int shootNum) {
        List<BaseBullet> res = new LinkedList<>();
        int x = locationX;
        int y = locationY + direction*2;
        int speedX = 1;
        int speedY = Settings.getInstance().bulletSpeedY * direction;
        BaseBullet baseBullet;
        for(int i=0; i<shootNum; i++){
            if(isHero){
                baseBullet = new HeroBullet(x + (i*2 - shootNum + 1)*10, y,  speedX*(i-1), speedY, power);
            }else{
                baseBullet = new EnemyBullet(x + (i*2 - shootNum + 1)*60, y,  speedX*(i-1), speedY, power);
            }
            res.add(baseBullet);
        }
        return res;
    }
}
