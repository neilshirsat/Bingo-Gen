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
        SetBingoStyle = new Select<String>(setStringArray(SetBingoStylesList));
        SetBingoStyle.setLabel("Bingo Theme: ");
        SetBingoStyle.getSelectList().addActionListener(e->{
            String value = (String) SetBingoStyle.getSelectList().getSelectedItem();

            assert value != null;
            if (value.equals("Dark")) {

                State.setBaseBackgroundColor(Color.BLACK);
                
                for (int i = 0; i < 5; i++){
                    State.getTitleSquares()[i].setTextColor(Color.YELLOW);
                    State.getTitleSquares()[i].setBorderColor(Color.WHITE);
                    State.getTitleSquares()[i].setBackgroundColor(Color.BLACK);
                    State.getTitleSquares()[i].setBorderThickness(2);
                    State.getTitleSquares()[i].setShape(ShapeType.CIRCLE);
                }

                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5; j++){
                        State.getBingoSquares()[i][j].setTextColor(Color.YELLOW);
                        State.getBingoSquares()[i][j].setBorderColor(Color.WHITE);
                        State.getBingoSquares()[i][j].setBackgroundColor(Color.BLACK);
                        State.getBingoSquares()[i][j].setBorderThickness(2);
                        State.getBingoSquares()[i][j].setShape(ShapeType.RECTANGLE);
                        State.getBingoSquares()[i][j].setSelectedColor(Color.BLUE);
                    }
                }
            }
            else if (value.equals("Dark Squares")) {

                State.setBaseBackgroundColor(Color.BLACK);

                for (int i = 0; i < 5; i++){
                    State.getTitleSquares()[i].setTextColor(Color.YELLOW);
                    State.getTitleSquares()[i].setBorderColor(Color.WHITE);
                    State.getTitleSquares()[i].setBackgroundColor(Color.BLACK);
                    State.getTitleSquares()[i].setBorderThickness(2);
                    State.getTitleSquares()[i].setShape(ShapeType.RECTANGLE);
                }

                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5; j++){
                        State.getBingoSquares()[i][j].setTextColor(Color.YELLOW);
                        State.getBingoSquares()[i][j].setBorderColor(Color.WHITE);
                        State.getBingoSquares()[i][j].setBackgroundColor(Color.BLACK);
                        State.getBingoSquares()[i][j].setBorderThickness(2);
                        State.getBingoSquares()[i][j].setShape(ShapeType.RECTANGLE);
                        State.getBingoSquares()[i][j].setSelectedColor(Color.BLUE);
                    }
                }
            }
            else if (value.equals("Black & Red")) {

                State.setBaseBackgroundColor(Color.BLACK);

                for (int i = 0; i < 5; i++){
                    State.getTitleSquares()[i].setTextColor(Color.RED);
                    State.getTitleSquares()[i].setBorderColor(Color.RED);
                    State.getTitleSquares()[i].setBackgroundColor(Color.BLACK);
                    State.getTitleSquares()[i].setBorderThickness(2);
                    State.getTitleSquares()[i].setShape(ShapeType.CIRCLE);
                }

                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5; j++){
                        State.getBingoSquares()[i][j].setTextColor(Color.RED);
                        State.getBingoSquares()[i][j].setBorderColor(Color.RED);
                        State.getBingoSquares()[i][j].setBackgroundColor(Color.BLACK);
                        State.getBingoSquares()[i][j].setBorderThickness(2);
                        State.getBingoSquares()[i][j].setShape(ShapeType.RECTANGLE);
                        State.getBingoSquares()[i][j].setSelectedColor(Color.BLUE);
                    }
                }
            }
            else if (value.equals("Ocean")) {

                State.setBaseBackgroundColor(new Color(0, 174, 255));

                for (int i = 0; i < 5; i++){
                    State.getTitleSquares()[i].setTextColor(Color.BLACK);
                    State.getTitleSquares()[i].setBorderColor(Color.BLACK);
                    State.getTitleSquares()[i].setBackgroundColor(new Color(0, 174, 255));
                    State.getTitleSquares()[i].setBorderThickness(2);
                    State.getTitleSquares()[i].setShape(ShapeType.CIRCLE);
                }

                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5; j++){
                        State.getBingoSquares()[i][j].setTextColor(Color.BLACK);
                        State.getBingoSquares()[i][j].setBorderColor(Color.BLACK);
                        State.getBingoSquares()[i][j].setBackgroundColor(new Color(0, 174, 255));
                        State.getBingoSquares()[i][j].setBorderThickness(2);
                        State.getBingoSquares()[i][j].setShape(ShapeType.RECTANGLE);
                        State.getBingoSquares()[i][j].setSelectedColor(Color.GREEN);
                    }
                }
            }
            else if (value.equals("Ocean Circles")) {

                State.setBaseBackgroundColor(new Color(0, 174, 255));

                for (int i = 0; i < 5; i++){
                    State.getTitleSquares()[i].setTextColor(Color.BLACK);
                    State.getTitleSquares()[i].setBorderColor(Color.BLACK);
                    State.getTitleSquares()[i].setBackgroundColor(new Color(0, 174, 255));
                    State.getTitleSquares()[i].setBorderThickness(2);
                    State.getTitleSquares()[i].setShape(ShapeType.RECTANGLE);
                }

                for (int i = 0; i < 5; i++){
                    for (int j = 0; j < 5; j++){
                        State.getBingoSquares()[i][j].setTextColor(Color.BLACK);
                        State.getBingoSquares()[i][j].setBorderColor(Color.BLACK);
                        State.getBingoSquares()[i][j].setBackgroundColor(new Color(0, 174, 255));
                        State.getBingoSquares()[i][j].setBorderThickness(2);
                        State.getBingoSquares()[i][j].setShape(ShapeType.CIRCLE);
                        State.getBingoSquares()[i][j].setSelectedColor(Color.GREEN);
                    }
                }
            }

        });

        CustomizeWindow = new CustomizeWindow(State);
        CustomizeButton = new JButton("Customize Bingo Styling");
        CustomizeButton.addActionListener(e -> {
            CustomizeTab.this.CustomizeWindow.setVisible(true);
            SwingUtilities.updateComponentTreeUI(SwingUtilities.getRoot(CustomizeWindow));
        });

        CustomizeTabLayout.setHorizontalGroup(CustomizeTabLayout.createParallelGroup()
                .addComponent(SetBingoStyle)
                .addComponent(CustomizeButton)
        );
        CustomizeTabLayout.setVerticalGroup(CustomizeTabLayout.createSequentialGroup()
                .addComponent(SetBingoStyle)
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
