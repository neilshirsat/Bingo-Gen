package io.neilshirsat.ui.simulation;

import io.neilshirsat.components.numberfield.NumberField;
import io.neilshirsat.ui.bingo.BingoPanel;
import io.neilshirsat.ui.bingo.BingoSquareState;
import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class SimulationPanel extends JPanel {

    private JButton RollButton;

    private BingoPanel BingoPanel;

    private JTable SimulationHistory;

    private JScrollPane SimulationHistoryScrollPane;

    private DefaultTableModel SimulationHistoryModel;

    private GroupLayout SimulationPanelLayout;

    private int[][][] BingoBoardNumbers;

    private boolean[][][] BingoSquareSelected;

    private GenerateBingoTiles BingoGenerator;

    private int BingoTurn;

    private int CurrentCardNumber;

    private NumberField CardNumberSelector;

    private int BingoBoardCount;

    private int DayCount;

    private int Seed;

    private int Winners;

    private ArrayList<Integer> GameWinnerCards;

    private SimulationChangeGraph SimulationChangeGraph;

    public SimulationPanel(BingoState State, int BingoBoardCount, int DayCount, int Seed, int Winners) {
        super();

        this.BingoBoardCount = BingoBoardCount;
        this.DayCount = DayCount;
        this.Seed = Seed;
        this.Winners = Winners;

        GameWinnerCards = new ArrayList<>(Winners);

        SimulationPanelLayout = new GroupLayout(this);
        super.setLayout(SimulationPanelLayout);
        super.setBorder(new EmptyBorder(20, 20, 20, 20));

        SimulationHistoryModel = new DefaultTableModel();
        SimulationHistory = new JTable(SimulationHistoryModel);
        SimulationHistoryScrollPane = new JScrollPane(SimulationHistory);

        BingoPanel = new BingoPanel(State);
        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        BingoPanel.setPreferredSize(  new Dimension( (int)WindowDimension.getHeight() * 13/16 * 5/6 , (int)WindowDimension.getHeight() * 13/16));
        BingoPanel.setMaximumSize(  new Dimension( (int)WindowDimension.getHeight() * 13/16 * 5/6 , (int)WindowDimension.getHeight() * 13/16));

        SimulationHistoryModel.addColumn("No.");
        SimulationHistoryModel.addColumn("Bingo Square Called");
        SimulationHistoryModel.addColumn("Amount of Winners");
        SimulationHistoryModel.addColumn("Bingo Winners");

        BingoGenerator = new GenerateBingoTiles(Seed);
        BingoBoardNumbers = new int[BingoBoardCount][5][5];
        BingoSquareSelected = new boolean[BingoBoardCount][5][5];
        for (int i = 0; i < BingoBoardCount; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    BingoSquareSelected[i][j][k] = false;
                }
            }
        }
        for (int i = 0; i < BingoBoardCount; i++) {
            BingoBoardNumbers[i] = BingoGenerator.GenerateBingoTileSquare();
        }

        BingoTurn = 1;
        CurrentCardNumber = 0;
        shuffle(CurrentCardNumber);

        RollButton = new JButton("Roll Button");
        RollButton.addActionListener(e->{
            int num = BingoGenerator.GenerateBingoNumber();
            setNumber(num);
            SimulationChangeGraph.add(BingoTurn, GameWinnerCards.size());
            SimulationHistoryModel.addRow(new String[]{ BingoTurn + "", num + "", GameWinnerCards.size() + "", GameWinnerCards.toString() });
            if (BingoTurn++ == 75) {
                RollButton.setEnabled(false);
            }
        });

        CardNumberSelector = new NumberField();
        CardNumberSelector.setLabelText("Card Number");
        CardNumberSelector.getNumberField().setModel(new SpinnerNumberModel(0, 0, BingoBoardCount-1, 1));
        CardNumberSelector.getNumberField().addChangeListener(e->{
            CurrentCardNumber = (int) CardNumberSelector.getNumberField().getValue();
            shuffle(CurrentCardNumber);
        });

        SimulationChangeGraph = new SimulationChangeGraph();
        SimulationChangeGraph.setVisible(true);

        SimulationPanelLayout.setHorizontalGroup(SimulationPanelLayout.createParallelGroup()
                .addGroup(SimulationPanelLayout.createSequentialGroup()
                        .addComponent(BingoPanel)
                        .addGap(20)
                        .addComponent(SimulationHistoryScrollPane)
                )
                .addGroup(SimulationPanelLayout.createParallelGroup()
                        .addComponent(RollButton)
                        .addGap(20)
                        .addComponent(CardNumberSelector)
                        .addGap(20)
                )
        );
        SimulationPanelLayout.setVerticalGroup(SimulationPanelLayout.createSequentialGroup()
                .addGroup(SimulationPanelLayout.createParallelGroup()
                        .addComponent(BingoPanel)
                        .addComponent(SimulationHistoryScrollPane)
                )
                .addGap(25)
                .addGroup(SimulationPanelLayout.createSequentialGroup()
                        .addComponent(RollButton)
                        .addGap(20)
                        .addComponent(CardNumberSelector)
                        .addGap(20)
                )
        );

    }

    public void shuffle(int CardNumber) {
        BingoSquareState[][] State = BingoPanel.getBingoState().getBingoSquares();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                State[i][j].setSquareNumber(BingoBoardNumbers[CardNumber][i][j] + "");
                if (State[i][j].isFreeSpace() || BingoSquareSelected[CardNumber][i][j] ) {
                    State[i][j].setSelected(true);
                }
                else {
                    State[i][j].setSelected(false);
                }
            }
        }
    }

    public void setNumber(int num) {
        for (int i = 0; i < BingoBoardNumbers.length; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (BingoBoardNumbers[i][j][k] == num) {
                        BingoSquareSelected[i][j][k] = true;
                        if (i == CurrentCardNumber) {
                            BingoPanel.getBingoState().getBingoSquares()[j][k].setSelected(true);
                        }
                    }
                }
            }
            if (checkBingo(BingoSquareSelected[i])) {
                GameWinnerCards.add(i);
                if (GameWinnerCards.size() == Winners) {
                    RollButton.setEnabled(false);
                    JOptionPane.showMessageDialog(
                            this,
                            "Max Amount of Winners Reached. The Simulation Has Ended",
                            "Simulation Ended",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    return;
                }
            }
        }
    }

    public boolean checkBingo(boolean[][] matrix) {
        return (
                (matrix[0][0] && matrix[0][1] && matrix[0][2] && matrix[0][3] && matrix[0][4]) ||
                (matrix[1][0] && matrix[1][1] && matrix[1][2] && matrix[1][3] && matrix[1][4]) ||
                (matrix[2][0] && matrix[2][1] && matrix[2][2] && matrix[2][3] && matrix[2][4]) ||
                (matrix[3][0] && matrix[3][1] && matrix[3][2] && matrix[3][3] && matrix[3][4]) ||
                (matrix[4][0] && matrix[4][1] && matrix[4][2] && matrix[4][3] && matrix[4][4]) ||
                (matrix[0][0] && matrix[1][0] && matrix[2][0] && matrix[3][0] && matrix[4][0]) ||
                (matrix[0][1] && matrix[1][1] && matrix[2][1] && matrix[3][1] && matrix[4][1]) ||
                (matrix[0][2] && matrix[1][2] && matrix[2][2] && matrix[3][2] && matrix[4][2]) ||
                (matrix[0][3] && matrix[1][3] && matrix[2][3] && matrix[3][3] && matrix[4][3]) ||
                (matrix[0][4] && matrix[1][4] && matrix[2][4] && matrix[3][4] && matrix[4][4]) ||
                (matrix[0][0] && matrix[1][1] && matrix[2][2] && matrix[3][3] && matrix[4][4]) ||
                (matrix[0][4] && matrix[1][3] && matrix[2][2] && matrix[3][1] && matrix[4][0])
        );
    }

}
