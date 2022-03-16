package edu.hitsz.props;

import edu.hitsz.aircraft.HeroAircraft;

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
}
