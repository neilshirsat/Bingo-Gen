package io.neilshirsat.ui.simulation;

import javax.swing.*;

public class SimulationResultsPanel extends JTabbedPane {

    private SimulationState State;

    private SimulationDaysTab SimulationDaysTab;

    private SimulationWinnersTab SimulationWinnersTab;

    public SimulationResultsPanel(SimulationState State) {
        super();

        this.State = State;

        SimulationDaysTab = new SimulationDaysTab(State);
        SimulationWinnersTab = new SimulationWinnersTab(State);

        super.addTab("Balls Rolled", SimulationDaysTab);
        super.addTab("Winners", SimulationWinnersTab);
    }

}
