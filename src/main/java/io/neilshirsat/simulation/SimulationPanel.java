package io.neilshirsat.simulation;

import io.neilshirsat.components.UtilityWindow;

import javax.swing.*;

public class SimulationPanel {

    private UtilityWindow Window;

    private boolean Visible;

    public SimulationPanel(){

    }

    public UtilityWindow getWindow() {
        return Window;
    }

    public void setWindow(UtilityWindow window) {
        Window = window;
    }

    public boolean isVisible() {
        return Visible;
    }

    public void setVisible(boolean visible) {
        Visible = visible;
    }

}
