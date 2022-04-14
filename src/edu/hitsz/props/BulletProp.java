package edu.hitsz.props;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.shootStrategy.ScatteredShoot;

/**
 * 子弹道具类，用于加强英雄机子弹
 * @author 柯嘉铭
 */
public class BulletProp extends AbstractProp{

    private int bulletNumAdd = 1; //增加子弹数目
    private String message = "FireSupply active!";

    public BulletProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void work (HeroAircraft heroAircraft){
        if(heroAircraft.getShootNum() < heroAircraft.getMaxShootNum()) {
            heroAircraft.setShootNum(bulletNumAdd);
        }else{
            heroAircraft.setStrategy(new ScatteredShoot());
        }
        System.out.println(this.message);
    }
}
