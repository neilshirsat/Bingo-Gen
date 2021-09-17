package io.neilshirsat.ui.simulation;

import io.neilshirsat.components.numberfield.NumberField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StartSimulationWindow extends JDialog {

    private NumberField BingoBoards;

    private NumberField AmountOfDays;

    private NumberField Seed;

    private NumberField Winners;

    private JButton CreateSimulationButton;

    private JButton CloseButton;

    private JPanel SimulationPanel;

    private GroupLayout SimulationPanelLayout;

    private StartSimulationCloseHandler SimulationCloseHandler;

    public StartSimulationWindow() {

        super();

        super.setTitle("Create Simulation");

        SimulationPanel = new JPanel();
        SimulationPanelLayout = new GroupLayout(SimulationPanel);
        SimulationPanel.setLayout(SimulationPanelLayout);


        BingoBoards = new NumberField();
        BingoBoards.setLabelText("Amount of Bingo Boards: ");
        BingoBoards.getNumberField().setModel(new SpinnerNumberModel(1, 1, 1000000, 1));

        AmountOfDays = new NumberField();
        AmountOfDays.setLabelText("Amount of Days: ");
        AmountOfDays.getNumberField().setModel(new SpinnerNumberModel(1, 1, 75, 1));

        Seed = new NumberField();
        Seed.setLabelText("Seed: ");
        Seed.getNumberField().setModel(new SpinnerNumberModel(0, 0, 100000, 1));

        Winners = new NumberField();
        Winners.setLabelText("Amount of Winners: ");
        Winners.getNumberField().setModel(new SpinnerNumberModel(1, 1, 1000000, 1));

        CreateSimulationButton = new JButton("Create Simulation");
        CreateSimulationButton.addActionListener(e->{
            getSimulationCloseHandler().handle(
                    (int) BingoBoards.getNumberField().getValue(),
                    (int) AmountOfDays.getNumberField().getValue(),
                    (int) Seed.getNumberField().getValue(),
                    (int) Winners.getNumberField().getValue()
            );
            StartSimulationWindow.this.setVisible(false);
        });
        CloseButton = new JButton("Close Button");

        SimulationPanel.setBorder(new EmptyBorder(20,20,20,20));

        SimulationPanelLayout.setHorizontalGroup(SimulationPanelLayout.createParallelGroup()
                .addComponent(BingoBoards)
                .addComponent(AmountOfDays)
                .addComponent(Seed)
                .addComponent(Winners)
                .addGroup(
                        SimulationPanelLayout.createSequentialGroup()
                                .addComponent(CreateSimulationButton)
                                .addGap(15)
                                .addComponent(CloseButton)
                )
        );
        SimulationPanelLayout.setVerticalGroup(SimulationPanelLayout.createSequentialGroup()
                .addComponent(BingoBoards)
                .addGap(15)
                .addComponent(AmountOfDays)
                .addGap(15)
                .addComponent(Seed)
                .addGap(15)
                .addComponent(Winners)
                .addGap(15)
                .addGroup(
                        SimulationPanelLayout.createParallelGroup()
                                .addComponent(CreateSimulationButton)
                                .addGap(15)
                                .addComponent(CloseButton)
                )
        );

        SwingUtilities.getRootPane(this).setDefaultButton(CreateSimulationButton);

        super.add(SimulationPanel);

        super.pack();
        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

    }

    public StartSimulationCloseHandler getSimulationCloseHandler() {
        return SimulationCloseHandler;
    }

    public void setSimulationCloseHandler(StartSimulationCloseHandler simulationCloseHandler) {
        SimulationCloseHandler = simulationCloseHandler;
    }

}
