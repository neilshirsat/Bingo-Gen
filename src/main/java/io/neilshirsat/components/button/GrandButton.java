package io.neilshirsat.components.button;

import javax.swing.*;
import java.awt.*;

public class GrandButton extends JButton {

    public GrandButton(String c) {
        super(c);

        setFont(this.getFont().deriveFont(25f));
        setPreferredSize(new Dimension(750, 100));
        setMinimumSize(new Dimension(750, 100));
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }
}
