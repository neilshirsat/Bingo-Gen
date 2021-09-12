package io.neilshirsat.components.colorpicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPickerWindow extends JFrame {

    private JPanel RootPanel;

    private JButton CloseButton;

    private JButton ChooseButton;

    private JColorChooser ColorChooser;

    private ColorPicker ColorPicker;

    public ColorPickerWindow( ColorPicker ColorPicker ) {
        super();
        this.ColorPicker = ColorPicker;

        JMenuBar menuBar = new JMenuBar();
        JMenu File = new JMenu("File");

        //super.setUndecorated(true);
        super.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        super.setResizable(false);
        super.setTitle("Choose a Color");
        super.setJMenuBar( menuBar );
        super.setSize(
                800,
                800
        );

        RootPanel = new JPanel();
        RootPanel.setLayout(new BorderLayout());

        ColorChooser = new JColorChooser();
        RootPanel.add(ColorChooser, BorderLayout.NORTH);

        ChooseButton = new JButton("Choose Color");
        CloseButton = new JButton("Close");

        JRootPane Root = SwingUtilities.getRootPane(this);
        Root.setDefaultButton(ChooseButton);

        ChooseButton.addActionListener(e -> {
            ColorPickerWindow.super.setVisible(false);
            ColorPickerWindow.this.ColorPicker.setCurrentColor(ColorPickerWindow.this.ColorChooser.getColor());
        });
        CloseButton.addActionListener(e -> ColorPickerWindow.super.setVisible(false));

        JPanel ActionPane = new JPanel();

        ActionPane.add( ChooseButton);
        ActionPane.add( CloseButton );

        RootPanel.add( ActionPane );

        super.add( RootPanel );
        super.pack();
    }

}
