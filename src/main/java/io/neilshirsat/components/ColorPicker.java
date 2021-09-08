package io.neilshirsat.components;

import io.neilshirsat.mainview.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPicker extends JFrame {

    private JPanel UI;

    public JLabel ColorPickerLabel;

    private JButton UIButton;

    private Color SelectedColor;

    private JPanel RootPanel;

    private JButton CloseButton;

    private JButton ChooseButton;

    private JColorChooser ColorChooser;

    private String name;

    private ColorAction colorAction;

    public ColorPicker(String name, Color SelectedColor ) {
        super();

        this.name = name;
        this.SelectedColor = SelectedColor;
        colorAction = null;

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

        ChooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColorPicker.this.setVisible(false);
                ColorPicker.this.SelectedColor = ColorPicker.this.ColorChooser.getColor();
                ColorPicker.this.UIButton.setBackground(ColorPicker.this.SelectedColor);
                if (ColorPicker.this.colorAction != null) {
                    ColorPicker.this.colorAction.actionPerformed(ColorPicker.this.SelectedColor);
                }
            }
        });
        CloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColorPicker.this.setVisible(false);
            }
        });

        JPanel ActionPane = new JPanel();

        ActionPane.add( ChooseButton);
        ActionPane.add( CloseButton );

        RootPanel.add( ActionPane );

        super.add( RootPanel );
        super.pack();

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        UI = new JPanel();

        ColorPickerLabel = new JLabel(name + ":");
        UIButton = new JButton();
        UIButton.setPreferredSize(new Dimension(25, 25));
        UIButton.setBackground(SelectedColor);
        UIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColorPicker.super.setVisible(true);
            }
        });
        UI.add( ColorPickerLabel );
        UI.add( UIButton );
        UI.setPreferredSize(new Dimension(1000, 50));
        UI.setMaximumSize(new Dimension(1000, 50));

        if ( UI.getLayout() instanceof FlowLayout fl ) {
            fl.setAlignment( FlowLayout.LEFT );
        }

    }

    public void setActionListener(ColorAction colorAction) {
        this.colorAction = colorAction;
    }

    public JPanel getUI() {
        return UI;
    }

    public void setUI(JPanel UI) {
        this.UI = UI;
    }

    public JLabel getColorPickerLabel() {
        return ColorPickerLabel;
    }

    public void setColorPickerLabel(JLabel colorPickerLabel) {
        ColorPickerLabel = colorPickerLabel;
    }

    public JButton getUIButton() {
        return UIButton;
    }

    public void setUIButton(JButton UIButton) {
        this.UIButton = UIButton;
    }

    public Color getSelectedColor() {
        return SelectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        SelectedColor = selectedColor;
    }

    public JPanel getRootPanel() {
        return RootPanel;
    }

    public void setRootPanel(JPanel rootPanel) {
        RootPanel = rootPanel;
    }

    public JButton getCloseButton() {
        return CloseButton;
    }

    public void setCloseButton(JButton closeButton) {
        CloseButton = closeButton;
    }

    public JButton getChooseButton() {
        return ChooseButton;
    }

    public void setChooseButton(JButton chooseButton) {
        ChooseButton = chooseButton;
    }

    public JColorChooser getColorChooser() {
        return ColorChooser;
    }

    public void setColorChooser(JColorChooser colorChooser) {
        ColorChooser = colorChooser;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public ColorAction getColorAction() {
        return colorAction;
    }

    public void setColorAction(ColorAction colorAction) {
        this.colorAction = colorAction;
    }

}
