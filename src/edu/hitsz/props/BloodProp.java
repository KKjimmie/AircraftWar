package edu.hitsz.props;

import edu.hitsz.aircraft.HeroAircraft;

/**
 * 血包道具类，用于加血
 * @author 柯嘉铭
 */
public class BloodProp extends AbstractProp {

    private int plusHp = 10;

    public BloodProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void work(HeroAircraft heroAircraft) {
        if (heroAircraft.getHp() <= (heroAircraft.getMaxHp() - this.plusHp)) {
            heroAircraft.decreaseHp(-this.plusHp);
        }
    }
}
