package io.neilshirsat.bingoboard;

import io.neilshirsat.Application;
import io.neilshirsat.StartUpWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Objects;

public class BingoSquare extends JPanel {

    protected boolean PrintString = true;

    protected String CharToPrint;

    protected Font font;

    protected Color TextColor;

    protected Color BorderColor;

    protected boolean Checked;

    public BingoSquare(String CharToPrint ) {
        super();

        TextColor = Color.WHITE;
        BorderColor = Color.BLACK;

        super.setSize(100, 100);
        super.setMaximumSize(new Dimension(150, 150));
        super.setPreferredSize(new Dimension(150, 150));
        super.setBorder( BorderFactory.createLineBorder(BorderColor) );

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
        }

        g.setColor(TextColor);
        g.setFont( g.getFont().deriveFont(50f) );
        FontMetrics fm = g.getFontMetrics();

        int stringWidth = fm.stringWidth(CharToPrint);
        int stringAccent = fm.getAscent();
        int xCoordinate = getWidth() / 2 - stringWidth / 2;
        int yCoordinate = getHeight() / 2 + stringAccent / 2;
        if (PrintString) {
            g.drawString(CharToPrint, xCoordinate, yCoordinate);
        }

    }

    public void setSquareBackground( Color Color ){
        this.setBackground(Color);
        this.repaint();
    }

    public void setSquareTextColor( Color Color ) {
        TextColor = Color;
        repaint();
    }

    public void setBorderColor( Color BorderColor ) {
        this.BorderColor = BorderColor;
        this.setBorder(BorderFactory.createLineBorder(BorderColor));
    }

    public boolean isChecked() {
        return Checked;
    }

    public void setChecked(boolean checked) {
        Checked = checked;
        repaint();
    }

}
