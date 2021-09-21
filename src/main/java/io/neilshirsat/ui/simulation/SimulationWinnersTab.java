package io.neilshirsat.ui.simulation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SimulationWinnersTab extends JPanel {

    private GroupLayout SimulationWinnersLayout;

    private SimulationState State;

    private JTable SimulationWinnersTable;

    private DefaultTableModel SimulationWinnersTableModel;

    private JScrollPane SimulationWinnersScrollPane;

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

    public SimulationWinnersTab(SimulationState State) {
        super();

        this.State = State;

        SimulationWinnersLayout = new GroupLayout(this);
        super.setLayout(SimulationWinnersLayout);

        SimulationWinnersTableModel = new DefaultTableModel();
        SimulationWinnersTable = new JTable(SimulationWinnersTableModel);
        SimulationWinnersScrollPane = new JScrollPane(SimulationWinnersTable);

        SimulationWinnersTableModel.addColumn("Place");
        SimulationWinnersTableModel.addColumn("Day");
        SimulationWinnersTableModel.addColumn("Round");
        SimulationWinnersTableModel.addColumn("Turn");
        SimulationWinnersTableModel.addColumn("Roll");
        SimulationWinnersTableModel.addColumn("Card Number");

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
        int Place = 1;
        for (int i = 0; i < State.getDayCount(); i++) {
            for (int  j = 0; j < 2; j++) {
                //System.out.println(table[j][i]);
                for (int k = 0; k <= table[j][i]; k++) {

                    //check when the turn at which the board won and the turn on the loop that is currently selected is the same
                    for (int l = State.getGameWinnerCardsTurn().indexOf(Count); l <= State.getGameWinnerCardsTurn().lastIndexOf(Count); l++){
                        if (l < 0) {
                            continue;
                        }
                        SimulationWinnersTableModel.addRow(new String[]{
                                Place + "",
                                DAYS_TABLE[i],
                                PERIOD_TABLE[j],
                                State.getGameWinnerCardsTurn().get(l) + "",
                                State.getRolledBalls().get(l) + "",
                                State.getGameWinnerCards().get(Place-1) + ""
                        });
                        Place++;
                    }

                    Count++;
                }
                remainder--;
            }
        }

        /*
        int ballsLeft = State.getRolledBalls().size() % (State.getDayCount() * 2);
        System.out.println("----------------------------------------------");
        System.out.println(Math.max(ballsLeft, 0));
        System.out.println(State.getRolledBalls().size());
        System.out.println("----------------------------------------------");
        int Count = 0;
        int Place = 1;
        for (int i = 0; i < State.getDayCount(); i++) {
            for (int  j = 0; j < 2; j++) {
                System.out.println("----------------------------------------------");
                System.out.println(DAYS_TABLE[i]);
                System.out.println(PERIOD_TABLE[j]);
                System.out.println(Math.max(ballsLeft, 0) + (State.getRolledBalls().size() % (State.getDayCount() * 2)) + (State.getRolledBalls().size() / (State.getDayCount() * 2)));
                System.out.println(Math.max(ballsLeft, 0));
                System.out.println((State.getRolledBalls().size() % (State.getDayCount() * 2)));
                System.out.println((State.getRolledBalls().size() / (State.getDayCount() * 2)));
                for (int k = 0; k < Math.max(ballsLeft, 0) + (State.getRolledBalls().size() / (State.getDayCount() * 2)); k++) {
                    for (int l = 0; l < State.getWinners(); l++) {
                        System.out.println("------------------------------------");
                        System.out.println(State.getGameWinnerCardsTurn().get(l));
                        System.out.println(Count);
                        if (State.getGameWinnerCardsTurn().get(l) == (Count+1)) {
                            SimulationWinnersTableModel.addRow(new String[]{
                                    Place + "",
                                    DAYS_TABLE[i],
                                    PERIOD_TABLE[j],
                                    State.getGameWinnerCardsTurn().get(Count) + "",
                                    State.getRolledBalls().get(Count) + "",
                                    State.getGameWinnerCards().get(Place-1) + ""
                            });
                            Place++;
                        }
                    }
                    Count++;
                }
                ballsLeft--;
            }
        }
         */

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
