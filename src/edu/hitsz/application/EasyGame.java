package edu.hitsz.application;

public class EasyGame extends Game{

    public EasyGame() {
        super();
    }

    @Override
    protected void initGameMode() {
        // 获取背景
        backGround = ImageManager.BACKGROUND_IMAGE_1;
        // 英雄机
        Settings.getInstance().heroHp = 10000;
        Settings.getInstance().maxHeroHp = 10000;
        Settings.getInstance().scoreToBoss = Integer.MAX_VALUE;
    }

    @Override
    protected void changeBackground() {

    }

    @Override
    protected void difficultyLevelUp() {
    }
}
