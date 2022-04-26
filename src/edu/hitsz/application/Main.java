package edu.hitsz.application;

import edu.hitsz.UI.StartUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 程序入口
 * @author hitsz
 */
public class Main implements ActionListener {

    public static final int WINDOW_WIDTH = 512;
    public static final int WINDOW_HEIGHT = 768;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    JFrame startUpFrame = new JFrame("StartGame");
    JFrame gameFrame = new JFrame("Aircraft War");
    StartUp startUp = new StartUp();

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        System.out.println("Hello Aircraft War");

        // 获得屏幕的分辨率，初始化 Frame
        gameFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        gameFrame.setResizable(false);
        //设置窗口的大小和位置,居中放置
        gameFrame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH) / 2, 0,
                WINDOW_WIDTH, WINDOW_HEIGHT);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startUpFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        startUpFrame.setResizable(false);
        //设置窗口的大小和位置,居中放置
        startUpFrame.setBounds(((int) screenSize.getWidth() - WINDOW_WIDTH/2) / 2, ((int) screenSize.getHeight() - WINDOW_HEIGHT/3) / 2,
                WINDOW_WIDTH/2, WINDOW_HEIGHT/3);
        startUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startUpFrame.setContentPane(startUp.mainPanel);
        startUpFrame.setVisible(true);

        startUp.easyButton.addActionListener(this);
        startUp.commonButton.addActionListener(this);
        startUp.hardButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        startUpFrame.setVisible(false);
        Game game = new Game();
        gameFrame.add(game);
        gameFrame.setVisible(true);
        game.action();
    }
}
