package io.neilshirsat.ui.customize;

import io.neilshirsat.ui.bingo.BingoSquareState;
import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;
import java.awt.*;

public class BingoWideCustomizeWindow extends JFrame {

    private BingoWideCustomizePanel BingoWideCustomizePanel;

    private BingoState State;

    public BingoWideCustomizeWindow(BingoState State) {
        super();
        this.State = State;

        super.setTitle("Customize Bingo Board");
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);

        BingoWideCustomizePanel = new BingoWideCustomizePanel(State);
        super.setContentPane(BingoWideCustomizePanel);
        super.pack();

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );
    }

}
