package edu.hitsz.props;

import edu.hitsz.basic.CanBoom;
import java.util.ArrayList;
import java.util.List;

/**
 * 爆炸道具类
 * 使用观察者模式实现除boss机外的敌机以及子弹消失
 * @author 柯嘉铭
 */
public class BombProp extends AbstractProp{
    private List<CanBoom> canBoomList = new ArrayList<>();

    public BombProp(int locationX, int locationY, int speedX, int speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    public void addCanBoom(CanBoom canBoom){
        canBoomList.add(canBoom);
    }

    public void removeCanBoom(CanBoom canBoom){
        canBoomList.remove(canBoom);
    }

    public void notifyAllToBoom(){
        for(var canBoom : canBoomList){
            canBoom.boom();
        }
    }

    @Override
    public void work() {
        notifyAllToBoom();
    }
}
