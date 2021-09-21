package io.neilshirsat.ui.simulation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;

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

    private String[] PERIOD_TABLE = new String[]{
            "AM",
            "PM",
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

        int[][] table = new int[2][State.getDayCount()];
        int remainder = State.getRolledBalls().size() % (State.getDayCount() * 2);
        for (int i = 0; i < State.getDayCount(); i++) {
            for (int  j = 0; j < 2; j++) {
                table[j][i] = State.getRolledBalls().size() / (State.getDayCount() * 2);
                if (remainder > 0) {
                    table[j][i] += 1;
                }
                remainder--;
            }
        }


        int Count = 0;
        for (int i = 0; i < State.getDayCount(); i++) {
            for (int  j = 0; j < 2; j++) {
                //System.out.println(table[j][i]);
                for (int k = 0; k < table[j][i]; k++) {
                    SimulationDaysTableModel.addRow(new String[]{
                            DAYS_TABLE[i],
                            PERIOD_TABLE[j],
                            State.getRolledBalls().get(Count) + ""
                    });
                    Count++;
                }
                remainder--;
            }
        }

        /*
        //System.out.println(State.getRolledBalls().size());
        int ballsLeft = State.getRolledBalls().size() % (State.getDayCount() * 2);
        int Count = 0;
        for (int i = 0; i < State.getDayCount(); i++) {
            for (int  j = 0; j < 2; j++) {
                //System.out.println("----------------------------------------------");
                //System.out.println(DAYS_TABLE[i]);
                //System.out.println(PERIOD_TABLE[j]);
                //System.out.println(Math.max(ballsLeft, 0) + (State.getRolledBalls().size() % (State.getDayCount() * 2)) + (State.getRolledBalls().size() / (State.getDayCount() * 2)));
                //System.out.println(Math.max(ballsLeft, 0));
                //System.out.println((State.getRolledBalls().size() % (State.getDayCount() * 2)));
                //System.out.println((State.getRolledBalls().size() / (State.getDayCount() * 2)));
                for (int k = 0; k < Math.max(ballsLeft, 0) + (State.getRolledBalls().size() / (State.getDayCount() * 2)); k++) {
                    SimulationDaysTableModel.addRow(new String[]{
                            DAYS_TABLE[i],
                            PERIOD_TABLE[j],
                            State.getRolledBalls().get(Count) + ""
                    });
                    Count++;
                }
                ballsLeft--;
            }
        }
         */

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
