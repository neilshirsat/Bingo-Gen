package io.neilshirsat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BingoSquare extends JPanel {

    private String CharToPrint;

    private Font font;

    private int getRandomColor() {
        return (int)Math.random() * 255;
    }

    public BingoSquare( String CharToPrint ) {
        super();
        this.CharToPrint = CharToPrint;
        font = new Font( Font.SANS_SERIF, Font.PLAIN, 12 );
        super.setBackground( new Color(  ) );
        try {
            font = Font.createFont(Font.TRUETYPE_FONT,
                    Objects.requireNonNull(StartUpWindow.Screen.class.getResourceAsStream("NotoSans-Regular.ttf")));
        } catch (Exception e) {
            System.out.println("Font Not Initialized");
        }
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        if (g instanceof Graphics2D g2d) {
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        }

        g.setFont( g.getFont().deriveFont(50f) );

        g.drawString(CharToPrint, 10, 10);
    }
}
