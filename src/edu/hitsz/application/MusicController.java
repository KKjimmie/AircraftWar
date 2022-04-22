package edu.hitsz.application;

/**
 * @author 柯嘉铭
 */
public class MusicController {
    private static MusicThread bgmThread = new MusicThread("src/videos/bgm.wav");
    private static MusicThread bossBgmThread = new MusicThread("src/videos/bgm_boss.wav");

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

    public static void setBombExplosionBgm() {
        if(Settings.getInstance().getVideoState()){
            new MusicThread("src/videos/bomb_explosion.wav").start();
        }
    }

    public static void setBulletBgm(){
        if(Settings.getInstance().getVideoState()){
            new MusicThread("src/videos/bullet.wav").start();
        }
    }

    public static void setBulletHitBgm() {
        if(Settings.getInstance().getVideoState()){
            new MusicThread("src/videos/bullet_hit.wav").start();
        }
    }

    public static void setGameOverBgm() {
        if(Settings.getInstance().getVideoState()){
            bgmThread.stopPlay();
            bossBgmThread.stopPlay();
            new MusicThread("src/videos/game_over.wav").start();
        }
    }
    public static void setGetSupplyBgm() {
        if(Settings.getInstance().getVideoState()){
            new MusicThread("src/videos/get_supply.wav").start();
        }
    }
}
