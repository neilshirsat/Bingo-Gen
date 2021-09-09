package io.neilshirsat.render.shapes;

import io.neilshirsat.render.BorderType;

import java.awt.*;

public class Triangle implements PaintableGraphics {

    private int PositionY;

    private int PositionX;

    private int Height;

    private int Width;

    private boolean BorderedShape;

    private int BorderThickness;

    private Color BorderColor;

    private io.neilshirsat.render.BorderType BorderType;

    private boolean BackgroundedShape;

    private Color BackgroundColor;

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

    public io.neilshirsat.render.BorderType getBorderType() {
        return BorderType;
    }

    public void setBorderType(io.neilshirsat.render.BorderType borderType) {
        BorderType = borderType;
    }

    public boolean isBackgroundedShape() {
        return BackgroundedShape;
    }

    public void setBackgroundedShape(boolean backgroundedShape) {
        BackgroundedShape = backgroundedShape;
    }

    public Color getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        BackgroundColor = backgroundColor;
    }

    @Override
    public void paint(Graphics g) {

    }

    @Override
    public boolean shouldGraphicsRepaint() {
        return false;
    }

}
