package io.neilshirsat.ui.simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SimulationResultsWindow extends JFrame {

    private SimulationResultsPanel SimulationResultsPanel;

    private SimulationState State;

    public SimulationResultsWindow(SimulationState State) {
        super();

        this.State = State;

        super.setTitle("Bingo Simulation Results");

        SimulationResultsPanel = new SimulationResultsPanel(State);
        super.setContentPane(SimulationResultsPanel);

        super.pack();
        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );
    }

}
