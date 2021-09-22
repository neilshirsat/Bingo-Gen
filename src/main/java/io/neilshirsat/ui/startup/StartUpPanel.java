package io.neilshirsat.ui.startup;

import io.neilshirsat.Application;
import io.neilshirsat.util.WindowDragListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class StartUpPanel extends JPanel {

    private Font TextFont;

    private Color TextColor;

    private io.neilshirsat.util.WindowDragListener WindowDragListener;

    private final String Title = "Bingo Gen_";

    public StartUpPanel() {
        super();
        super.setBackground( Color.BLACK );

        try {
            TextFont = Font.createFont(Font.TRUETYPE_FONT,
                    Objects.requireNonNull(Application.class.getResourceAsStream("NotoSans-Regular.ttf")));
            TextFont = TextFont.deriveFont(Font.PLAIN, 75f);
        } catch (Exception e) {
            System.out.println("Font Not Initialized");
        }
        TextColor = new Color( 255, 255, 255 );

        WindowDragListener = new WindowDragListener();
        addMouseListener(WindowDragListener);
        addMouseMotionListener(WindowDragListener);

    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
        g2d.setBackground(Color.BLACK);

        g.setColor( TextColor );
        g.setFont(TextFont);

        FontMetrics fm = g2d.getFontMetrics();
        int x = ((getWidth() - fm.stringWidth(Title)) / 2);
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();

        g2d.drawString(Title, x, y);

    }

}
