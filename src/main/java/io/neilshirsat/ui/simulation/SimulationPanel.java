package io.neilshirsat.ui.simulation;

import io.neilshirsat.ui.bingo.BingoPanel;
import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class SimulationPanel extends JPanel {

    private JButton RollButton;

    private BingoPanel BingoPanel;

    private JTable SimulationHistory;

    private JScrollPane SimulationHistoryScrollPane;

    private DefaultTableModel SimulationHistoryModel;

    private GroupLayout SimulationPanelLayout;

    public SimulationPanel(BingoState State) {
        super();

        SimulationPanelLayout = new GroupLayout(this);
        super.setLayout(SimulationPanelLayout);
        super.setBorder(new EmptyBorder(20, 20, 20, 20));

        SimulationHistoryModel = new DefaultTableModel();
        SimulationHistory = new JTable(SimulationHistoryModel);
        SimulationHistoryScrollPane = new JScrollPane(SimulationHistory);

        BingoPanel = new BingoPanel(State);
        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        BingoPanel.setPreferredSize(  new Dimension( (int)WindowDimension.getHeight() * 15/16 * 5/6 , (int)WindowDimension.getHeight() * 15/16));
        BingoPanel.setMaximumSize(  new Dimension( (int)WindowDimension.getHeight() * 15/16 * 5/6 , (int)WindowDimension.getHeight() * 15/16));

        SimulationHistoryModel.addColumn("No.");
        SimulationHistoryModel.addColumn("Bingo Square Called");
        SimulationHistoryModel.addColumn("Square Coordinates");
        SimulationHistoryModel.addColumn("Min Steps for Bingo");

        RollButton = new JButton("Roll Button");
        RollButton.addActionListener(e->{
            SimulationHistoryModel.addRow(new String[]{"1", "1", "1", "1"});
            SimulationHistoryModel.addRow(new String[]{"1", "1", "1", "1"});
        });

        SimulationPanelLayout.setHorizontalGroup(SimulationPanelLayout.createParallelGroup()
                .addGroup(SimulationPanelLayout.createSequentialGroup()
                        .addComponent(BingoPanel)
                        .addComponent(SimulationHistoryScrollPane)
                )
                .addComponent(RollButton)
        );
        SimulationPanelLayout.setVerticalGroup(SimulationPanelLayout.createSequentialGroup()
                .addGroup(SimulationPanelLayout.createParallelGroup()
                        .addComponent(BingoPanel)
                        .addComponent(SimulationHistoryScrollPane)
                )
                .addComponent(RollButton)
        );
    }

}
