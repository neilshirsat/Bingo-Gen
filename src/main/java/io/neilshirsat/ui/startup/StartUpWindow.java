package io.neilshirsat.ui.startup;

import javax.swing.*;
import java.awt.*;

public class StartUpWindow extends JFrame {

    private StartUpPanel StartUpPanel;

    public StartUpWindow(){
        super();
        super.setUndecorated(true);
        super.setTitle("Bingo Gen_");
        super.setSize( 800, 450);

        StartUpPanel = new StartUpPanel();
        super.setContentPane(StartUpPanel);

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        setVisible(true);
    }

}
