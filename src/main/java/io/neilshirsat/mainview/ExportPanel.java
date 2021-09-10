package io.neilshirsat.mainview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import io.neilshirsat.bingoboard.BingoPreviewWindow;
import io.neilshirsat.components.Select;
import io.neilshirsat.components.TextField;
import io.neilshirsat.generation.GenerateJPG;

public class ExportPanel extends JFrame {

    private JButton NonFrameExportButton;

    private JPanel RootPanel;

    private JPanel OptionsPanel;

    private JButton ExportButton;

    private JButton CloseButton;

    private final String[] SUPPORTED_FILE_FORMAT_EXPORTS = new String[]{
            "jpg",
            "png",
            "svg",
            "pdf",
    };

    private Select<String> FileFormat;

    private MainView MainViewLogic;

    public ExportPanel(MainView MainViewLogic) {
        super();

        this.MainViewLogic = MainViewLogic;

        JMenuBar menuBar = new JMenuBar();
        JMenu File = new JMenu("File");

        //super.setUndecorated(true);
        super.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        super.setResizable(false);
        super.setTitle("Export Bingo Project");
        super.setJMenuBar( menuBar );
        super.setSize(
                800,
                800
        );

        NonFrameExportButton = new JButton("Export");
        NonFrameExportButton.addActionListener(e -> ExportPanel.super.setVisible(true));

        RootPanel = new JPanel();
        RootPanel.setLayout(new BorderLayout());

        OptionsPanel = new JPanel();
        GroupLayout layout = new GroupLayout(OptionsPanel);
        OptionsPanel.setLayout(layout);

        TextField Name = new TextField();
        Name.setLabelText("Name");
        Name.setInputColumns(25);

        FileFormat = new Select<>(SUPPORTED_FILE_FORMAT_EXPORTS);
        FileFormat.setEditable(true);
        FileFormat.setLabel("File Format");

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(Name)
                .addComponent(FileFormat)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(Name)
                .addComponent(FileFormat)
        );

        ExportButton = new JButton("Export");
        CloseButton = new JButton("Close");

        ExportButton.addActionListener(e -> {
            assert FileFormat.getSelectList().getSelectedItem() != null;
            if (FileFormat.getSelectList().getSelectedItem().equals("jpg")) {
                GenerateJPG.generateJPG(
                        ExportPanel.this.MainViewLogic.getPreviewWindow(),
                        ExportPanel.this.MainViewLogic.getBingoName().getTextField().getText(),
                        ExportPanel.this.MainViewLogic.getOutputFolder().getTextField().getText());
            }
        });

        JRootPane Root = SwingUtilities.getRootPane(this);
        Root.setDefaultButton(ExportButton);

        JPanel ActionPane = new JPanel();
        ActionPane.add( ExportButton);
        ActionPane.add( CloseButton );

        RootPanel.add( OptionsPanel, BorderLayout.NORTH );
        RootPanel.add( ActionPane );

        super.add( RootPanel );
        super.pack();

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

    }

    public JComponent getUI() {
        return NonFrameExportButton;
    }

}
