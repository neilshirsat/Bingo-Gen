package io.neilshirsat.bingoboard;

import io.neilshirsat.components.ColorPicker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BingoGrid extends JPanel {

    private BingoTitleSquare title[];

    private BingoSquare[][] square;

    public final int[] LOWER_LIMIT = new int[]{
            1,
            16,
            31,
            46,
            61
    };

    public final int[] UPPER_LIMIT = new int[]{
            15,
            30,
            45,
            60,
            75
    };

    private GroupLayout layout;

    public BingoGrid() {
        super();

        super.setBackground(Color.WHITE);
        GridLayout layout = new GridLayout(6, 5);
        super.setLayout(layout);

        super.setBorder(new EmptyBorder(20, 20, 20, 20));

        title = new BingoTitleSquare[]{
                new BingoTitleSquare("B"),
                new BingoTitleSquare("I"),
                new BingoTitleSquare("N"),
                new BingoTitleSquare("G"),
                new BingoTitleSquare("O")
        };

        square = new BingoSquare[5][5];

        for (int i = 0; i < 5; i++) {
            int[] selected = new int[5];
            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) {
                    square[i][j] = new FreeSpace();
                }
                else {
                    selected[j] = getRandomInt( LOWER_LIMIT[i], UPPER_LIMIT[i], selected );
                    square[i][j] = new BingoSquare(selected[j] + "");
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            super.add(title[i]);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                super.add(square[j][i]);
            }
        }

    }

    private int getRandomInt( int lb, int ub, int[] selected ) {
        int select = (int)(Math.random()*(ub-lb)) + lb;
        while (contains(selected, select)) {
            select = (int)(Math.random()*(ub-lb)) + lb;
        }
        return select;
    }

    private boolean contains( int[] arr, int select ) {
        for (int e: arr) {
            if (e == select)
                return true;
        }
        return false;
    }

    public void setSquareBackground( Color Color ) {
        for (BingoTitleSquare e : title) {
            e.setExtraBackground(Color);
        }
        for ( BingoSquare[] a : square ) {
            for ( BingoSquare e : a ) {
                e.setSquareBackground(Color);
            }
        }
        setBackground(Color);
    }

    public void setSquareTextColor( Color Color ) {
        for ( BingoSquare[] a : square ) {
            for ( BingoSquare e : a ) {
                e.setSquareTextColor(Color);
            }
        }
    }

    public void setTitleColor( Color Color) {
        for (BingoTitleSquare e : title) {
            e.setSquareTextColor(Color);
        }
    }

    public void setTitleBackgroundColor( Color Color) {
        for (BingoTitleSquare e : title) {
            e.setSquareBackground(Color);
        }
    }

    public void setBorderColor( Color Color) {
        for ( BingoSquare[] a : square ) {
            for ( BingoSquare e : a ) {
                e.setBorderColor(Color);
            }
        }
    }

}
