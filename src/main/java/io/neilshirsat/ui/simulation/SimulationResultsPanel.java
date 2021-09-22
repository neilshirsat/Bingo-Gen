package io.neilshirsat.ui.simulation;

import javax.swing.*;

public class SimulationResultsPanel extends JTabbedPane {

    private SimulationState State;

    private SimulationDaysTab SimulationDaysTab;

    private SimulationWinnersTab SimulationWinnersTab;

    private ExportBallRollsPanel ExportBallRollsPanel;

    public SimulationResultsPanel(SimulationState State) {
        super();

        this.State = State;

        SimulationDaysTab = new SimulationDaysTab(State);
        SimulationWinnersTab = new SimulationWinnersTab(State);
        ExportBallRollsPanel = new ExportBallRollsPanel(State);

        super.addTab("Balls Rolled Per Round", SimulationDaysTab);
        super.addTab("Winners Per Round", SimulationWinnersTab);
        super.addTab("Export Balls Rolled Per Round", ExportBallRollsPanel);
    }

}
