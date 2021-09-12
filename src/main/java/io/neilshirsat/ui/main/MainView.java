package io.neilshirsat.ui.main;

import io.neilshirsat.ui.bingo.BingoPreview;
import io.neilshirsat.ui.customize.CustomizeWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainView extends JPanel {

    private GroupLayout MainViewLayout;

    private boolean PreviewOpen;

    private BingoPreview PreviewWindow;

    private JButton PreviewButton;

    private JButton CustomizeButton;

    private CustomizeWindow CustomizeWindow;

    private JButton PrintButton;

    public MainView() {
        super();

        MainViewLayout = new GroupLayout(this);
        super.setLayout(MainViewLayout);
        super.setBorder(new EmptyBorder(20, 20, 20, 20));

        PreviewButton = new JButton("Preview");

        PreviewWindow = new BingoPreview();

        PreviewButton.addActionListener(e -> {
            PreviewWindow.setVisible(!PreviewWindow.isVisible());
            PreviewButton.setText(
                    PreviewWindow.isVisible() ? "Close Preview" : "Preview");
        });
        PreviewWindow.setWindowCloseListener(() -> {
            PreviewWindow.setVisible(!PreviewWindow.isVisible());
            PreviewButton.setText(
                    PreviewWindow.isVisible() ? "Close Preview" : "Preview");
        });

        CustomizeWindow = new CustomizeWindow(PreviewWindow.getBingoState());
        CustomizeButton = new JButton("Customize Bingo");
        CustomizeButton.addActionListener(e -> MainView.this.CustomizeWindow.setVisible(true));

        PrintButton = new JButton("Print");

        MainViewLayout.setHorizontalGroup(MainViewLayout.createParallelGroup()
                .addComponent(CustomizeButton)
                .addComponent(PreviewButton)
                .addGroup(
                        MainViewLayout.createSequentialGroup()
                                .addComponent(PrintButton)
                                .addGap(15)
                )
        );
        MainViewLayout.setVerticalGroup(MainViewLayout.createSequentialGroup()
                .addComponent(CustomizeButton)
                .addGap(15)
                .addComponent(PreviewButton)
                .addGap(15)
                .addGroup(
                        MainViewLayout.createParallelGroup()
                                .addComponent(PrintButton)
                )

        );

    }

}
