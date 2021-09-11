package io.neilshirsat.ui.bingo;

import io.neilshirsat.Application;
import io.neilshirsat.render.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

/**
 * @author Neil Shirsat
 */
public class BingoPreview extends JFrame {

    private BingoState BingoState;

    private BingoPanel BingoPanel;

    public BingoPreview() {
        super();

        super.setTitle("Bingo Board Preview");
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setSize(  (int)WindowDimension.getHeight() * 15/16 * 5/6 , (int)WindowDimension.getHeight() * 15/16);
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT,
                    Objects.requireNonNull(Application.class.getResourceAsStream("NotoSans-Regular.ttf")));
        } catch (Exception e) {
            System.out.println("Font Not Initialized");
        }

        String[] TitleLetters = new String[]{"B", "I", "N", "G", "O"};

        BingoSquareState[] TitleState = new BingoSquareState[5];
        for (int i = 0; i < 5; i++){
            TitleState[i] = new BingoSquareState();
            TitleState[i].setAnalise(true);
            TitleState[i].setTextAnalise(true);
            TitleState[i].setTextColor(Color.BLACK);
            TitleState[i].setFontSize(50f);
            TitleState[i].setFontStyle(Font.PLAIN);
            TitleState[i].setTextFont(font);
            TitleState[i].setBorderColor(Color.BLACK);
            TitleState[i].setBackgroundColor(Color.WHITE);
            TitleState[i].setBorderThickness(1);
            TitleState[i].setPositionX(0);
            TitleState[i].setPositionY(0);
            TitleState[i].setShape(ShapeType.CIRCLE);
            TitleState[i].setBaseBackgroundColor(Color.BLACK);
            TitleState[i].setTitle(true);
            TitleState[i].setTitleText(TitleLetters[i]);
        }

        BingoSquareState[][] SquareState = new BingoSquareState[5][5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                SquareState[i][j] = new BingoSquareState();
                SquareState[i][j].setAnalise(true);
                SquareState[i][j].setTextAnalise(true);
                SquareState[i][j].setSquareNumber(i + " " + j);
                SquareState[i][j].setTextColor(Color.BLACK);
                SquareState[i][j].setFontSize(50f);
                SquareState[i][j].setFontStyle(Font.PLAIN);
                SquareState[i][j].setTextFont(font);
                SquareState[i][j].setBorderColor(Color.BLACK);
                SquareState[i][j].setBackgroundColor(Color.WHITE);
                SquareState[i][j].setBorderThickness(1);
                SquareState[i][j].setPositionX(0);
                SquareState[i][j].setPositionY(0);
                SquareState[i][j].setShape(ShapeType.RECTANGLE);
                SquareState[i][j].setBaseBackgroundColor(Color.BLACK);
            }
        }

        BingoState = new BingoState();
        BingoState.setBaseBackgroundColor(Color.WHITE);
        BingoState.setBingoSquares(SquareState);
        BingoState.setTitleSquares(TitleState);
        BingoPanel = new BingoPanel(BingoState);

        super.setContentPane(BingoPanel);
    }

    public io.neilshirsat.ui.bingo.BingoState getBingoState() {
        return BingoState;
    }

    public void setBingoState(io.neilshirsat.ui.bingo.BingoState bingoState) {
        BingoState = bingoState;
    }

    public io.neilshirsat.ui.bingo.BingoPanel getBingoPanel() {
        return BingoPanel;
    }

    public void setBingoPanel(io.neilshirsat.ui.bingo.BingoPanel bingoPanel) {
        BingoPanel = bingoPanel;
    }

}
