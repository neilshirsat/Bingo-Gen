package io.neilshirsat.components;

import javax.swing.*;
import java.awt.*;

public class TextField extends JPanel {

    public JLabel label;

    public JTextField textField;

    public TextField() {
        super();

        label = new JLabel();
        textField = new JTextField();

        super.add( label );
        super.add( textField );

        if ( super.getLayout() instanceof FlowLayout fl ) {
            fl.setAlignment( FlowLayout.LEFT );
        }

        super.setPreferredSize(new Dimension(500, 50));
        super.setMaximumSize(new Dimension(1000, 50));
    }

}
