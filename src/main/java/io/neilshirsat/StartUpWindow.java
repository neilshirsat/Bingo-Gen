package io.neilshirsat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.util.Objects;

public class StartUpWindow extends JFrame {

    public StartUpWindow() throws Exception {
        super();
        super.setUndecorated(true);
        super.setTitle("Bingo Gen_");
        super.setSize( 800, 500);
        Screen screen = new Screen();
        super.getContentPane().add( screen );

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        setVisible(true);
    }

    static class Screen extends JPanel {

        private Font font;

        private final Color textcolor;

        private Image background;

        public Screen() {
            super();
            super.setBackground( new Color(0, 8, 10) );
            try {
                font = Font.createFont(Font.TRUETYPE_FONT,
                        Objects.requireNonNull(Screen.class.getResourceAsStream("NotoSans-Regular.ttf")));
                background = ImageIO.read(Objects.requireNonNull(Screen.class.getResourceAsStream("Vibration.jpg")));
            } catch (Exception e) {
                System.out.println("Font Not Initialized");
            }
            textcolor = new Color( 255, 255, 255 );
            DragWindowListener dwl = new DragWindowListener();
            addMouseListener(dwl);
            addMouseMotionListener(dwl);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (g instanceof Graphics2D g2d) {
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
            }

            g.drawImage( background, 0, 0, getWidth(), getHeight(), new ImageObserver() {
                @Override
                public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                    return false;
                }
            });

            g.setColor( textcolor );
            g.setFont(font.deriveFont(20f));

            g.drawString("io.neilshirsat.Bingo v1.0.0_", 10, 490);
            g.drawString( "Loading...", 700, 490);

            g.setFont(font.deriveFont(80f));
            g.drawString( "Bingo Gen_", 100, 100 );
        }
    }

    static class DragWindowListener extends MouseAdapter {
        private final Point startPt = new Point();

        @Override public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                startPt.setLocation(e.getPoint());
            }
        }

        @Override public void mouseDragged(MouseEvent e) {
            Component c = SwingUtilities.getRoot(e.getComponent());
            if (c instanceof Window && SwingUtilities.isLeftMouseButton(e)) {
                Point pt = c.getLocation();
                c.setLocation(pt.x - startPt.x + e.getX(), pt.y - startPt.y + e.getY());
            }
        }
    }

}
