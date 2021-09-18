package io.neilshirsat.ui.simulation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SimulationDaysTab extends JPanel {

    private GroupLayout SimulationDaysLayout;

    private SimulationState State;

    private JTable SimulationDaysTable;

    private DefaultTableModel SimulationDaysTableModel;

    private JScrollPane SimulationDaysScrollPane;

    private String[] DAYS_TABLE = new String[]{
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
    };

    public SimulationDaysTab(SimulationState State) {
        super();

        this.State = State;

        SimulationDaysLayout = new GroupLayout(this);
        super.setLayout(SimulationDaysLayout);

        SimulationDaysTableModel = new DefaultTableModel();
        SimulationDaysTable = new JTable(SimulationDaysTableModel);
        SimulationDaysScrollPane = new JScrollPane(SimulationDaysTable);

        SimulationDaysTableModel.addColumn("Day");
        SimulationDaysTableModel.addColumn("Round");
        SimulationDaysTableModel.addColumn("Rolled Ball");

        int NumberInGroupE = State.getRolledBalls().size() / (State.getDayCount() * 2);
        int NumberLeft = State.getRolledBalls().size() % (State.getDayCount() * 2);
        int Day = 0;
        int Group = 0;
        boolean isAM = true;
        int Count = 0;

        while (Count < State.getRolledBalls().size()) {

            //Check the Group
            if (Group < NumberLeft) {
                if (Count % (NumberInGroupE + 1) == 0 && Count != 0) {
                    if (isAM) {
                        isAM = false;
                    }
                    else {
                        Day++;
                        isAM = true;
                    }
                    Group++;
                }
            }
            else {
                if (Count % (NumberInGroupE) == 0 && Count != 0) {
                    if (isAM) {
                        isAM = false;
                    }
                    else {
                        Day++;
                        isAM = true;
                    }
                    Group++;
                }
            }

            SimulationDaysTableModel.addRow(new String[]{
                    DAYS_TABLE[Day],
                    isAM ? "AM" : "PM",
                    State.getRolledBalls().get(Count) + ""
            });

            Count++;

        }

        SimulationDaysLayout.setHorizontalGroup(SimulationDaysLayout.createParallelGroup()
                .addComponent(SimulationDaysScrollPane)
        );
        SimulationDaysLayout.setVerticalGroup(SimulationDaysLayout.createSequentialGroup()
                .addComponent(SimulationDaysScrollPane)
        );

    }

    public void getDays() {

    }

}
