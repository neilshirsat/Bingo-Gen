package io.neilshirsat;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatOneDarkIJTheme;
import io.neilshirsat.ui.main.MainWindow;
import mdlaf.MaterialLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) throws Exception {

        FlatDarkLaf.setup();
        UIManager.setLookAndFeel( new FlatDarkLaf() );
        FlatOneDarkIJTheme.setup();
        FlatCarbonIJTheme.setup();

        StartUpWindow Window = new StartUpWindow();

        MainWindow Main = new MainWindow();
        Main.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        Window.setVisible(false);

    }

}
