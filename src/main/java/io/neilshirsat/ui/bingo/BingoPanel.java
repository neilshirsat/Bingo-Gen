package io.neilshirsat.ui.bingo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BingoPanel extends JPanel {

    private GridLayout BingoGridLayout;

    private BingoState BingoState;

    public BingoPanel( BingoState BingoState ) {
        super();
        this.BingoState = BingoState;

        super.setBackground(BingoState.getBaseBackgroundColor());
        TitledBorder tb = BorderFactory.createTitledBorder(
                new EmptyBorder(20, 20, 20, 20),
                "Bingo Id: " + BingoState.getBingoBoardId(),
                TitledBorder.LEFT,
                TitledBorder.BOTTOM);
        super.setBorder(tb);
        BingoState.addBingoStateWatcher(e->{
            super.setBackground(BingoState.getBaseBackgroundColor());
            if (e == BingoProperties.BOARD_ID) {
                tb.setTitle("Bingo Id: " + BingoState.getBingoBoardId());
                super.repaint();
            }
            if (e == BingoProperties.ID_COLOR) {
                tb.setTitleColor(BingoState.getBingoIdColor());
                super.repaint();
            }
            if (e == BingoProperties.ID_FONT) {
                tb.setTitleFont(BingoState.getBingoIdFont());
                super.repaint();
            }
        });

        BingoGridLayout = new GridLayout( 6, 5 );
        BingoGridLayout.setHgap(0);
        BingoGridLayout.setVgap(0);
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

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int)(super.getParent().getSize().height * (5.0/6)), super.getParent().getSize().height);
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
