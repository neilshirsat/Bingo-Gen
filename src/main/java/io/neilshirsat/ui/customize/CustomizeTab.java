package io.neilshirsat.ui.customize;

import io.neilshirsat.components.select.Select;
import io.neilshirsat.ui.bingo.BingoState;
import io.neilshirsat.ui.main.MainView;
import io.neilshirsat.util.ShapeType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class CustomizeTab extends JPanel {

    private ArrayList<String> SetBingoStylesList;

    private Select<String> SetBingoStyle;

    private BingoState State;

    private JButton CustomizeButton;

    private JButton BingoWideCustomizeButton;

    private BingoWideCustomizeWindow BingoWideCustomizeWindow;

    private JButton BingoTitleCustomizeButton;

    private BingoTitleCustomizeWindow BingoTitleCustomizeWindow;

    private CustomizeWindow CustomizeWindow;

    private GroupLayout CustomizeTabLayout;

    public CustomizeTab(BingoState State) {
        super();
        this.State = State;

        this.CustomizeTabLayout = new GroupLayout(this);
        this.setLayout(CustomizeTabLayout);
        super.setBorder(new EmptyBorder(20,20,20,20));

        SetBingoStylesList = new ArrayList<>();
        SetBingoStylesList.add("Light");
        SetBingoStylesList.add("Dark");
        SetBingoStylesList.add("Dark Squares");
        SetBingoStylesList.add("Black & Red");
        SetBingoStylesList.add("Ocean");
        SetBingoStylesList.add("Ocean Circles");
        SetBingoStylesList.add("Custom");
        SetBingoStyle = new Select<>(setStringArray(SetBingoStylesList));
        SetBingoStyle.setLabel("Bingo Theme: ");
        SetBingoStyle.getSelectList().addActionListener(e->{
            String value = (String) SetBingoStyle.getSelectList().getSelectedItem();

            assert value != null;
            switch (value) {
                case "Light" -> {
                    State.setBaseBackgroundColor(Color.WHITE);
                    for (int i = 0; i < 5; i++) {
                        State.getTitleSquares()[i].setTextColor(Color.BLACK);
                        State.getTitleSquares()[i].setBorderColor(Color.BLACK);
                        State.getTitleSquares()[i].setBackgroundColor(Color.WHITE);
                        State.getTitleSquares()[i].setBorderThickness(2);
                        State.getTitleSquares()[i].setShape(ShapeType.CIRCLE);
                    }
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            State.getBingoSquares()[i][j].setTextColor(Color.BLACK);
                            State.getBingoSquares()[i][j].setBorderColor(Color.BLACK);
                            State.getBingoSquares()[i][j].setBackgroundColor(Color.WHITE);
                            State.getBingoSquares()[i][j].setBorderThickness(2);
                            State.getBingoSquares()[i][j].setShape(ShapeType.RECTANGLE);
                            State.getBingoSquares()[i][j].setSelectedColor(Color.BLUE);
                        }
                    }
                }
                case "Dark" -> {
                    State.setBaseBackgroundColor(Color.BLACK);
                    for (int i = 0; i < 5; i++) {
                        State.getTitleSquares()[i].setTextColor(Color.YELLOW);
                        State.getTitleSquares()[i].setBorderColor(Color.WHITE);
                        State.getTitleSquares()[i].setBackgroundColor(Color.BLACK);
                        State.getTitleSquares()[i].setBorderThickness(2);
                        State.getTitleSquares()[i].setShape(ShapeType.CIRCLE);
                    }
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            State.getBingoSquares()[i][j].setTextColor(Color.YELLOW);
                            State.getBingoSquares()[i][j].setBorderColor(Color.WHITE);
                            State.getBingoSquares()[i][j].setBackgroundColor(Color.BLACK);
                            State.getBingoSquares()[i][j].setBorderThickness(2);
                            State.getBingoSquares()[i][j].setShape(ShapeType.RECTANGLE);
                            State.getBingoSquares()[i][j].setSelectedColor(Color.BLUE);
                        }
                    }
                }
                case "Dark Squares" -> {
                    State.setBaseBackgroundColor(Color.BLACK);
                    for (int i = 0; i < 5; i++) {
                        State.getTitleSquares()[i].setTextColor(Color.YELLOW);
                        State.getTitleSquares()[i].setBorderColor(Color.WHITE);
                        State.getTitleSquares()[i].setBackgroundColor(Color.BLACK);
                        State.getTitleSquares()[i].setBorderThickness(2);
                        State.getTitleSquares()[i].setShape(ShapeType.RECTANGLE);
                    }
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            State.getBingoSquares()[i][j].setTextColor(Color.YELLOW);
                            State.getBingoSquares()[i][j].setBorderColor(Color.WHITE);
                            State.getBingoSquares()[i][j].setBackgroundColor(Color.BLACK);
                            State.getBingoSquares()[i][j].setBorderThickness(2);
                            State.getBingoSquares()[i][j].setShape(ShapeType.RECTANGLE);
                            State.getBingoSquares()[i][j].setSelectedColor(Color.BLUE);
                        }
                    }
                }
                case "Black & Red" -> {
                    State.setBaseBackgroundColor(Color.BLACK);
                    for (int i = 0; i < 5; i++) {
                        State.getTitleSquares()[i].setTextColor(Color.RED);
                        State.getTitleSquares()[i].setBorderColor(Color.RED);
                        State.getTitleSquares()[i].setBackgroundColor(Color.BLACK);
                        State.getTitleSquares()[i].setBorderThickness(2);
                        State.getTitleSquares()[i].setShape(ShapeType.CIRCLE);
                    }
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            State.getBingoSquares()[i][j].setTextColor(Color.RED);
                            State.getBingoSquares()[i][j].setBorderColor(Color.RED);
                            State.getBingoSquares()[i][j].setBackgroundColor(Color.BLACK);
                            State.getBingoSquares()[i][j].setBorderThickness(2);
                            State.getBingoSquares()[i][j].setShape(ShapeType.RECTANGLE);
                            State.getBingoSquares()[i][j].setSelectedColor(Color.BLUE);
                        }
                    }
                }
                case "Ocean" -> {
                    State.setBaseBackgroundColor(new Color(0, 174, 255));
                    for (int i = 0; i < 5; i++) {
                        State.getTitleSquares()[i].setTextColor(Color.BLACK);
                        State.getTitleSquares()[i].setBorderColor(Color.BLACK);
                        State.getTitleSquares()[i].setBackgroundColor(new Color(0, 174, 255));
                        State.getTitleSquares()[i].setBorderThickness(2);
                        State.getTitleSquares()[i].setShape(ShapeType.CIRCLE);
                    }
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            State.getBingoSquares()[i][j].setTextColor(Color.BLACK);
                            State.getBingoSquares()[i][j].setBorderColor(Color.BLACK);
                            State.getBingoSquares()[i][j].setBackgroundColor(new Color(0, 174, 255));
                            State.getBingoSquares()[i][j].setBorderThickness(2);
                            State.getBingoSquares()[i][j].setShape(ShapeType.RECTANGLE);
                            State.getBingoSquares()[i][j].setSelectedColor(Color.GREEN);
                        }
                    }
                }
                case "Ocean Circles" -> {
                    State.setBaseBackgroundColor(new Color(0, 174, 255));
                    for (int i = 0; i < 5; i++) {
                        State.getTitleSquares()[i].setTextColor(Color.BLACK);
                        State.getTitleSquares()[i].setBorderColor(Color.BLACK);
                        State.getTitleSquares()[i].setBackgroundColor(new Color(0, 174, 255));
                        State.getTitleSquares()[i].setBorderThickness(2);
                        State.getTitleSquares()[i].setShape(ShapeType.RECTANGLE);
                    }
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            State.getBingoSquares()[i][j].setTextColor(Color.BLACK);
                            State.getBingoSquares()[i][j].setBorderColor(Color.BLACK);
                            State.getBingoSquares()[i][j].setBackgroundColor(new Color(0, 174, 255));
                            State.getBingoSquares()[i][j].setBorderThickness(2);
                            State.getBingoSquares()[i][j].setShape(ShapeType.CIRCLE);
                            State.getBingoSquares()[i][j].setSelectedColor(Color.GREEN);
                        }
                    }
                }
            }

        });

        CustomizeWindow = new CustomizeWindow(State);
        CustomizeButton = new JButton("Customize Individual Bingo Square Styling");
        CustomizeButton.addActionListener(e -> {
            CustomizeTab.this.CustomizeWindow.setVisible(true);
            SwingUtilities.updateComponentTreeUI(SwingUtilities.getRoot(CustomizeWindow));
            SetBingoStyle.getSelectList().setSelectedItem("Custom");
        });

        BingoWideCustomizeWindow = new BingoWideCustomizeWindow(State);
        BingoWideCustomizeButton = new JButton("Customize Bingo Wide Styling");
        BingoWideCustomizeButton.addActionListener(e -> {
            CustomizeTab.this.BingoWideCustomizeWindow.setVisible(true);
            SwingUtilities.updateComponentTreeUI(SwingUtilities.getRoot(BingoWideCustomizeWindow));
            SetBingoStyle.getSelectList().setSelectedItem("Custom");
        });

        BingoTitleCustomizeWindow = new BingoTitleCustomizeWindow(State);
        BingoTitleCustomizeButton = new JButton("Customize Bingo Title Styling");
        BingoTitleCustomizeButton.addActionListener(e -> {
            CustomizeTab.this.BingoTitleCustomizeWindow.setVisible(true);
            SwingUtilities.updateComponentTreeUI(SwingUtilities.getRoot(BingoTitleCustomizeWindow));
            SetBingoStyle.getSelectList().setSelectedItem("Custom");
        });

        CustomizeTabLayout.setHorizontalGroup(CustomizeTabLayout.createParallelGroup()
                .addComponent(SetBingoStyle)
                .addGap(20)
                .addComponent(BingoTitleCustomizeButton)
                .addGap(20)
                .addComponent(BingoWideCustomizeButton)
                .addGap(20)
                .addComponent(CustomizeButton)
        );
        CustomizeTabLayout.setVerticalGroup(CustomizeTabLayout.createSequentialGroup()
                .addComponent(SetBingoStyle)
                .addGap(20)
                .addComponent(BingoTitleCustomizeButton)
                .addGap(20)
                .addComponent(BingoWideCustomizeButton)
                .addGap(20)
                .addComponent(CustomizeButton)
        );

    }

    public String[] setStringArray( ArrayList<String> al ) {
        String[] arr = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }

}
