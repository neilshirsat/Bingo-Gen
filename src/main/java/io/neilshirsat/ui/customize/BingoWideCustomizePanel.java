package io.neilshirsat.ui.customize;

import io.neilshirsat.components.colorpicker.ColorPicker;
import io.neilshirsat.components.filechooser.FileChooser;
import io.neilshirsat.components.numberfield.NumberField;
import io.neilshirsat.components.select.Select;
import io.neilshirsat.components.textfield.TextField;
import io.neilshirsat.ui.bingo.BingoSquareState;
import io.neilshirsat.ui.bingo.BingoState;
import io.neilshirsat.util.ShapeType;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;

public class BingoWideCustomizePanel extends JPanel {

    private GroupLayout SquareCustomizePanelLayout;

    private BingoState State;

    private ColorPicker TextColor;

    private ColorPicker BackgroundColor;

    private ColorPicker SelectedColor;

    private String[] SHAPE_OPTIONS = new String[]{
            "Circle",
            "Rectangle",
            "None"
    };

    private Select<String> Shape;

    private ColorPicker BorderColor;

    private NumberField BorderThickness;

    private FileChooser TextFont;

    private NumberField FontSize;

    private String[] FONT_STYLE_OPTIONS = new String[]{
            "Normal",
            "Italic",
            "Bold"
    };

    private Select<String> FontStyle;

    private NumberField PositionX;

    private NumberField PositionY;

    private NumberField MaxHeight;

    private NumberField MaxWidth;

    String[] TRUE_FALSE_OPTIONS = new String[] {"true", "false"};

    public BingoWideCustomizePanel( BingoState State ) {
        super();
        this.State = State;

        SquareCustomizePanelLayout = new GroupLayout(this);
        super.setLayout(SquareCustomizePanelLayout);

        TextColor = new ColorPicker(State.getBingoSquares()[0][0].getTextColor(), "Text Color");
        BackgroundColor = new ColorPicker(State.getBingoSquares()[0][0].getBackgroundColor(), "Background Color");
        SelectedColor = new ColorPicker(State.getBingoSquares()[0][0].getSelectedColor(), "Selected Color");

        Shape = new Select<>(SHAPE_OPTIONS);
        Shape.setLabel("Shape");
        if (State.getBingoSquares()[0][0].getShape() == ShapeType.CIRCLE) {
            Shape.getSelectList().setSelectedItem("Circle");
        }
        else if (State.getBingoSquares()[0][0].getShape() == ShapeType.RECTANGLE) {
            Shape.getSelectList().setSelectedItem("Rectangle");
        }

        BorderColor = new ColorPicker(State.getBingoSquares()[0][0].getBorderColor(), "Border Color");
        BorderThickness = new NumberField();
        BorderThickness.setLabelText("Border Thickness");
        BorderThickness.getNumberField().setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        TextFont = new FileChooser("Text Font", JFileChooser.FILES_AND_DIRECTORIES, new FileFilter() {
            @Override
            public boolean accept(File f) {
                String extension = "";
                int i = f.getName().lastIndexOf('.');
                if (i > 0) {
                    extension = f.getName().substring(i+1);
                }
                return extension.equals("ttf") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "True Type Font Files (ttf)";
            }
        });
        FontSize = new NumberField();
        FontSize.setLabelText("Font Size");
        FontSize.getNumberField().setValue(State.getBingoSquares()[0][0].getFontSize());
        FontSize.getNumberField().setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        FontStyle = new Select<>(FONT_STYLE_OPTIONS);
        FontStyle.setLabel("Font Style");
        if (State.getBingoSquares()[0][0].getFontStyle() == 0) {
            FontStyle.getSelectList().setSelectedItem("Normal");
        }
        else if (State.getBingoSquares()[0][0].getFontStyle() == 1) {
            FontStyle.getSelectList().setSelectedItem("Bold");
        }
        else {
            FontStyle.getSelectList().setSelectedItem("Italic");
        }

        PositionX = new NumberField();
        PositionX.setLabelText("Position X");
        PositionX.getNumberField().setValue(State.getBingoSquares()[0][0].getPositionX());
        PositionX.getNumberField().setModel(new SpinnerNumberModel(0, 0, 10000, 1));
        PositionY = new NumberField();
        PositionY.setLabelText("Position Y");
        PositionY.getNumberField().setValue(State.getBingoSquares()[0][0].getPositionY());
        PositionY.getNumberField().setModel(new SpinnerNumberModel(0, 0, 10000, 1));
        MaxHeight = new NumberField();
        MaxHeight.setLabelText("Max Height");
        MaxHeight.getNumberField().setValue(State.getBingoSquares()[0][0].getMaxHeight());
        MaxHeight.getNumberField().setModel(new SpinnerNumberModel(0, 0, 10000, 1));
        MaxWidth = new NumberField();
        MaxWidth.setLabelText("Max Width");
        MaxWidth.getNumberField().setValue(State.getBingoSquares()[0][0].getMaxWidth());
        MaxWidth.getNumberField().setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        TextColor.setActionListener(e-> {
            for (BingoSquareState[] i : State.getBingoSquares()) {
                for (BingoSquareState j : i) {
                    j.setTextColor(e.getSelectedColor());
                }
            }
        });
        BackgroundColor.setActionListener(e-> {
            for (BingoSquareState[] i : State.getBingoSquares()) {
                for (BingoSquareState j : i) {
                    j.setBackgroundColor(e.getSelectedColor());
                }
            }
        });
        SelectedColor.setActionListener(e-> {
            for (BingoSquareState[] i : State.getBingoSquares()) {
                for (BingoSquareState j : i) {
                    j.setSelectedColor(e.getSelectedColor());
                }
            }
        });
        Shape.getSelectList().addActionListener(e->{
            assert Shape.getSelectList().getSelectedItem() != null;
            if (Shape.getSelectList().getSelectedItem().equals("Circle")) {
                for (BingoSquareState[] i : State.getBingoSquares()) {
                    for (BingoSquareState j : i) {
                        j.setShape(ShapeType.CIRCLE);
                    }
                }
            }
            else if (Shape.getSelectList().getSelectedItem().equals("Rectangle")) {
                for (BingoSquareState[] i : State.getBingoSquares()) {
                    for (BingoSquareState j : i) {
                        j.setShape(ShapeType.RECTANGLE);
                    }
                }
            }
            else if (Shape.getSelectList().getSelectedItem().equals("None")) {
                for (BingoSquareState[] i : State.getBingoSquares()) {
                    for (BingoSquareState j : i) {
                        j.setShape(ShapeType.NONE);
                    }
                }
            }
        });
        BorderColor.setActionListener(e-> {
            for (BingoSquareState[] i : State.getBingoSquares()) {
                for (BingoSquareState j : i) {
                    j.setBorderColor(e.getSelectedColor());
                }
            }
        });
        BorderThickness.getNumberField().addChangeListener(e->{
            for (BingoSquareState[] i : State.getBingoSquares()) {
                for (BingoSquareState j : i) {
                    j.setBorderThickness((Integer) BorderThickness.getNumberField().getValue());
                }
            }
        });


        TextFont.setActionListener(e->{
            try {
                for (BingoSquareState[] i : State.getBingoSquares()) {
                    for (BingoSquareState j : i) {
                        j.setTextFont(
                                Font.createFont(Font.TRUETYPE_FONT, e.getFile() )
                        );
                    }
                }
            } catch (Exception exp) {
                System.out.println("Font Not Initialized");
            }
        });
        FontSize.getNumberField().addChangeListener(e->{
            for (BingoSquareState[] i : State.getBingoSquares()) {
                for (BingoSquareState j : i) {
                    j.setFontSize((Integer) FontSize.getNumberField().getValue());
                }
            }
        });
        FontStyle.getSelectList().addActionListener(e->{
            assert FontStyle.getSelectList().getSelectedItem() != null;
            if (FontStyle.getSelectList().getSelectedItem().equals("Normal")) {
                for (BingoSquareState[] i : State.getBingoSquares()) {
                    for (BingoSquareState j : i) {
                        j.setFontStyle(0);
                    }
                }
            }
            else if (FontStyle.getSelectList().getSelectedItem().equals("Bold")) {
                for (BingoSquareState[] i : State.getBingoSquares()) {
                    for (BingoSquareState j : i) {
                        j.setFontStyle(1);
                    }
                }
            }
            else if (FontStyle.getSelectList().getSelectedItem().equals("Italic")) {
                for (BingoSquareState[] i : State.getBingoSquares()) {
                    for (BingoSquareState j : i) {
                        j.setFontStyle(2);
                    }
                }
            }
        });


        PositionX.getNumberField().addChangeListener(e->{
            for (BingoSquareState[] i : State.getBingoSquares()) {
                for (BingoSquareState j : i) {
                    j.setPositionX((Integer) PositionX.getNumberField().getValue());
                }
            }
        });
        PositionY.getNumberField().addChangeListener(e->{
            for (BingoSquareState[] i : State.getBingoSquares()) {
                for (BingoSquareState j : i) {
                    j.setPositionY((Integer) PositionY.getNumberField().getValue());
                }
            }
        });
        MaxHeight.getNumberField().addChangeListener(e->{
            for (BingoSquareState[] i : State.getBingoSquares()) {
                for (BingoSquareState j : i) {
                    j.setMaxHeight((Integer) MaxHeight.getNumberField().getValue());
                }
            }
        });
        MaxWidth.getNumberField().addChangeListener(e->{
            for (BingoSquareState[] i : State.getBingoSquares()) {
                for (BingoSquareState j : i) {
                    j.setMaxWidth((Integer) MaxWidth.getNumberField().getValue());
                }
            }
        });

        SquareCustomizePanelLayout.setHorizontalGroup(SquareCustomizePanelLayout.createParallelGroup()
                .addComponent(BackgroundColor)
                .addComponent(TextColor)
                .addComponent(SelectedColor)
                .addComponent(Shape)
                .addComponent(BorderColor)
                .addComponent(BorderThickness)
                .addComponent(TextFont)
                .addComponent(FontSize)
                .addComponent(FontStyle)
                .addComponent(PositionX)
                .addComponent(PositionY)
                .addComponent(MaxHeight)
                .addComponent(MaxWidth)
        );
        SquareCustomizePanelLayout.setVerticalGroup(SquareCustomizePanelLayout.createSequentialGroup()
                .addComponent(BackgroundColor)
                .addComponent(TextColor)
                .addComponent(SelectedColor)
                .addComponent(Shape)
                .addComponent(BorderColor)
                .addComponent(BorderThickness)
                .addComponent(TextFont)
                .addComponent(FontSize)
                .addComponent(FontStyle)
                .addComponent(PositionX)
                .addComponent(PositionY)
                .addComponent(MaxHeight)
                .addComponent(MaxWidth)
        );

    }

}
