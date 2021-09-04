package io.neilshirsat;

import io.neilshirsat.components.DarkTheme;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.MaterialOceanicTheme;

import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) throws Exception {

        UIManager.setLookAndFeel( new MaterialLookAndFeel(new MaterialOceanicTheme()));

        StartUpWindow Window = new StartUpWindow();

        MainWindow Main = new MainWindow();
        Main.setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);
        Window.setVisible(false);

    }

}
