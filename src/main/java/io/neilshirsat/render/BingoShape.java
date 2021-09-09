package io.neilshirsat.render;

import java.awt.*;

public class BingoShape {

    /**
     * Id of the Bingo Shape
     */
    private int Id;

    /**
     * Border Type for the Square
     */
    private BorderType BorderType;

    /**
     * Thickness of the Border
     */
    private int BorderThickness;

    /**
     * Border Color
     */
    private Color BorderColor;

    /**
     * Background Color of the Square
     */
    private Color BackgroundColor;

    /**
     * Is the Background Custom
     */
    private boolean isBackgroundCustom;

    /**
     * Shape of the Background
     */
    private Shape BackgroundShape;

    /**
     * X Position
     */
    private int BackgroundPositionX;

    /**
     * Y Position
     */
    private int BackgroundPositionY;

    /**
     * Background Width
     */
    private int BackgroundWidth;

    private int BackgroundHeight;

    private Font TextFont;

    private float TextFontSize;

    private Color TextFontColor;

    private int TextPositionX;

    private int TextPositionY;

    private int PreferedWidth;

    private int PreferedHeight;

    private int MaxWidth;

    private int MaxHeight;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public io.neilshirsat.render.BorderType getBorderType() {
        return BorderType;
    }

    public void setBorderType(io.neilshirsat.render.BorderType borderType) {
        BorderType = borderType;
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

    public Color getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        BackgroundColor = backgroundColor;
    }

    public boolean isBackgroundCustom() {
        return isBackgroundCustom;
    }

    public void setBackgroundCustom(boolean backgroundCustom) {
        isBackgroundCustom = backgroundCustom;
    }

    public Shape getBackgroundShape() {
        return BackgroundShape;
    }

    public void setBackgroundShape(Shape backgroundShape) {
        BackgroundShape = backgroundShape;
    }

    public int getBackgroundPositionX() {
        return BackgroundPositionX;
    }

    public void setBackgroundPositionX(int backgroundPositionX) {
        BackgroundPositionX = backgroundPositionX;
    }

    public int getBackgroundPositionY() {
        return BackgroundPositionY;
    }

    public void setBackgroundPositionY(int backgroundPositionY) {
        BackgroundPositionY = backgroundPositionY;
    }

    public int getBackgroundWidth() {
        return BackgroundWidth;
    }

    public void setBackgroundWidth(int backgroundWidth) {
        BackgroundWidth = backgroundWidth;
    }

    public int getBackgroundHeight() {
        return BackgroundHeight;
    }

    public void setBackgroundHeight(int backgroundHeight) {
        BackgroundHeight = backgroundHeight;
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

    public Color getTextFontColor() {
        return TextFontColor;
    }

    public void setTextFontColor(Color textFontColor) {
        TextFontColor = textFontColor;
    }

    public int getTextPositionX() {
        return TextPositionX;
    }

    public void setTextPositionX(int textPositionX) {
        TextPositionX = textPositionX;
    }

    public int getTextPositionY() {
        return TextPositionY;
    }

    public void setTextPositionY(int textPositionY) {
        TextPositionY = textPositionY;
    }

    public int getPreferedWidth() {
        return PreferedWidth;
    }

    public void setPreferedWidth(int preferedWidth) {
        PreferedWidth = preferedWidth;
    }

    public int getPreferedHeight() {
        return PreferedHeight;
    }

    public void setPreferedHeight(int preferedHeight) {
        PreferedHeight = preferedHeight;
    }

    public int getMaxWidth() {
        return MaxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        MaxWidth = maxWidth;
    }

    public int getMaxHeight() {
        return MaxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        MaxHeight = maxHeight;
    }

}
