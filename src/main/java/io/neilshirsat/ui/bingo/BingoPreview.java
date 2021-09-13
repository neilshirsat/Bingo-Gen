package io.neilshirsat.ui.bingo;

import io.neilshirsat.Application;
import io.neilshirsat.util.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Objects;

/**
 * @author Neil Shirsat
 */
public class BingoPreview extends JFrame {

    private BingoState BingoState;

    private BingoPanel BingoPanel;

    private io.neilshirsat.util.WindowCloseListener WindowCloseListener;

    public BingoPreview(BingoState BingoState) {
        super();
        this.BingoState = BingoState;

        super.setTitle("Bingo Board Preview");
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

        BingoPanel = new BingoPanel(BingoState);

        super.setContentPane(BingoPanel);
    }

    public io.neilshirsat.ui.bingo.BingoState getBingoState() {
        return BingoState;
    }

    public void setBingoState(io.neilshirsat.ui.bingo.BingoState bingoState) {
        BingoState = bingoState;
    }

    public io.neilshirsat.ui.bingo.BingoPanel getBingoPanel() {
        return BingoPanel;
    }

    public void setBingoPanel(io.neilshirsat.ui.bingo.BingoPanel bingoPanel) {
        BingoPanel = bingoPanel;
    }

    public io.neilshirsat.util.WindowCloseListener getWindowCloseListener() {
        return WindowCloseListener;
    }

    public void setWindowCloseListener(io.neilshirsat.util.WindowCloseListener windowCloseListener) {
        WindowCloseListener = windowCloseListener;
    }

}
