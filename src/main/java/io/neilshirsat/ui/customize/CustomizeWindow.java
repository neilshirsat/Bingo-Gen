package io.neilshirsat.ui.customize;

import io.neilshirsat.ui.bingo.BingoState;

import javax.swing.*;
import java.awt.*;

public class CustomizeWindow extends JFrame {

    private CustomizePanel CustomizeView;

    private BingoState State;

    public CustomizeWindow(BingoState State){
        super();
        this.State = State;

        super.setTitle("Customize Bingo Board");
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setSize(  (int)WindowDimension.getHeight() * 15/16 * 5/6 , (int)WindowDimension.getHeight() * 15/16);
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        CustomizeView = new CustomizePanel(State);
        super.setContentPane(CustomizeView);

    }

    public CustomizePanel getCustomizeView() {
        return CustomizeView;
    }

    public void setCustomizeView(CustomizePanel customizeView) {
        CustomizeView = customizeView;
    }

}
