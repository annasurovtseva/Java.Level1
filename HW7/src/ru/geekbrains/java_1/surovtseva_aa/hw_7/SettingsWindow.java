package ru.geekbrains.java_1.surovtseva_aa.hw_7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int windowWidth = 350;
    private static final int windowHeight = 270;
    private static final int minWinLength = 3;
    private static final int minFieldSize = 3;
    private static final int maxFieldSize = 10;
    private static final String fieldSizePrefix = "Field size is: ";
    private static final String winLengthPrefix = "Win length is: ";

    private GameWindow gameWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVShum;
    private JSlider slideWinLength;
    private JSlider slideFieldSize;

    SettingsWindow (GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(windowWidth, windowHeight);
        setLocationRelativeTo(gameWindow);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(10,1));
        addGameModeControls();
        addFieldControls();
        JButton btnStart = new JButton("Start new game");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStartClick();
            }
        });
        add(btnStart);
    }

    private void addGameModeControls() {
        add(new JLabel("Choose game mode "));
        humVSAI = new JRadioButton("Human vs. AI", true);
        humVShum = new JRadioButton("Human vs. Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVShum);
        add(humVSAI);
        add(humVShum);
    }

    private void addFieldControls(){
        JLabel lbFieldSize = new JLabel(fieldSizePrefix + minFieldSize);
        JLabel lbWinLength = new JLabel(winLengthPrefix + minWinLength);
        slideFieldSize = new JSlider(minFieldSize, maxFieldSize, minFieldSize);
        slideWinLength = new JSlider(minWinLength, minFieldSize, minWinLength);
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbFieldSize.setText(fieldSizePrefix + slideFieldSize.getValue());
                slideWinLength.setMaximum(slideFieldSize.getValue());
            }
        });

        slideWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText(winLengthPrefix + slideWinLength.getValue());
            }
        });

        add(new JLabel("Choose field size"));
        add(lbFieldSize);
        add(slideFieldSize);
        add(new JLabel("Choose win length"));
        add(lbWinLength);
        add(slideWinLength);
    }

    private void btnStartClick() {
        int gameMode;
        if (humVSAI.isSelected()) {
            gameMode = Map.modeHVA;
        } else if (humVShum.isSelected()) {
            gameMode = Map.modeHVH;
        } else {
            throw new RuntimeException("Unexpected game mode");
        }
        int fieldSize = slideFieldSize.getValue();
        int winLength = slideWinLength.getValue();

        gameWindow.applySettings(gameMode, fieldSize, winLength);
        setVisible(false);
    }

}
