package io.neilshirsat;

import javax.swing.*;
import java.awt.*;

public class BingoGrid extends JPanel {

    private String title[];

    private int[][] square;

    public BingoGrid() {
        setLayout( new GridLayout(6, 5) );

        title = new String[]{ "B", "I", "N", "G", "O" };

        for ( int i = 0; i < 5; i ++ ) {
            super.add(new BingoSquare(title[i]));
            for ( int j = 0; j < 5; j++ ) {
                super.add(new BingoSquare(Integer.toString(i*j)));
            }
        }

    }
}
