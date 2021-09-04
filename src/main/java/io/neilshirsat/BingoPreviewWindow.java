package io.neilshirsat;

import io.neilshirsat.components.TitleBar;

import javax.swing.*;
import java.awt.*;

public class BingoPreviewWindow extends JFrame {

    public BingoPreviewWindow() {
        super();
        //super.setUndecorated(true);
        super.setTitle("Bingo Board Preview");
        super.setSize( 750, 900);

        TitleBar titleBar = new TitleBar(this.rootPane);
        super.add( new BingoGrid() );

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    }

}
