package edu.hitsz.UI;

import edu.hitsz.application.Main;
import edu.hitsz.application.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartUp extends JFrame{
    public JPanel mainPanel;
    public JButton easyButton;
    public JButton commonButton;
    public JButton hardButton;
    private JPanel bottomPanel;
    private JComboBox soundBox;
    private JLabel video;


    public StartUp() {
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings.getInstance().setGameMode(Settings.EASY_MODE);
            }
        });
        commonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings.getInstance().setGameMode(Settings.COMMON_MODE);
            }
        });
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings.getInstance().setGameMode(Settings.HARD_MODE);
            }
        });
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
