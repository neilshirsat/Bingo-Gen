package io.neilshirsat.bingoboard;

import javax.swing.*;
import java.awt.*;

public class BingoPreviewWindow extends JFrame {

    public Color BackgroundColor;

    public Color TextColor;

    public Color TitleTextColor;

    public Color TitleBackgroundColor;

    public Color BorderColor;

    private BingoGrid bingo;

    public BingoPreviewWindow(
            Color BackgroundColor,
            Color TextColor,
            Color TitleTextColor,
            Color TitleBackgroundColor
    ) {

        super();

        this.BackgroundColor = BackgroundColor;
        this.getContentPane().setBackground(BackgroundColor);

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();

        this.TextColor = TextColor;
        this.TitleTextColor = TitleTextColor;
        this.TitleBackgroundColor = TitleBackgroundColor;

        super.setUndecorated(true);
        super.setTitle("Bingo Board Preview");
        super.setSize(  (int)WindowDimension.getHeight() * 15/16 * 5/6 , (int)WindowDimension.getHeight() * 15/16);
        //super.setResizable(false);
        super.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

        bingo = new BingoGrid();
        bingo.setSquareBackground(BackgroundColor);
        bingo.setSquareTextColor(TextColor);
        bingo.setTitleColor(TitleTextColor);
        bingo.setTitleBackgroundColor(TitleBackgroundColor);
        super.add( bingo );

        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
    }

    public void setPreviewBackground( Color BackgroundColor ) {
        this.BackgroundColor = BackgroundColor;
        this.getContentPane().setBackground(BackgroundColor);
        bingo.setSquareBackground(BackgroundColor);
    }

    public void setPreviewTextColor( Color TextColor ) {
        this.TextColor = TextColor;
        bingo.setSquareTextColor(TextColor);
    }

    public void setPreviewTitleTextColor( Color TitleTextColor ) {
        this.TitleTextColor = TitleTextColor;
        bingo.setTitleColor( TitleTextColor );
    }

    public void setPreviewTitleBackgroundColor( Color TitleBackgroundColor ) {
        this.TitleBackgroundColor = TitleBackgroundColor;
        bingo.setTitleBackgroundColor(TitleBackgroundColor);
    }

    public void setPreviewBorderColor( Color BorderColor ) {
        this.BorderColor = BorderColor;
        bingo.setBorderColor(BorderColor);
    }

}
