package edu.hitsz.application;

/**
 * 控制音效进程
 * @author 柯嘉铭
 */
public class MusicController {
    private static MusicThread bgmThread = new MusicThread("src/videos/bgm.wav");
    private static MusicThread bossBgmThread = new MusicThread("src/videos/bgm_boss.wav");

    /**
     * 控制bgm
     * @param bossExistFlag boss不在，播放音乐；boss在，不播放
     */
    public static void setBgm(boolean bossExistFlag) {
        if(Settings.getInstance().getVideoState() && ! bossExistFlag){
            if(! bgmThread.isAlive()) {
                bgmThread = new MusicThread("src/videos/bgm.wav");
                bgmThread.start();
            }
        }
        if(bossExistFlag) {
            bgmThread.stopPlay();
        }
    }

    /**
     * 控制boss在场时bgm
     * @param bossExitFlag boss在，播放音乐；反之不播放
     */
    public static void setBossBgm(boolean bossExitFlag) {
        if(Settings.getInstance().getVideoState() && bossExitFlag) {
            if (!bossBgmThread.isAlive()) {
                bossBgmThread = new MusicThread("src/videos/bgm_boss.wav");
                bossBgmThread.start();
            }
        }
        if(! bossExitFlag) {
            bossBgmThread.stopPlay();
        }
    }

    /**
     * 炸弹道具爆炸音效
     */
    public static void setBombExplosionBgm() {
        if(Settings.getInstance().getVideoState()){
            new MusicThread("src/videos/bomb_explosion.wav").start();
        }
    }

    /**
     * 英雄机发射子弹音效
     */
    public static void setBulletBgm(){
        if(Settings.getInstance().getVideoState()){
            new MusicThread("src/videos/bullet.wav").start();
        }
    }

    /**
     * 英雄机或者敌机被子弹击中时音效
     */
    public static void setBulletHitBgm() {
        if(Settings.getInstance().getVideoState()){
            new MusicThread("src/videos/bullet_hit.wav").start();
        }
    }

    /**
     * 游戏结束时音效
     */
    public static void setGameOverBgm() {
        if(Settings.getInstance().getVideoState()){
            bgmThread.stopPlay();
            bossBgmThread.stopPlay();
            new MusicThread("src/videos/game_over.wav").start();
        }
    }

    /**
     * 获得道具时音效
     */
    public static void setGetSupplyBgm() {
        if(Settings.getInstance().getVideoState()){
            new MusicThread("src/videos/get_supply.wav").start();
        }
    }
}
