package io.neilshirsat.ui.start;

import io.neilshirsat.Application;
import io.neilshirsat.util.WindowDragListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class StartPanel extends JPanel {

    private Font font;

    private final Color textcolor;

    private Image background;

    private WindowDragListener WindowDragListener;

    public StartPanel() {
        super();
        super.setBackground( new Color(0, 8, 10) );

        try {
            font = Font.createFont(Font.TRUETYPE_FONT,
                    Objects.requireNonNull(Application.class.getResourceAsStream("NotoSans-Regular.ttf")));
            background = ImageIO.read(Objects.requireNonNull(Application.class.getResourceAsStream("Vibration.jpg")));
        } catch (Exception e) {
            System.out.println("Font Not Initialized");
        }
        textcolor = new Color( 255, 255, 255 );

        WindowDragListener = new WindowDragListener();
        addMouseListener(WindowDragListener);
        addMouseMotionListener(WindowDragListener);
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );

        g.setColor( textcolor );
        g.setFont(font.deriveFont(20f));

        g.drawString( "Loading...", 700, 490);

        g.setFont(font.deriveFont(80f));
        g.drawString( "Bingo Gen_", 100, 100 );
    }

}
