package io.neilshirsat;

import io.neilshirsat.components.Button;
import io.neilshirsat.components.TitleBar;
import mdlaf.MaterialLookAndFeel;
import mdlaf.MaterialLookAndFeelInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Objects;

public class MainWindow extends JFrame {

    public MainWindow() {
        super();
        //super.setUndecorated(true);
        super.setTitle("Bingo Gen_");
        super.setSize( 800, 500);

        TitleBar titleBar = new TitleBar(this.rootPane);
        super.add( new MainWindowForm() );

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
