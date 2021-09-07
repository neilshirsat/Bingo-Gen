package io.neilshirsat.mainview;

import com.sun.tools.javac.Main;
import io.neilshirsat.bingoboard.BingoPreviewWindow;
import io.neilshirsat.components.ColorAction;
import io.neilshirsat.components.ColorPicker;
import io.neilshirsat.components.FolderChooser;
import io.neilshirsat.components.TextField;
import io.neilshirsat.generation.GenerateJPG;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JPanel {

    private GroupLayout layout;

    private boolean PreviewOpen;

    private BingoPreviewWindow PreviewWindow;

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
        BingoName.label.setText("Bingo Name:");
        BingoName.textField.setColumns(50);
        BingoName.setPreferredSize(new Dimension(50, 20));

        BackgroundColor = new ColorPicker("Background Color", new Color(0, 174, 255));
        BackgroundColor.setActionListener(new ColorAction() {
            @Override
            public void actionPerformed(Color event) {
                System.out.println("Background Color Chosen" + event);
                MainView.this.PreviewWindow.setPreviewBackground(event);
            }
        });

        TextColor = new ColorPicker("Text Color", Color.WHITE);
        TextColor.setActionListener(new ColorAction() {
            @Override
            public void actionPerformed(Color event) {
                MainView.this.PreviewWindow.setPreviewTextColor(event);
            }
        });

        TitleColor = new ColorPicker("Title Color", Color.BLUE);
        TitleColor.setActionListener(new ColorAction() {
            @Override
            public void actionPerformed(Color event) {
                MainView.this.PreviewWindow.setPreviewTitleTextColor(event);
            }
        });

        TitleBackgroundColor = new ColorPicker("Title Background Color", Color.GREEN);
        TitleBackgroundColor.setActionListener(new ColorAction() {
            @Override
            public void actionPerformed(Color event) {
                MainView.this.PreviewWindow.setPreviewTitleBackgroundColor(event);
            }
        });

        BorderColor = new ColorPicker("Border Color", Color.BLACK);
        BorderColor.setActionListener(new ColorAction() {
            @Override
            public void actionPerformed(Color event) {
                MainView.this.PreviewWindow.setPreviewBorderColor(event);
            }
        });

        OutputFolder = new FolderChooser("Output Folder: ");

        PreviewButton = new JButton("Preview");
        PreviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreviewWindow.setVisible(!PreviewWindow.isVisible());
                PreviewButton.setText(
                        PreviewWindow.isVisible() ? "Close Preview" : "Preview");
            }
        });

        PreviewWindow = new BingoPreviewWindow(
                BackgroundColor.getColor(),
                TextColor.getColor(),
                TitleColor.getColor(),
                TitleBackgroundColor.getColor()
        );

        Export = new ExportPanel();

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

}
