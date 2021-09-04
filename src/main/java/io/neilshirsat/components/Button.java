package io.neilshirsat.components;

import mdlaf.animation.MaterialUIMovement;
import mdlaf.components.button.MaterialButtonUI;
import mdlaf.utils.MaterialColors;

import javax.swing.*;

public class Button extends MaterialButtonUI {

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.setBackground(super.background);
    }

}
