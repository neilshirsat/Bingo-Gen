package io.neilshirsat.components.textfield;

import javax.swing.*;
import java.awt.*;

public class TextField extends JPanel {

    private JLabel Label;

    private JTextField TextField;

    private int PreferredWidth;

    private int PreferredHeight;

    private int MaxWidth;

    private int MaxHeight;

    public TextField() {
        super();

        Label = new JLabel();
        TextField = new JTextField();

        super.add( Label );
        super.add( TextField );

        if ( super.getLayout() instanceof FlowLayout fl ) {
            fl.setAlignment( FlowLayout.LEFT );
        }

        super.setPreferredSize(new Dimension(600, 50));
        super.setMaximumSize(new Dimension(1000, 50));
    }

    public JLabel getLabel() {
        return Label;
    }

    public void setLabel(JLabel label) {
        Label = label;
    }

    public JTextField getTextField() {
        return TextField;
    }

    public void setTextField(JTextField textField) {
        TextField = textField;
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

    public void setInputColumns( int columns ){
        TextField.setColumns(columns);
    }

    public int getInputColumns() {
        return TextField.getColumns();
    }



}
