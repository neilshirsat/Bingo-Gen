package io.neilshirsat.render.shapes;

import java.awt.*;

public interface PaintableGraphics {

    void paint(Graphics g);

    boolean shouldGraphicsRepaint();

}
