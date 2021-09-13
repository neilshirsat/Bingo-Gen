package io.neilshirsat.ui.simulation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class SimulationPanel extends JPanel {

    private JButton RollButton;

    private JTable SimulationHistory;

    private JScrollPane SimulationHistoryScrollPane;

    private DefaultTableModel SimulationHistoryModel;

    private GroupLayout SimulationPanelLayout;

    public SimulationPanel() {
        super();

        SimulationPanelLayout = new GroupLayout(this);
        super.setLayout(SimulationPanelLayout);
        super.setBorder(new EmptyBorder(20, 20, 20, 20));

        SimulationHistoryModel = new DefaultTableModel();
        SimulationHistory = new JTable(SimulationHistoryModel);
        SimulationHistoryScrollPane = new JScrollPane(SimulationHistory);

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
                .addComponent(SimulationHistoryScrollPane)
                .addComponent(RollButton)
        );
        SimulationPanelLayout.setVerticalGroup(SimulationPanelLayout.createSequentialGroup()
                .addComponent(SimulationHistoryScrollPane)
                .addComponent(RollButton)
        );
    }

}
