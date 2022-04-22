package edu.hitsz.props;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.Settings;

/**
 * 血包道具类，用于加血
 * @author 柯嘉铭
 */
public class BloodProp extends AbstractProp {

    private int plusHp = Settings.getInstance().hpPlus;

    public BloodProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void work() {
        if (HeroAircraft.getInstance().getHp() <= (HeroAircraft.getInstance().getMaxHp() - this.plusHp)) {
            HeroAircraft.getInstance().decreaseHp(- plusHp);
        }
    }
}
