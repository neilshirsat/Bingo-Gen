package io.neilshirsat.ui.simulation;

import io.neilshirsat.components.filechooser.FileChooser;
import io.neilshirsat.components.select.Select;
import io.neilshirsat.components.textfield.TextField;
import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import java.io.File;

public class SimulationExportPanel extends JPanel {

    private GroupLayout SimulationExportLayout;

    private SimulationState State;

    private TextField BingoName;

    private String[] FILES_FORMATS = new String[]{
            "png",
            "jpg"
    };

    private Select<String> FileFormat;

    private FileChooser OutputLocation;

    private JButton ExportButton;

    private JProgressBar ProgressBar;

    private BingoState BingoState;

    public SimulationExportPanel(SimulationState State, BingoState BingoState) {
        super();

        this.State = State;
        this.BingoState = BingoState;

        SimulationExportLayout = new GroupLayout(this);
        super.setLayout(SimulationExportLayout);
        super.setBorder(new EmptyBorder(20, 20, 20, 20));

        BingoName = new TextField();
        BingoName.setLabelText("Bingo Name: ");
        BingoName.setInputColumns(40);

        FileFormat = new Select<>(FILES_FORMATS);
        FileFormat.setLabel("File Format: ");

        OutputLocation = new FileChooser("Output Location", JFileChooser.FILES_AND_DIRECTORIES, new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Folders";
            }
        });

        ExportButton = new JButton("Export");

        ProgressBar = new JProgressBar();
        ProgressBar.setVisible(false);

        SimulationExportLayout.setHorizontalGroup(SimulationExportLayout.createParallelGroup()
                .addComponent(BingoName)
                .addComponent(FileFormat)
                .addComponent(OutputLocation)
                .addComponent(ExportButton)
                .addComponent(ProgressBar)
        );
        SimulationExportLayout.setVerticalGroup(SimulationExportLayout.createSequentialGroup()
                .addComponent(BingoName)
                .addComponent(FileFormat)
                .addComponent(OutputLocation)
                .addComponent(ExportButton)
                .addComponent(ProgressBar)
        );

    }
}
