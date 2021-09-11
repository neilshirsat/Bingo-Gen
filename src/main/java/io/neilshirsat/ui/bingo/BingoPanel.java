package io.neilshirsat.ui.bingo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BingoPanel extends JPanel {

    private GridLayout BingoGridLayout;

    private BingoState BingoState;

    public BingoPanel( BingoState BingoState ) {
        super();
        this.BingoState = BingoState;

        super.setBackground(BingoState.getBaseBackgroundColor());
        super.setBorder(new EmptyBorder(20, 20, 20, 20));
        BingoGridLayout = new GridLayout( 6, 5 );
        super.setLayout( BingoGridLayout );

        for (int i = 0; i < 5; i++) {
            super.add( new BingoSquare(BingoState.getTitleSquares()[i]) );
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++){
                super.add( new BingoSquare(BingoState.getBingoSquares()[j][i]) );
            }
        }
    }

    public GridLayout getBingoGridLayout() {
        return BingoGridLayout;
    }

    public void setBingoGridLayout(GridLayout bingoGridLayout) {
        BingoGridLayout = bingoGridLayout;
    }

    public io.neilshirsat.ui.bingo.BingoState getBingoState() {
        return BingoState;
    }

    public void setBingoState(io.neilshirsat.ui.bingo.BingoState bingoState) {
        BingoState = bingoState;
    }

}
