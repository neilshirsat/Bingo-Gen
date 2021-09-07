package io.neilshirsat.components;

import javax.swing.border.Border;
import java.awt.*;

public class CircleBorder implements Border {

    private Color BorderColor;

    public CircleBorder(Color BorderColor) {
        this.BorderColor = BorderColor;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        if (g instanceof Graphics2D g2d) {
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(1));
        }

        g.setColor(BorderColor);
        g.drawRoundRect(x,y,width-1,height-1,width,height);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets( c.getHeight(), c.getHeight(), c.getHeight(), c.getHeight() );
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
