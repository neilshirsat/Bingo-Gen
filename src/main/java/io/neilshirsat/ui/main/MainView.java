package io.neilshirsat.ui.main;

import io.neilshirsat.Application;
import io.neilshirsat.components.verticaltabs.VerticalTabs;
import io.neilshirsat.ui.bingo.BingoPreview;
import io.neilshirsat.ui.bingo.BingoSquareState;
import io.neilshirsat.ui.bingo.BingoState;
import io.neilshirsat.ui.customize.CustomizeTab;
import io.neilshirsat.ui.customize.CustomizeWindow;
import io.neilshirsat.ui.simulation.SimulationWindow;
import io.neilshirsat.ui.simulation.StartSimulationCancelHandler;
import io.neilshirsat.ui.simulation.StartSimulationWindow;
import io.neilshirsat.util.ShapeType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class MainView extends JPanel {

    private GroupLayout MainViewLayout;

    private boolean PreviewOpen;

    private BingoPreview PreviewWindow;

    private BingoState BingoState;

    private JButton PreviewButton;

    private JButton SimulationButton;

    private StartSimulationWindow StartSimulationWindow;

    private SimulationWindow SimulationWindow;

    private JButton PrintButton;

    private VerticalTabs MainViewTabs;

    private CustomizeTab CustomizeBingoTabs;

    private JPanel PreviewBingoTab;

    private JPanel SimulationBingoTab;

    private SettingsPanel SettingsTab;

    public MainView() {
        super();

        MainViewLayout = new GroupLayout(this);
        super.setLayout(MainViewLayout);
        super.setBorder(new EmptyBorder(20, 20, 20, 20));

        PreviewButton = new JButton("Preview");

        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT,
                    Objects.requireNonNull(Application.class.getResourceAsStream("NotoSans-Regular.ttf")));
        } catch (Exception e) {
            System.out.println("Font Not Initialized");
        }

        String[] TitleLetters = new String[]{"B", "I", "N", "G", "O"};

        BingoSquareState[] TitleState = new BingoSquareState[5];
        for (int i = 0; i < 5; i++){
            TitleState[i] = new BingoSquareState();
            TitleState[i].setAnalise(true);
            TitleState[i].setTextAnalise(true);
            TitleState[i].setTextColor(Color.BLACK);
            TitleState[i].setFontSize(50f);
            TitleState[i].setFontStyle(Font.PLAIN);
            TitleState[i].setTextFont(font);
            TitleState[i].setBorderColor(Color.BLACK);
            TitleState[i].setBackgroundColor(Color.WHITE);
            TitleState[i].setBorderThickness(2);
            TitleState[i].setPositionX(0);
            TitleState[i].setPositionY(0);
            TitleState[i].setShape(ShapeType.CIRCLE);
            TitleState[i].setBaseBackgroundColor(Color.BLACK);
            TitleState[i].setTitle(true);
            TitleState[i].setTitleText(TitleLetters[i]);
        }

        BingoSquareState[][] SquareState = new BingoSquareState[5][5];
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                SquareState[i][j] = new BingoSquareState();
                SquareState[i][j].setAnalise(true);
                SquareState[i][j].setTextAnalise(true);
                SquareState[i][j].setSquareNumber(TitleLetters[i] + " " + j);
                SquareState[i][j].setTextColor(Color.BLACK);
                SquareState[i][j].setFontSize(50f);
                SquareState[i][j].setFontStyle(Font.PLAIN);
                SquareState[i][j].setTextFont(font);
                SquareState[i][j].setBorderColor(Color.BLACK);
                SquareState[i][j].setBackgroundColor(Color.WHITE);
                SquareState[i][j].setBorderThickness(2);
                SquareState[i][j].setPositionX(0);
                SquareState[i][j].setPositionY(0);
                SquareState[i][j].setShape(ShapeType.RECTANGLE);
                SquareState[i][j].setBaseBackgroundColor(Color.BLACK);
                SquareState[i][j].setFreeSpace(false);
                SquareState[i][j].setFreeSpaceText("Free Space");
                SquareState[i][j].setSelectedColor(Color.RED);
            }
        }

        SquareState[2][2].setFreeSpace(true);
        SquareState[2][2].setFreeSpaceText("Free Space");
        SquareState[2][2].setFontSize(20f);

        BingoState = new BingoState();
        BingoState.setBaseBackgroundColor(Color.WHITE);
        BingoState.setBingoSquares(SquareState);
        BingoState.setTitleSquares(TitleState);

        PreviewWindow = new BingoPreview(BingoState);

        PreviewButton.addActionListener(e -> {
            PreviewWindow.setVisible(!PreviewWindow.isVisible());
            PreviewButton.setText(
                    PreviewWindow.isVisible() ? "Close Preview" : "Preview");
        });
        PreviewWindow.setWindowCloseListener(() -> {
            PreviewWindow.setVisible(!PreviewWindow.isVisible());
            PreviewButton.setText(
                    PreviewWindow.isVisible() ? "Close Preview" : "Preview");
        });

        SimulationButton = new JButton("Simulation");

        SimulationButton.addActionListener(e -> {
            StartSimulationWindow = new StartSimulationWindow();
            StartSimulationWindow.setSimulationCancelHandler(()->{
                SimulationButton.setEnabled(true);
            });
            StartSimulationWindow.setSimulationCloseHandler((int board, int age, int seed, int winner)->{
                SimulationWindow = new SimulationWindow(PreviewWindow.getBingoState(), board, age, seed, winner);
                SimulationWindow.setVisible(true);
                SimulationWindow.setWindowCloseListener(() -> {
                    SimulationWindow.setVisible(!SimulationWindow.isVisible());
                    SimulationButton.setEnabled(true);
                    SimulationButton.setText(
                            SimulationWindow.isVisible() ? "Close Simulation" : "Start Simulation");
                });
            });
            StartSimulationWindow.setVisible(true);
            SimulationButton.setEnabled(false);
        });


        PrintButton = new JButton("Print");

        CustomizeBingoTabs = new CustomizeTab(PreviewWindow.getBingoState());

        PreviewBingoTab = new JPanel();
        PreviewBingoTab.add(PreviewButton);

        SimulationBingoTab = new JPanel();
        SimulationBingoTab.add(SimulationButton);

        SettingsTab = new SettingsPanel();

        MainViewTabs = new VerticalTabs();
        MainViewTabs.addTab(
                "Style the Bingo",
                CustomizeBingoTabs
        );
        MainViewTabs.addTab(
                "Preview Board",
                PreviewBingoTab
        );
        MainViewTabs.addTab(
                "Start Simulation",
                SimulationBingoTab
        );
        MainViewTabs.addTab(
                "Settings",
                SettingsTab
        );


        MainViewLayout.setHorizontalGroup(MainViewLayout.createParallelGroup()
                .addComponent(MainViewTabs)
        );
        MainViewLayout.setVerticalGroup(MainViewLayout.createSequentialGroup()
                .addComponent(MainViewTabs)
        );

    }

}
