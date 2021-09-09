package io.neilshirsat.components;

import javax.swing.*;

/**
 * @author Neil Shirsat
 *
 * Utility Windows for the Application Providing
 * Various Functionalities that Need to Be Provided
 * in the Application by Different Processes
 *
 *
 */
public class UtilityWindow extends JFrame {

    /**
     * Height of the Window
     */
    private int Height;

    /**
     * Width of the Window
     */
    private int Width;

    /**
     * X Position of the Window
     */
    private int PositionX;

    /**
     * Y Position of the Window
     */
    private int PositionY;

    /**
     * Root Pane of the Window
     */
    private JRootPane RootPane;

    /**
     * Menu Bar of the Window
     */
    private JMenuBar WindowMenuBar;

    /**
     * Window Title
     */
    private String Title;

    /**
     * Look and Feel of the Window
     */
    private LookAndFeel WindowLookAndFeel;

    /**
     * The Type of Frame that is Used
     */
    private int FrameType;

    /**
     * Is the Window Enabled
     */
    private boolean isEnabled;

    /**
     * Is the Window Visible/Shown
     */
    private boolean isVisible;

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public int getPositionX() {
        return PositionX;
    }

    public void setPositionX(int positionX) {
        PositionX = positionX;
    }

    public int getPositionY() {
        return PositionY;
    }

    public void setPositionY(int positionY) {
        PositionY = positionY;
    }

    public JRootPane getRootPane() {
        return RootPane;
    }

    public void setRootPane(JRootPane rootPane) {
        RootPane = rootPane;
    }

    public JMenuBar getWindowMenuBar() {
        return WindowMenuBar;
    }

    public void setWindowMenuBar(JMenuBar menuBar) {
        WindowMenuBar = menuBar;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public LookAndFeel getWindowLookAndFeel() {
        return WindowLookAndFeel;
    }

    public void setWindowLookAndFeel(LookAndFeel windowLookAndFeel) {
        WindowLookAndFeel = windowLookAndFeel;
    }

    public int getFrameType() {
        return FrameType;
    }

    public void setFrameType(int frameType) {
        FrameType = frameType;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

}
