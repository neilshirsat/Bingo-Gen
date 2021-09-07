package io.neilshirsat.bingoboard;

import java.awt.*;

public class FreeSpace extends BingoSquare {

    public FreeSpace(){
        super("Free Space");
        PrintString = false;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (g instanceof Graphics2D g2d) {
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        }

        g.setColor(TextColor);
        g.setFont( g.getFont().deriveFont(25f) );
        FontMetrics fm = g.getFontMetrics();

        int stringWidth = fm.stringWidth(CharToPrint);
        int stringAccent = fm.getAscent();
        int xCoordinate = getWidth() / 2 - stringWidth / 2;
        int yCoordinate = getHeight() / 2 + stringAccent / 2;
        g.drawString(CharToPrint, xCoordinate, yCoordinate);
    }

}
