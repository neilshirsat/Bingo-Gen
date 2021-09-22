package io.neilshirsat.ui.simulation;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import io.neilshirsat.components.filechooser.FileChooser;
import io.neilshirsat.components.select.Select;
import io.neilshirsat.components.textfield.TextField;
import io.neilshirsat.generation.GenerateJPG;
import io.neilshirsat.generation.GeneratePNG;
import io.neilshirsat.ui.bingo.BingoPanel;
import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExportBallRollsPanel extends JPanel {

    private GroupLayout ExportBallRollsPanelLayout;

    private SimulationState State;

    private TextField BingoName;

    private FileChooser OutputLocation;

    private JButton ExportButton;

    private JProgressBar ProgressBar;

    private io.neilshirsat.ui.bingo.BingoState BingoState;

    private io.neilshirsat.ui.bingo.BingoPanel BingoPanel;

    private String[] DAYS_TABLE = new String[]{
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
    };

    private String[] PERIOD_TABLE = new String[]{
            "AM",
            "PM",
    };

    public ExportBallRollsPanel(SimulationState State) {
        super();

        this.State = State;

        ExportBallRollsPanelLayout = new GroupLayout(this);
        super.setLayout(ExportBallRollsPanelLayout);
        super.setBorder(new EmptyBorder(20, 20, 20, 20));

        BingoName = new TextField();
        BingoName.setLabelText("File Name: ");
        BingoName.setInputColumns(40);

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
        ExportButton.addActionListener(e->{
            generateTable();
        });

        ProgressBar = new JProgressBar();
        ProgressBar.setVisible(false);

        ExportBallRollsPanelLayout.setHorizontalGroup(ExportBallRollsPanelLayout.createParallelGroup()
                .addComponent(BingoName)
                .addComponent(OutputLocation)
                .addComponent(ExportButton)
                .addComponent(ProgressBar)
        );
        ExportBallRollsPanelLayout.setVerticalGroup(ExportBallRollsPanelLayout.createSequentialGroup()
                .addComponent(BingoName)
                .addComponent(OutputLocation)
                .addComponent(ExportButton)
                .addComponent(ProgressBar)
        );

    }

    public void generateTable() {
        File file = new File(OutputLocation.getTextField().getText() + "\\" + BingoName.getTextField().getText() + ".txt");
        PrintWriter Writer = null;
        try {
            Writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "The File Was Not Found, Check the Output Folder Path", "File Not Found",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        int[][] table = new int[2][State.getDayCount()];
        int remainder = State.getRolledBalls().size() % (State.getDayCount() * 2);
        for (int i = 0; i < State.getDayCount(); i++) {
            for (int  j = 0; j < 2; j++) {
                table[j][i] = State.getRolledBalls().size() / (State.getDayCount() * 2);
                if (remainder > 0) {
                    table[j][i] += 1;
                }
                remainder--;
            }
        }

        Writer.print("Day \t|\t");
        Writer.print("Round \t|\t");
        Writer.print("Rolled Ball");
        Writer.println();
        Writer.println();

        int Count = 0;
        for (int i = 0; i < State.getDayCount(); i++) {
            for (int  j = 0; j < 2; j++) {
                //System.out.println(table[j][i]);
                for (int k = 0; k < table[j][i]; k++) {
                    Writer.print(DAYS_TABLE[i] + "\t|\t");
                    Writer.print(PERIOD_TABLE[i] + "\t|\t");
                    Writer.print(State.getRolledBalls().get(Count));
                    Writer.println();
                    Count++;
                }
                remainder--;
            }
        }

        Writer.close();

        JOptionPane.showMessageDialog(
                null,
                "The Generated Files Have Been Exported",
                "Files Exports",
                JOptionPane.INFORMATION_MESSAGE
        );

    }

}
