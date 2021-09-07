package io.neilshirsat.mainview;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class MainWindow extends JFrame {

    private MainView RootPanel;

    public MainWindow() {
        super();

        RootPanel = new MainView();

        JMenuBar menuBar = new JMenuBar();

        JMenu File = new JMenu("File");

        JMenu Edit = new JMenu("Edit");

        JMenu Settings = new JMenu("Settings");

        JMenu Info = new JMenu("Info");
        JMenuItem ReleaseNotes = new JMenuItem("Release Notes");
        JMenuItem UserNotes = new JMenuItem("User Notes");
        JMenuItem Manuel = new JMenuItem("Manuel");

        Info.add(ReleaseNotes);
        Info.add(UserNotes);
        Info.add(Manuel);

        menuBar.add( File );
        menuBar.add( Edit );
        menuBar.add( Settings );
        menuBar.add( Info );


        //super.setUndecorated(true);
        super.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        super.setTitle("Bingo Gen_");
        super.setJMenuBar( menuBar );
        super.setContentPane(RootPanel);
        super.setSize(
                800,
                800
        );

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        //super.pack();
        super.setVisible(true);
    }

}

