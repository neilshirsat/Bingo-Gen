package io.neilshirsat.components.verticaltabs;

import javax.swing.*;

public class VerticalTabs extends JTabbedPane {

    public VerticalTabs() {
        super();
        super.setTabPlacement(JTabbedPane.LEFT);
        super.setTabLayoutPolicy(JTabbedPane.VERTICAL);
    }

}
