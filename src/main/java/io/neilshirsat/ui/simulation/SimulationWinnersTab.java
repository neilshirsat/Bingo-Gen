package io.neilshirsat.ui.simulation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SimulationWinnersTab extends JPanel {

    private GroupLayout SimulationWinnersLayout;

    private SimulationState State;

    private JTable SimulationWinnersTable;

    private DefaultTableModel SimulationWinnersTableModel;

    private JScrollPane SimulationWinnersScrollPane;

    public SimulationWinnersTab(SimulationState State) {
        super();

        this.State = State;

        SimulationWinnersLayout = new GroupLayout(this);
        super.setLayout(SimulationWinnersLayout);

        SimulationWinnersTableModel = new DefaultTableModel();
        SimulationWinnersTable = new JTable(SimulationWinnersTableModel);
        SimulationWinnersScrollPane = new JScrollPane(SimulationWinnersTable);

        SimulationWinnersTableModel.addColumn("Place");
        SimulationWinnersTableModel.addColumn("Card Number");

        for (int i = 0; i < State.getGameWinnerCards().size(); i++) {
            SimulationWinnersTableModel.addRow(new String[]{
                    (i+1) + "",
                    State.getGameWinnerCards().get(i) + ""
            });
        }

        SimulationWinnersLayout.setHorizontalGroup(SimulationWinnersLayout.createParallelGroup()
                .addComponent(SimulationWinnersScrollPane)
        );
        SimulationWinnersLayout.setVerticalGroup(SimulationWinnersLayout.createSequentialGroup()
                .addComponent(SimulationWinnersScrollPane)
        );

    }

    public void getDays() {

    }

}
