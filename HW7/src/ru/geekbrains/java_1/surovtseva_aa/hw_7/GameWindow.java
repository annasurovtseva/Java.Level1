package ru.geekbrains.java_1.surovtseva_aa.hw_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int winWidth = 507;
    private static final int winHeight = 555;
    private static final int winPosX = 650;
    private static final int winPosY = 250;

    private Map map;
    SettingsWindow settings;

    GameWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(winWidth, winHeight);
        setLocationRelativeTo(null);
        setTitle("TicTacToe");
        setResizable(false);
        JButton btnStart = new JButton("Start a new game");
        JButton btnExit = new JButton("<html><body><b>Exit</b></body></html>");
        JPanel panelButton = new JPanel(new GridLayout(1, 2));
        panelButton.add(btnStart);
        panelButton.add(btnExit);
        map = new Map();
        settings = new SettingsWindow(this);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);

            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(panelButton, BorderLayout.SOUTH);
        add(map, BorderLayout.CENTER);
        setVisible(true);
    }

    void applySettings(int mode, int size, int length) {
        map.startNewGame(mode, size, size, length);
    }

}
