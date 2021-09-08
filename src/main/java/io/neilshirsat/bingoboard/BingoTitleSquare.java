package io.neilshirsat.bingoboard;

import com.formdev.flatlaf.ui.FlatRoundBorder;
import io.neilshirsat.Application;
import io.neilshirsat.components.CircleBorder;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class BingoTitleSquare extends JPanel {

    private String CharToPrint;

    private Font font;

    private Color BackgroundColor;

    private Color TextColor;

    private Color BorderColor;

    private CircleBorder Border;

    private int getRandomColor() {
        return (int)(Math.random() * 255);
    }

    public BingoTitleSquare( String CharToPrint ) {
        super();

        TextColor = Color.WHITE;
        BorderColor = Color.BLACK;
        BackgroundColor = Color.BLACK;

        super.setSize(100, 100);
        super.setMaximumSize(new Dimension(150, 150));
        super.setPreferredSize(new Dimension(150, 150));
        //super.setBorder( BorderFactory.createLineBorder(Color.BLACK) );
        //Border = new CircleBorder(BorderColor);
        //super.setBorder(Border);

        this.CharToPrint = CharToPrint;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT,
                    Objects.requireNonNull(Application.class.getResourceAsStream("NotoSans-Regular.ttf")));
        } catch (Exception e) {
            System.out.println("Font Not Initialized");
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (g instanceof Graphics2D g2d) {
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );

            g2d.setPaint(BackgroundColor);
            g2d.fillOval(0, 0, getWidth(), getHeight());
        }

        g.setColor(TextColor);
        g.setFont( g.getFont().deriveFont(50f) );
        FontMetrics fm = g.getFontMetrics();

        int stringWidth = fm.stringWidth(CharToPrint);
        int stringAccent = fm.getAscent();
        int xCoordinate = getWidth() / 2 - stringWidth / 2;
        int yCoordinate = getHeight() / 2 + stringAccent / 2;
        g.drawString(CharToPrint, xCoordinate, yCoordinate);

    }

    public void setExtraBackground(Color Color) {
        this.setBackground(Color);
        this.repaint();
    }

    public void setSquareBackground( Color Color ){
        this.BackgroundColor = Color;
        this.repaint();
    }

    public void setSquareTextColor( Color Color ) {
        TextColor = Color;
        repaint();
    }

}
