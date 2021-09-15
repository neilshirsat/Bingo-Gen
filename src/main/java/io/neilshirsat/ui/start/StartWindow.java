package io.neilshirsat.ui.start;

import io.neilshirsat.ui.startup.StartUpPanel;

import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {

    private StartPanel StartPanel;

    public StartWindow() {
        super();
        super.setUndecorated(true);
        super.setTitle("Bingo Gen_");
        super.setSize( 800, 450);

        StartPanel = new StartPanel();
        super.setContentPane(StartPanel);

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        setVisible(true);
    }

}
