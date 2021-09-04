package io.neilshirsat.components;

import mdlaf.components.titlepane.MaterialTitlePaneUI;

import javax.swing.*;

public class TitleBar extends MaterialTitlePaneUI {

    public TitleBar(JRootPane root) {
        super(root);
        super.createMenu().add("Bingo Gen_");
    }

}
