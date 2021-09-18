package io.neilshirsat.components.colorpicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPicker extends JPanel implements ActionListener {

    private ColorPickerWindow ColorPickerWindow;

    public JLabel ColorPickerLabel;

    private JButton ColorPickerButton;

    private Color CurrentColor;

    private ColorEventListener ActionListener;

    public ColorPicker(Color CurrentColor, String name ) {
        super();

        this.CurrentColor = CurrentColor;
        ColorPickerWindow = new ColorPickerWindow(this);

        ColorPickerLabel = new JLabel(name + ":");
        ColorPickerButton = new JButton();

        if ( super.getLayout() instanceof FlowLayout fl ) {
            fl.setAlignment( FlowLayout.LEFT );
        }

        ColorPickerButton.setPreferredSize(new Dimension(25, 25));
        ColorPickerButton.setBackground(CurrentColor);
        ColorPickerButton.addActionListener(this);
        super.add( ColorPickerLabel );
        super.add( ColorPickerButton );

        super.setPreferredSize(new Dimension(600, 50));
        super.setMaximumSize(new Dimension(1000, 50));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ColorPickerWindow.setVisible(true);
        SwingUtilities.updateComponentTreeUI(SwingUtilities.getRoot(ColorPickerWindow));
    }

    public io.neilshirsat.components.colorpicker.ColorPickerWindow getColorPickerWindow() {
        return ColorPickerWindow;
    }

    public void setColorPickerWindow(io.neilshirsat.components.colorpicker.ColorPickerWindow colorPickerWindow) {
        ColorPickerWindow = colorPickerWindow;
    }

    public JLabel getColorPickerLabel() {
        return ColorPickerLabel;
    }

    public void setColorPickerLabel(JLabel colorPickerLabel) {
        ColorPickerLabel = colorPickerLabel;
    }

    public JButton getColorPickerButton() {
        return ColorPickerButton;
    }

    public void setColorPickerButton(JButton colorPickerButton) {
        ColorPickerButton = colorPickerButton;
    }

    public Color getCurrentColor() {
        return CurrentColor;
    }

    public void setCurrentColor(Color currentColor) {
        CurrentColor = currentColor;
        ColorPickerButton.setBackground(CurrentColor);
        if (getActionListener() != null) {
            getActionListener().onColorChosen(new ColorEvent(CurrentColor));
        }
    }

    public ColorEventListener getActionListener() {
        return ActionListener;
    }

    public void setActionListener(ColorEventListener actionListener) {
        ActionListener = actionListener;
    }

}
