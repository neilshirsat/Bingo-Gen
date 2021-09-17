package io.neilshirsat.ui.simulation;

import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SimulationWindow extends JFrame {

    private SimulationPanel SimulationPanel;

    private io.neilshirsat.util.WindowCloseListener WindowCloseListener;

    public SimulationWindow(BingoState BingoState, int BingoBoardCount, int DayCount, int Seed, int Winners) {
        super();

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

        SimulationPanel = new SimulationPanel(BingoState, BingoBoardCount, DayCount, Seed, Winners);

        super.setContentPane(SimulationPanel);
        super.pack();

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
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
