package io.neilshirsat.ui.simulation;

import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;
import java.awt.*;

public class SimulationExportWindow extends JFrame {

    private SimulationExportPanel SimulationExportPanel;

    private SimulationState State;

    private BingoState BingoState;

    public SimulationExportWindow(SimulationState State, BingoState BingoState) {
        super();

        this.State = State;
        this.BingoState = BingoState;

        super.setTitle("Export Bingo Boards");

        SimulationExportPanel = new SimulationExportPanel(State, BingoState);
        super.setContentPane(SimulationExportPanel);

        super.pack();
        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );
    }

}
