package io.neilshirsat;

import io.neilshirsat.components.Button;
import io.neilshirsat.components.TextField;
import mdlaf.components.colorchooser.MaterialColorChooser;
import mdlaf.components.textfield.MaterialTextFieldUI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindowForm extends JPanel {

    private JTextField BingoGameName;

    private JTextField AmountofProjects;

    private MaterialColorChooser ColorPicker;

    private JColorChooser BingoBackground;

    private JColorChooser BingoColorPrimary;

    private JColorChooser BingoColorSecondary;

    private MaterialTextFieldUI TextField;

    private BingoPreviewWindow BingoPreview;

    //Buttons

    private JButton PreviewButton;

    private JButton PrintOut;

    private JButton GeneratePDF;

    private JButton GenerateJPG;

    private Button ButtonUI;

    public MainWindowForm() {
        super();

        BingoGameName = new JTextField();
        //BingoBackground = new JColorChooser();
        //BingoColorPrimary = new JColorChooser();
        //BingoColorSecondary = new JColorChooser();

        //TextField = new TextField();
        //TextField.installUI(BingoGameName);
        //ColorPicker = new MaterialColorChooser();

        //ColorPicker.installUI( BingoBackground );
        //ColorPicker.installUI( BingoColorPrimary );
        //ColorPicker.installUI( BingoColorSecondary );

        PreviewButton = new JButton("Preview Bingo Board");
        PrintOut = new JButton("Print Out");
        GeneratePDF = new JButton("Generate PDF");
        GenerateJPG = new JButton("Generate JPG");
        ButtonUI = new Button();

        BingoPreview = new BingoPreviewWindow();

        PreviewButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BingoPreview.setVisible(!BingoPreview.isVisible());
                PreviewButton.setText(BingoPreview.isVisible() ? "Close Preview" : "Preview Bingo Board");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        ButtonUI.installUI( PrintOut );
        ButtonUI.installUI( GeneratePDF );
        ButtonUI.installUI( GenerateJPG );

        super.add( BingoGameName );
        super.add( PreviewButton );
        //super.add( BingoBackground );
        //super.add( BingoColorPrimary );
        //super.add( BingoColorSecondary );
        super.add( PrintOut );
        super.add( GeneratePDF );
        super.add( GenerateJPG );


    }

}