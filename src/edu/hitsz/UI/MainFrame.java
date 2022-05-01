package edu.hitsz.UI;

import edu.hitsz.application.CommonGame;
import edu.hitsz.application.EasyGame;
import edu.hitsz.application.Game;
import edu.hitsz.application.HardGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 主UI类，管理窗体之间切换
 * @author 柯嘉铭
 */
public class MainFrame {
    public static final int WINDOW_WIDTH = 512;
    public static final int WINDOW_HEIGHT = 768;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame startUpFrame = new JFrame("StartGame");
    JFrame gameFrame = new JFrame("Aircraft War");
    StartUp startUp = new StartUp();

    public MainFrame() {
        // 游戏窗体
        // 获得屏幕的分辨率，初始化 Frame
        gameFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        gameFrame.setResizable(false);
        //设置窗口的大小和位置,居中放置
        gameFrame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH) / 2, 0,
                WINDOW_WIDTH, WINDOW_HEIGHT);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 开始菜单窗体
        startUpFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        startUpFrame.setResizable(false);
        //设置窗口的大小和位置,居中放置
        startUpFrame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH/2) / 2, ((int) screenSize.getHeight() - WINDOW_HEIGHT/3) / 2,
                WINDOW_WIDTH/2, WINDOW_HEIGHT/3);
        startUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startUpFrame.setContentPane(startUp.mainPanel);
        startUpFrame.setVisible(true);

        // 监听开始菜单的三个按钮，以实现窗体切换
        ActionListener easy = e -> {
            startUpFrame.setVisible(false);
            Game game = new EasyGame();
            gameFrame.add(game);
            gameFrame.setVisible(true);
            game.action();
        };
        startUp.easyButton.addActionListener(easy);
        ActionListener common = e -> {
            startUpFrame.setVisible(false);
            Game game = new CommonGame();
            gameFrame.add(game);
            gameFrame.setVisible(true);
            game.action();
        };
        startUp.commonButton.addActionListener(common);

        ActionListener hard = e -> {
            startUpFrame.setVisible(false);
            Game game = new HardGame();
            gameFrame.add(game);
            gameFrame.setVisible(true);
            game.action();
        };
        startUp.hardButton.addActionListener(hard);
    }
}
