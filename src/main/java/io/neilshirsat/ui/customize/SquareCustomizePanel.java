package io.neilshirsat.ui.customize;

import io.neilshirsat.components.colorpicker.ColorPicker;
import io.neilshirsat.components.filechooser.FileChooser;
import io.neilshirsat.components.numberfield.NumberField;
import io.neilshirsat.components.select.Select;
import io.neilshirsat.util.ShapeType;
import io.neilshirsat.ui.bingo.BingoSquareState;
import io.neilshirsat.components.textfield.TextField;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;

public class SquareCustomizePanel extends JPanel {

    private GroupLayout SquareCustomizePanelLayout;

    private BingoSquareState State;

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

    private Select<String> IsFreeSpace;

    private TextField FreeSpaceText;

    private Select<String> IsTitle;

    private TextField TitleText;

    public SquareCustomizePanel( BingoSquareState State ) {
        super();
        this.State = State;

        SquareCustomizePanelLayout = new GroupLayout(this);
        super.setLayout(SquareCustomizePanelLayout);

        TextColor = new ColorPicker(State.getTextColor(), "Text Color");
        BackgroundColor = new ColorPicker(State.getBackgroundColor(), "Background Color");
        SelectedColor = new ColorPicker(State.getSelectedColor(), "Selected Color");

        Shape = new Select<>(SHAPE_OPTIONS);
        Shape.setLabel("Shape");
        if (State.getShape() == ShapeType.CIRCLE) {
            Shape.getSelectList().setSelectedItem("Circle");
        }
        else if (State.getShape() == ShapeType.RECTANGLE) {
            Shape.getSelectList().setSelectedItem("Rectangle");
        }

        BorderColor = new ColorPicker(State.getBorderColor(), "Border Color");
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
        FontSize.getNumberField().setValue(State.getFontSize());
        FontSize.getNumberField().setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        FontStyle = new Select<>(FONT_STYLE_OPTIONS);
        FontStyle.setLabel("Font Style");
        if (State.getFontStyle() == 0) {
            FontStyle.getSelectList().setSelectedItem("Normal");
        }
        else if (State.getFontStyle() == 1) {
            FontStyle.getSelectList().setSelectedItem("Bold");
        }
        else {
            FontStyle.getSelectList().setSelectedItem("Italic");
        }

        PositionX = new NumberField();
        PositionX.setLabelText("Position X");
        PositionX.getNumberField().setValue(State.getPositionX());
        PositionX.getNumberField().setModel(new SpinnerNumberModel(0, 0, 10000, 1));
        PositionY = new NumberField();
        PositionY.setLabelText("Position Y");
        PositionY.getNumberField().setValue(State.getPositionY());
        PositionY.getNumberField().setModel(new SpinnerNumberModel(0, 0, 10000, 1));
        MaxHeight = new NumberField();
        MaxHeight.setLabelText("Max Height");
        MaxHeight.getNumberField().setValue(State.getMaxHeight());
        MaxHeight.getNumberField().setModel(new SpinnerNumberModel(0, 0, 10000, 1));
        MaxWidth = new NumberField();
        MaxWidth.setLabelText("Max Width");
        MaxWidth.getNumberField().setValue(State.getMaxWidth());
        MaxWidth.getNumberField().setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        IsFreeSpace = new Select<>(TRUE_FALSE_OPTIONS);
        IsFreeSpace.getSelectList().setSelectedItem(State.isFreeSpace() ? "true" : "false");
        IsFreeSpace.setLabel("Is Free Space");
        FreeSpaceText = new TextField();
        FreeSpaceText.setLabelText("Free Space Text");
        FreeSpaceText.setInputColumns(40);

        TextColor.setActionListener(e-> State.setTextColor(e.getSelectedColor()));
        BackgroundColor.setActionListener(e-> State.setBackgroundColor(e.getSelectedColor()));
        SelectedColor.setActionListener(e-> State.setSelectedColor(e.getSelectedColor()));
        Shape.getSelectList().addActionListener(e->{
            assert Shape.getSelectList().getSelectedItem() != null;
            if (Shape.getSelectList().getSelectedItem().equals("Circle")) {
                State.setShape(ShapeType.CIRCLE);
            }
            else if (Shape.getSelectList().getSelectedItem().equals("Rectangle")) {
                State.setShape(ShapeType.RECTANGLE);
            }
            else if (Shape.getSelectList().getSelectedItem().equals("None")) {
                State.setShape(ShapeType.NONE);
            }
        });
        BorderColor.setActionListener(e-> State.setBorderColor(e.getSelectedColor()));
        BorderThickness.getNumberField().addChangeListener(e->
                State.setBorderThickness((Integer) BorderThickness.getNumberField().getValue()));


        TextFont.setActionListener(e->{
            try {
                State.setTextFont(
                        Font.createFont(Font.TRUETYPE_FONT, e.getFile() )
                );
            } catch (Exception exp) {
                System.out.println("Font Not Initialized");
            }
        });
        FontSize.getNumberField().addChangeListener(e->
                State.setFontSize((int) FontSize.getNumberField().getValue()));
        FontStyle.getSelectList().addActionListener(e->{
            assert FontStyle.getSelectList().getSelectedItem() != null;
            if (FontStyle.getSelectList().getSelectedItem().equals("Normal")) {
                State.setFontStyle(0);
            }
            else if (FontStyle.getSelectList().getSelectedItem().equals("Bold")) {
                State.setFontStyle(1);
            }
            else if (FontStyle.getSelectList().getSelectedItem().equals("Italic")) {
                State.setFontStyle(2);
            }
        });


        PositionX.getNumberField().addChangeListener(e->
                State.setPositionX((Integer) PositionX.getNumberField().getValue()));
        PositionY.getNumberField().addChangeListener(e->
                State.setPositionX((Integer) PositionX.getNumberField().getValue()));
        MaxHeight.getNumberField().addChangeListener(e->
                State.setPositionX((Integer) PositionX.getNumberField().getValue()));
        MaxWidth.getNumberField().addChangeListener(e->
                State.setPositionX((Integer) PositionX.getNumberField().getValue()));


        IsFreeSpace.getSelectList().addActionListener(e->{
            assert IsFreeSpace.getSelectList().getSelectedItem() != null;
            if (IsFreeSpace.getSelectList().getSelectedItem().equals("true")){
                State.setFreeSpace(true);
            }
            else if (IsFreeSpace.getSelectList().getSelectedItem().equals("false"))
                State.setFreeSpace(false);
        });
        FreeSpaceText.getTextField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                State.setFreeSpaceText(FreeSpaceText.getTextField().getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                State.setFreeSpaceText(FreeSpaceText.getTextField().getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                State.setFreeSpaceText(FreeSpaceText.getTextField().getText());
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
                .addComponent(IsFreeSpace)
                .addComponent(FreeSpaceText)
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
                .addComponent(IsFreeSpace)
                .addComponent(FreeSpaceText)
        );

    }

}
