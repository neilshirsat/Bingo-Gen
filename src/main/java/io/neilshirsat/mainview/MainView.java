package io.neilshirsat.mainview;

import com.sun.tools.javac.Main;
import io.neilshirsat.bingoboard.BingoPreviewWindow;
import io.neilshirsat.components.ColorAction;
import io.neilshirsat.components.ColorPicker;
import io.neilshirsat.components.FolderChooser;
import io.neilshirsat.components.TextField;
import io.neilshirsat.generation.GenerateJPG;
import io.neilshirsat.ui.bingo.BingoPreview;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JPanel {

    private GroupLayout layout;

    private boolean PreviewOpen;

    private BingoPreview PreviewWindow;

    private TextField BingoName;

    private ColorPicker BackgroundColor;

    private ColorPicker TextColor;

    private ColorPicker TitleColor;

    private ColorPicker TitleBackgroundColor;

    private ColorPicker BorderColor;

    private FolderChooser OutputFolder;

    private JButton PreviewButton;

    private ExportPanel Export;

    private JButton PrintButton;

    public MainView() {
        super();

        layout = new GroupLayout(this);
        super.setLayout(layout);

        super.setBorder(new EmptyBorder(20, 20, 20, 20));

        BingoName = new TextField();
        BingoName.setLabelText("Bingo Name:");
        BingoName.setInputColumns(50);
        BingoName.setPreferredSize(new Dimension(50, 20));

        BackgroundColor = new ColorPicker("Background Color", new Color(0, 174, 255));

        TextColor = new ColorPicker("Text Color", Color.WHITE);

        TitleColor = new ColorPicker("Title Color", Color.BLUE);

        TitleBackgroundColor = new ColorPicker("Title Background Color", Color.GREEN);
        BorderColor = new ColorPicker("Border Color", Color.BLACK);

        OutputFolder = new FolderChooser("Output Folder: ");

        PreviewButton = new JButton("Preview");
        PreviewButton.addActionListener(e -> {
            PreviewWindow.setVisible(!PreviewWindow.isVisible());
            PreviewButton.setText(
                    PreviewWindow.isVisible() ? "Close Preview" : "Preview");
        });

        PreviewWindow = new BingoPreview();

        Export = new ExportPanel(this);

        PrintButton = new JButton("Print");

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(BingoName)
                .addComponent(BackgroundColor.getUI())
                .addComponent(TextColor.getUI())
                .addComponent(TitleColor.getUI())
                .addComponent(TitleBackgroundColor.getUI())
                .addComponent(BorderColor.getUI())
                .addComponent(OutputFolder)
                .addComponent(PreviewButton)
                .addGroup(
                        layout.createSequentialGroup()
                                .addComponent(PrintButton)
                                .addGap(15)
                                .addComponent(Export.getUI())
                                .addGap(15)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(BingoName)
                .addComponent(BackgroundColor.getUI())
                .addComponent(TextColor.getUI())
                .addComponent(TitleColor.getUI())
                .addComponent(TitleBackgroundColor.getUI())
                .addComponent(BorderColor.getUI())
                .addComponent(OutputFolder)
                .addGap(15)
                .addComponent(PreviewButton)
                .addGap(15)
                .addGroup(
                        layout.createParallelGroup()
                                .addComponent(PrintButton)
                                .addComponent(Export.getUI())
                )

        );

        updateUI();
    }

    @Override
    public GroupLayout getLayout() {
        return layout;
    }

    public void setLayout(GroupLayout layout) {
        this.layout = layout;
    }

    public boolean isPreviewOpen() {
        return PreviewOpen;
    }

    public void setPreviewOpen(boolean previewOpen) {
        PreviewOpen = previewOpen;
    }

    public BingoPreview getPreviewWindow() {
        return PreviewWindow;
    }

    public void setPreviewWindow(BingoPreview previewWindow) {
        PreviewWindow = previewWindow;
    }

    public TextField getBingoName() {
        return BingoName;
    }

    public void setBingoName(TextField bingoName) {
        BingoName = bingoName;
    }

    public ColorPicker getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(ColorPicker backgroundColor) {
        BackgroundColor = backgroundColor;
    }

    public ColorPicker getTextColor() {
        return TextColor;
    }

    public void setTextColor(ColorPicker textColor) {
        TextColor = textColor;
    }

    public ColorPicker getTitleColor() {
        return TitleColor;
    }

    public void setTitleColor(ColorPicker titleColor) {
        TitleColor = titleColor;
    }

    public ColorPicker getTitleBackgroundColor() {
        return TitleBackgroundColor;
    }

    public void setTitleBackgroundColor(ColorPicker titleBackgroundColor) {
        TitleBackgroundColor = titleBackgroundColor;
    }

    public ColorPicker getBorderColor() {
        return BorderColor;
    }

    public void setBorderColor(ColorPicker borderColor) {
        BorderColor = borderColor;
    }

    public FolderChooser getOutputFolder() {
        return OutputFolder;
    }

    public void setOutputFolder(FolderChooser outputFolder) {
        OutputFolder = outputFolder;
    }

    public JButton getPreviewButton() {
        return PreviewButton;
    }

    public void setPreviewButton(JButton previewButton) {
        PreviewButton = previewButton;
    }

    public ExportPanel getExport() {
        return Export;
    }

    public void setExport(ExportPanel export) {
        Export = export;
    }

    public JButton getPrintButton() {
        return PrintButton;
    }

    public void setPrintButton(JButton printButton) {
        PrintButton = printButton;
    }

}
