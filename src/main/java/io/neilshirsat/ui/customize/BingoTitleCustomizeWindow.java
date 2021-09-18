package io.neilshirsat.ui.customize;

import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;
import java.awt.*;

public class BingoTitleCustomizeWindow extends JFrame {

    private BingoTitleCustomizePanel BingoTitleCustomizePanel;

    private BingoState State;

    public BingoTitleCustomizeWindow(BingoState State) {
        super();
        this.State = State;

        super.setTitle("Customize Bingo Board Title");
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);

        BingoTitleCustomizePanel = new BingoTitleCustomizePanel(State);
        super.setContentPane(BingoTitleCustomizePanel);
        super.pack();

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );
    }

}
