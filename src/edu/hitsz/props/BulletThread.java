package edu.hitsz.props;

import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.shootStrategy.ScatteredShoot;

/**
 * @author 柯嘉铭
 */
public class BulletThread extends Thread{
    @Override
    public void run() {
        synchronized (this){
            HeroAircraft.getInstance().setStrategy(new ScatteredShoot());
            try {
                wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HeroAircraft.getInstance().resetShootNum();
        }
    }
}
