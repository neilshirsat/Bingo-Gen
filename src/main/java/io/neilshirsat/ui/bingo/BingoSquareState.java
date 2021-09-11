package io.neilshirsat.ui.bingo;

import io.neilshirsat.render.ShapeType;

import java.awt.*;

public class BingoSquareState {

    private long BingoId;

    private int PositionX;

    private int PositionY;

    private int MaxHeight;

    private int MaxWidth;

    private ShapeType Shape;

    private Color BackgroundColor;

    private int BorderThickness;

    private Color BorderColor;

    private Color TextColor;

    private Font TextFont;

    private int FontStyle;

    private float FontSize;

    private boolean Analise;

    private boolean TextAnalise;

    private boolean isFreeSpace;

    private String FreeSpaceText;

    private boolean isTitle;

    private String TitleText;

    private String SquareNumber;

    private Color BaseBackgroundColor;

    private BingoActionListener BingoActionListener;

    public long getBingoId() {
        return BingoId;
    }

    public void setBingoId(long bingoId) {
        BingoId = bingoId;
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

    public int getMaxHeight() {
        return MaxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        MaxHeight = maxHeight;
    }

    public int getMaxWidth() {
        return MaxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        MaxWidth = maxWidth;
    }

    public ShapeType getShape() {
        return Shape;
    }

    public void setShape(ShapeType shape) {
        Shape = shape;
    }

    public Color getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        BackgroundColor = backgroundColor;
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

    public Color getTextColor() {
        return TextColor;
    }

    public void setTextColor(Color textColor) {
        TextColor = textColor;
    }

    public Font getTextFont() {
        return TextFont;
    }

    public void setTextFont(Font textFont) {
        TextFont = textFont;
    }

    public int getFontStyle() {
        return FontStyle;
    }

    public void setFontStyle(int fontStyle) {
        FontStyle = fontStyle;
    }

    public float getFontSize() {
        return FontSize;
    }

    public void setFontSize(float fontSize) {
        FontSize = fontSize;
    }

    public BingoActionListener getBingoActionListener() {
        return BingoActionListener;
    }

    public void setBingoActionListener(BingoActionListener bingoActionListener) {
        BingoActionListener = bingoActionListener;
    }

    public boolean isAnalise() {
        return Analise;
    }

    public void setAnalise(boolean Analise) {
        this.Analise = Analise;
    }

    public boolean isTextAnalise() {
        return TextAnalise;
    }

    public void setTextAnalise(boolean textAnalise) {
        TextAnalise = textAnalise;
    }

    public boolean isFreeSpace() {
        return isFreeSpace;
    }

    public void setFreeSpace(boolean freeSpace) {
        isFreeSpace = freeSpace;
    }

    public String getFreeSpaceText() {
        return FreeSpaceText;
    }

    public void setFreeSpaceText(String freeSpaceText) {
        FreeSpaceText = freeSpaceText;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public String getTitleText() {
        return TitleText;
    }

    public void setTitleText(String titleText) {
        TitleText = titleText;
    }

    public String getSquareNumber() {
        return SquareNumber;
    }

    public void setSquareNumber(String squareNumber) {
        SquareNumber = squareNumber;
    }

    public Color getBaseBackgroundColor() {
        return BaseBackgroundColor;
    }

    public void setBaseBackgroundColor(Color baseBackgroundColor) {
        BaseBackgroundColor = baseBackgroundColor;
    }


}
