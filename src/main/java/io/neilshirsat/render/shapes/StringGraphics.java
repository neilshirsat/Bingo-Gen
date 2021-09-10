package io.neilshirsat.render.shapes;

import java.awt.*;
import io.neilshirsat.render.*;

public class StringGraphics implements PaintableGraphics {

    private String StringToPrint;

    private int PositionY;

    private int PositionX;

    private int Height;

    private int Width;

    private boolean BorderedShape;

    private int BorderThickness;

    private Color BorderColor;

    private BorderType BorderType;

    private Font TextFont;

    private float TextFontSize;

    private int TextFontStyle;

    private Color TextFontColor;

    private boolean Centered;

    public int getPositionY() {
        return PositionY;
    }

    public void setPositionY(int positionY) {
        PositionY = positionY;
    }

    public int getPositionX() {
        return PositionX;
    }

    public void setPositionX(int positionX) {
        PositionX = positionX;
    }

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

    public boolean isBorderedShape() {
        return BorderedShape;
    }

    public void setBorderedShape(boolean borderedShape) {
        BorderedShape = borderedShape;
    }

    public int getBorderThickness() {
        return BorderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        BorderThickness = borderThickness;
    }

    public Color getBorderColor() {
        return BorderColor;
    }

    public void setBorderColor(Color borderColor) {
        BorderColor = borderColor;
    }

    public BorderType getBorderType() {
        return BorderType;
    }

    public void setBorderType(BorderType borderType) {
        BorderType = borderType;
    }

    public Font getTextFont() {
        return TextFont;
    }

    public void setTextFont(Font textFont) {
        TextFont = textFont;
    }

    public float getTextFontSize() {
        return TextFontSize;
    }

    public void setTextFontSize(float textFontSize) {
        TextFontSize = textFontSize;
    }

    public int getTextFontStyle() {
        return TextFontStyle;
    }

    public void setTextFontStyle(int textFontStyle) {
        TextFontStyle = textFontStyle;
    }

    public Color getTextFontColor() {
        return TextFontColor;
    }

    public void setTextFontColor(Color textFontColor) {
        TextFontColor = textFontColor;
    }

    public boolean isCentered() {
        return Centered;
    }

    public void setCentered(boolean centered) {
        Centered = centered;
    }

    public String getStringToPrint() {
        return StringToPrint;
    }

    public void setStringToPrint(String stringToPrint) {
        StringToPrint = stringToPrint;
    }

    @Override
    public void paint(Graphics g) {

        //Add Text Antialiasing
        if (g instanceof Graphics2D g2d) {
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
        }

        //Set the Color of the Text and Set the Font
        g.setColor(TextFontColor);
        g.setFont(TextFont.deriveFont(TextFontStyle, TextFontSize));

        //If the Text Is Centered
        if (isCentered()){
            FontMetrics fm = g.getFontMetrics();

            int stringWidth = fm.stringWidth(StringToPrint);
            int stringAccent = fm.getAscent();
            int xCoordinate = getWidth() / 2 - stringWidth / 2;
            int yCoordinate = getHeight() / 2 + stringAccent / 2;
            g.drawString(StringToPrint, xCoordinate, yCoordinate);

        }
        else {
            g.drawString(StringToPrint, PositionX, PositionY);
        }

    }

    @Override
    public boolean shouldGraphicsRepaint() {
        return false;
    }

}