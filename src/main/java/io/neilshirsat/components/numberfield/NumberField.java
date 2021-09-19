package io.neilshirsat.components.numberfield;

import javax.swing.*;
import java.awt.*;

public class NumberField extends JPanel {

    private JLabel Label;

    private JSpinner NumberField;

    private int PreferredWidth;

    private int PreferredHeight;

    private int MaxWidth;

    private int MaxHeight;

    public NumberField() {
        super();

        Label = new JLabel();
        NumberField = new JSpinner();

        super.add( Label );
        super.add( NumberField );

        if ( super.getLayout() instanceof FlowLayout fl ) {
            fl.setAlignment( FlowLayout.LEFT );
        }

        super.setPreferredSize(new Dimension(250, 50));
        super.setMaximumSize(new Dimension(250, 50));
    }

    public JLabel getLabel() {
        return Label;
    }

    public void setLabel(JLabel label) {
        Label = label;
    }

    public JSpinner getNumberField() {
        return NumberField;
    }

    public void setNumberField(JSpinner numberField) {
        NumberField = numberField;
    }

    public int getPreferredWidth() {
        return PreferredWidth;
    }

    public void setPreferredWidth(int preferredWidth) {
        PreferredWidth = preferredWidth;
    }

    public int getPreferredHeight() {
        return PreferredHeight;
    }

    public void setPreferredHeight(int preferredHeight) {
        PreferredHeight = preferredHeight;
    }

    public int getMaxWidth() {
        return MaxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        MaxWidth = maxWidth;
    }

    public int getMaxHeight() {
        return MaxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        MaxHeight = maxHeight;
    }

    public void setLabelText( String label ){
        Label.setText(label);
    }

    public String getLabelText() {
        return Label.getText();
    }

}
