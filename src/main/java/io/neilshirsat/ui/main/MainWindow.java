package io.neilshirsat.ui.main;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private MainView RootPanel;

    public MainWindow() {
        super();

        RootPanel = new MainView();

        super.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        super.setTitle("Bingo Gen_");
        super.setContentPane(RootPanel);
        super.setResizable(false);
        super.setSize(
                800,
                600
        );

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        //super.pack();
        super.setVisible(true);
    }

}
