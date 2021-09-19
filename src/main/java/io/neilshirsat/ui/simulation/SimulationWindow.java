package io.neilshirsat.ui.simulation;

import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class SimulationWindow extends JFrame {

    private SimulationPanel SimulationPanel;

    private io.neilshirsat.util.WindowCloseListener WindowCloseListener;

    private SimulationState State;

    public SimulationWindow(BingoState BingoState, int BingoBoardCount, int DayCount, int Seed, int Winners) {
        super();

        State = new SimulationState();
        State.setBingoBoardCount(BingoBoardCount);
        State.setDayCount(DayCount);
        State.setSeed(Seed);
        State.setWinners(Winners);
        State.setBingoTurn(1);
        State.setBingoGenerator(new GenerateBingoTiles(State.getSeed()));
        State.setRolledBalls(new ArrayList<>(75));
        State.setGameWinnerCards(new ArrayList<>(State.getWinners()));
        State.setBingoBoardNumbers(new int[State.getBingoBoardCount()][5][5]);
        State.setBingoSquareSelected(new boolean[State.getBingoBoardCount()][5][5]);
        State.setIsBoardWinners(new boolean[State.getBingoBoardCount()]);

        for (int i = 0; i < State.getBingoBoardCount(); i++) {
            State.getBingoBoardNumbers()[i] = State.getBingoGenerator().GenerateBingoTileSquare();
        }

        super.setTitle("Bingo Simulation");
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                int ConfirmClose = JOptionPane.showConfirmDialog(
                        null,
                        "Are You Sure You Want to Exit",
                        "Are You Sure You Want to Exit",
                        JOptionPane.YES_NO_OPTION);
                if (ConfirmClose != JOptionPane.YES_OPTION) {
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    return;
                }
                if (getWindowCloseListener() != null) {
                    getWindowCloseListener().close();
                }
                dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        SimulationPanel = new SimulationPanel(BingoState, State);

        super.setContentPane(SimulationPanel);

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setSize(  new Dimension( (int)WindowDimension.getWidth() * 15/16 , (int)WindowDimension.getHeight() * 15/16));
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

    }

    public io.neilshirsat.util.WindowCloseListener getWindowCloseListener() {
        return WindowCloseListener;
    }

    public void setWindowCloseListener(io.neilshirsat.util.WindowCloseListener windowCloseListener) {
        WindowCloseListener = windowCloseListener;
    }

}
