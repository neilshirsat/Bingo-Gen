package io.neilshirsat.ui.simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SimulationWindow extends JFrame {

    private SimulationPanel SimulationPanel;

    private io.neilshirsat.util.WindowCloseListener WindowCloseListener;

    public SimulationWindow() {
        super();

        super.setTitle("Bingo Simulation");
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                if (getWindowCloseListener() != null) {
                    getWindowCloseListener().close();
                }
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

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setSize(  (int)WindowDimension.getHeight() * 15/16 * 5/6 , (int)WindowDimension.getHeight() * 15/16);
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        SimulationPanel = new SimulationPanel();

        super.setContentPane(SimulationPanel);
    }

    public io.neilshirsat.util.WindowCloseListener getWindowCloseListener() {
        return WindowCloseListener;
    }

    public void setWindowCloseListener(io.neilshirsat.util.WindowCloseListener windowCloseListener) {
        WindowCloseListener = windowCloseListener;
    }

}
