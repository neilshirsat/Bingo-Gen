package io.neilshirsat.ui.simulation;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import io.neilshirsat.components.filechooser.FileChooser;
import io.neilshirsat.components.select.Select;
import io.neilshirsat.components.textfield.TextField;
import io.neilshirsat.generation.GenerateJPG;
import io.neilshirsat.generation.GeneratePNG;
import io.neilshirsat.ui.bingo.BingoPanel;
import io.neilshirsat.ui.bingo.BingoSquareState;
import io.neilshirsat.ui.bingo.BingoState;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationExportPanel extends JPanel {

    private GroupLayout SimulationExportLayout;

    private SimulationState State;

    private TextField BingoName;

    private String[] FILES_FORMATS = new String[]{
            "png",
            "jpg",
            "pdf"
    };

    private Select<String> FileFormat;

    private FileChooser OutputLocation;

    private JButton ExportButton;

    private JProgressBar ProgressBar;

    private BingoState BingoState;

    private BingoPanel BingoPanel;

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
        ExportButton.addActionListener(e->{
            assert FileFormat.getSelectList().getSelectedItem() != null;
            switch ((String)FileFormat.getSelectList().getSelectedItem()) {
                case "jpg" -> generateJPG();
                case "png" -> generatePNG();
                case "pdf" -> generatePDF();
            }
        });

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

    public void generateJPG() {
        io.neilshirsat.ui.bingo.BingoState BingoState = this.BingoState.cloneBingoState();
        this.BingoPanel = new BingoPanel(BingoState);
        BingoPanel.setSize( 750, 900 );

        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                BingoState.getBingoSquares()[j][k].setSelected(false);
            }
        }
        for (int i = 0; i < State.getBingoBoardCount(); i++) {
            BingoPanel.getBingoState().setBingoBoardId(i + "");
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    BingoState.getBingoSquares()[j][k].setSquareNumber(State.getBingoBoardNumbers()[i][j][k] + "");
                }
            }
            try {
                GenerateJPG.generateJPG(
                        BingoPanel,
                        BingoName.getTextField().getText() + "-" + i,
                        OutputLocation.getTextField().getText()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void generatePNG() {
        io.neilshirsat.ui.bingo.BingoState BingoState = this.BingoState.cloneBingoState();
        this.BingoPanel = new BingoPanel(BingoState);
        BingoPanel.setSize( 750, 900 );

        ExecutorService Exc = Executors.newCachedThreadPool();

        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                BingoState.getBingoSquares()[j][k].setSelected(false);
            }
        }
        for (int i = 0; i < State.getBingoBoardCount(); i++) {
            int finalI = i;
            Exc.submit(()->{
                BingoPanel.getBingoState().setBingoBoardId(finalI + "");
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        BingoState.getBingoSquares()[j][k].setSquareNumber(State.getBingoBoardNumbers()[finalI][j][k] + "");
                    }
                }
                try {
                    GeneratePNG.generatePNG(
                            BingoPanel,
                            BingoName.getTextField().getText() + "-" + finalI,
                            OutputLocation.getTextField().getText()
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public void generatePDF() {
        io.neilshirsat.ui.bingo.BingoState BingoState = this.BingoState.cloneBingoState();
        this.BingoPanel = new BingoPanel(BingoState);
        BingoPanel.setSize( 750, 900 );

        ExecutorService Exc = Executors.newCachedThreadPool();
        File file = new File(OutputLocation.getTextField().getText() + "\\" + BingoName.getTextField().getText() + ".pdf");
        PdfWriter Writer = null;
        try {
             Writer = new PdfWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert Writer != null;
        PdfDocument PDFDocument = new PdfDocument(Writer);
        PDFDocument.addNewPage();
        Document document = new Document(PDFDocument);

        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                BingoState.getBingoSquares()[j][k].setSelected(false);
            }
        }
        for (int i = 0; i < State.getBingoBoardCount(); i++) {
            int finalI = i;
            Exc.submit(()->{
                BingoPanel.getBingoState().setBingoBoardId(finalI + "");
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        BingoState.getBingoSquares()[j][k].setSquareNumber(State.getBingoBoardNumbers()[finalI][j][k] + "");
                    }
                }
                BingoPanel.doLayout();
                BingoPanel.validate();
                BufferedImage image = new BufferedImage(
                        BingoPanel.getWidth(),
                        BingoPanel.getHeight(),
                        BufferedImage.TYPE_INT_ARGB
                );
                Graphics2D g2d = image.createGraphics();
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                BingoPanel.printAll( g2d );
                g2d.dispose();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                System.out.println(baos);
                try {
                    ImageIO.write(image, "png", baos);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Image BingoImage = new Image(ImageDataFactory.create(baos.toByteArray()));
                System.out.println(BingoImage);
                document.add(BingoImage);
                //PDFDocument.addNewPage();

            });
        }

        document.close();
        System.out.println(document);
        try {
            Writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
