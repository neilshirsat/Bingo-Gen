package io.neilshirsat.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowDragListener extends MouseAdapter {

    private Point StartLocation;

    public WindowDragListener() {
        StartLocation = new Point();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            StartLocation.setLocation(e.getPoint());
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Component c = SwingUtilities.getRoot(e.getComponent());
        if (c instanceof Window && SwingUtilities.isLeftMouseButton(e)) {
            Point pt = c.getLocation();
            c.setLocation(pt.x - StartLocation.x + e.getX(), pt.y - StartLocation.y + e.getY());
        }
    }

}
