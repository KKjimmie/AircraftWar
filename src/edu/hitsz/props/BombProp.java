package edu.hitsz.props;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.Boss;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.bullet.BaseBullet;
import edu.hitsz.bullet.EnemyBullet;

import java.util.List;

/**
 * 爆炸道具类
 * @author 柯嘉铭
 */
public class BombProp extends AbstractProp{

    private String message = "BombSupply active!";

    public BombProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void work(HeroAircraft heroAircraft) {
        System.out.println(this.message);
    }
    public void boom(List<AbstractAircraft> enemyAircrafts, List<BaseBullet> enemyBullets){
        for (var enemyAircraft : enemyAircrafts) {
            if (! (enemyAircraft instanceof Boss)){
                enemyAircraft.vanish();
            }
        }
        for (var enemyBullet : enemyBullets) {
            enemyBullet.vanish();
        }
    }
}
