package io.neilshirsat.ui.customize;

import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomizeGrid extends JPanel {

    private GridLayout CustomizeGridLayout;

    private JButton[] CustomizeTitleButton;

    private JButton[][] CustomizeSquaresButton;

    private SquareCustomizeWindow[] CustomizeTitle;

    private SquareCustomizeWindow[][] CustomizeSquares;

    private BingoState State;

    public CustomizeGrid(BingoState State) {
        super();
        this.State = State;

        CustomizeGridLayout = new GridLayout(6, 5);
        CustomizeGridLayout.setHgap(15);
        CustomizeGridLayout.setVgap(15);
        super.setBorder(new EmptyBorder(15, 15, 15, 15));
        super.setLayout(CustomizeGridLayout);

        CustomizeTitleButton = new JButton[5];
        CustomizeSquaresButton = new JButton[5][5];
        CustomizeTitle = new SquareCustomizeWindow[5];
        CustomizeSquares = new SquareCustomizeWindow[5][5];

        String[] TitleLetters = new String[]{"B", "I", "N", "G", "O"};

        for (int i = 0; i < 5; i++) {
            CustomizeTitleButton[i] = new JButton(TitleLetters[i]);
            CustomizeTitle[i] = new SquareCustomizeWindow(State.getTitleSquares()[i]);
            CustomizeTitle[i].setTitle(TitleLetters[i]);
            int finalI = i;
            CustomizeTitleButton[i].addActionListener(e-> CustomizeTitle[finalI].setVisible(true));
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                CustomizeSquaresButton[i][j] = new JButton( TitleLetters[i] + " " + j);
                CustomizeSquares[i][j] = new SquareCustomizeWindow(State.getBingoSquares()[i][j]);
                CustomizeSquares[i][j].setTitle(TitleLetters[i] + " " + j);
                int finalI = i;
                int finalJ = j;
                CustomizeSquaresButton[i][j].addActionListener(e->
                        CustomizeSquares[finalI][finalJ].setVisible(true));
            }
        }

        for (int i = 0; i < 5; i++) {
            super.add(CustomizeTitleButton[i]);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                super.add(CustomizeSquaresButton[j][i]);
            }
        }

    }

    public GridLayout getCustomizeGridLayout() {
        return CustomizeGridLayout;
    }

    public void setCustomizeGridLayout(GridLayout layout) {
        CustomizeGridLayout = layout;
    }

    public JButton[] getCustomizeTitleButton() {
        return CustomizeTitleButton;
    }

    public void setCustomizeTitleButton(JButton[] customizeTitleButton) {
        CustomizeTitleButton = customizeTitleButton;
    }

    public JButton[][] getCustomizeSquaresButton() {
        return CustomizeSquaresButton;
    }

    public void setCustomizeSquaresButton(JButton[][] customizeSquaresButton) {
        CustomizeSquaresButton = customizeSquaresButton;
    }

}
