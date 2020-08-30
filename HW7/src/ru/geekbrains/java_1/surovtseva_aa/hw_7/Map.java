package ru.geekbrains.java_1.surovtseva_aa.hw_7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {
    public static final int modeHVH = 0;
    public static final int modeHVA = 1;

    Map() {
         setBackground(Color.GRAY);
    }

    void startNewGame (int gameMode, int fieldSizeX, int fieldSizeY, int winLength) {
        setGameBoard(fieldSizeX, fieldSizeY);
    }

    void setGameBoard(int sizeX, int sizeY) {
        setLayout(new GridLayout(sizeX, sizeY, 2, 2));
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                add(new JButton());
            }
        }
        revalidate();
    }

}
