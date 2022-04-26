package edu.hitsz.UI;

import edu.hitsz.application.Main;
import edu.hitsz.application.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 开始时选择难度以及音效界面
 * @author 柯嘉铭
 */
public class StartUp extends JFrame{
    public JPanel mainPanel;
    public JButton easyButton;
    public JButton commonButton;
    public JButton hardButton;
    private JPanel bottomPanel;
    private JComboBox soundBox;
    private JLabel video;


    public StartUp() {
        // 简单难度按钮实现
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings.getInstance().setGameMode(Settings.EASY_MODE);
            }
        });
        // 普通难度按钮实现
        commonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings.getInstance().setGameMode(Settings.COMMON_MODE);
            }
        });
        // 困难难度按钮实现
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings.getInstance().setGameMode(Settings.HARD_MODE);
            }
        });
        // 音效选择菜单实现
        soundBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = soundBox.getSelectedIndex();
                if(option == 1) {
                    Settings.getInstance().setSoundOff();
                }else {
                    Settings.getInstance().setSoundOff();
                }
            }
        });
    }
}
