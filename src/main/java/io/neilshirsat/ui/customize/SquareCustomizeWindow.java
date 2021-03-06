package io.neilshirsat.ui.customize;

import io.neilshirsat.ui.bingo.BingoSquareState;

import javax.swing.*;
import java.awt.*;

public class SquareCustomizeWindow extends JFrame {

    private SquareCustomizePanel SquareCustomizePanel;

    private BingoSquareState State;

    public SquareCustomizeWindow(BingoSquareState State) {
        super();
        this.State = State;

        super.setTitle("Customize Bingo Board");
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);

        SquareCustomizePanel = new SquareCustomizePanel(State);
        super.setContentPane(SquareCustomizePanel);
        super.pack();

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );
    }

}
