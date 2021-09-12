package io.neilshirsat.ui.bingo;

import io.neilshirsat.util.ShapeType;

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

    private BingoStateWatcher BingoStateWatcher;

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
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.POSITION_X);
        }
    }

    public int getPositionY() {
        return PositionY;
    }

    public void setPositionY(int positionY) {
        PositionY = positionY;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.POSITION_Y);
        }
    }

    public int getMaxHeight() {
        return MaxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        MaxHeight = maxHeight;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.MAX_HEIGHT);
        }
    }

    public int getMaxWidth() {
        return MaxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        MaxWidth = maxWidth;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.MAX_WIDTH);
        }
    }

    public ShapeType getShape() {
        return Shape;
    }

    public void setShape(ShapeType shape) {
        Shape = shape;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.SHAPE);
        }
    }

    public Color getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        BackgroundColor = backgroundColor;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.BACKGROUND_COLOR);
        }
    }

    public int getBorderThickness() {
        return BorderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        BorderThickness = borderThickness;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.BORDER_THICKNESS);
        }
    }

    public Color getBorderColor() {
        return BorderColor;
    }

    public void setBorderColor(Color borderColor) {
        BorderColor = borderColor;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.BORDER_COLOR);
        }
    }

    public Color getTextColor() {
        return TextColor;
    }

    public void setTextColor(Color textColor) {
        TextColor = textColor;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.TEXT_COLOR);
        }
    }

    public Font getTextFont() {
        return TextFont;
    }

    public void setTextFont(Font textFont) {
        TextFont = textFont;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.TEXT_FONT);
        }
    }

    public int getFontStyle() {
        return FontStyle;
    }

    public void setFontStyle(int fontStyle) {
        FontStyle = fontStyle;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.TEXT_FONT_STYLE);
        }
    }

    public float getFontSize() {
        return FontSize;
    }

    public void setFontSize(float fontSize) {
        FontSize = fontSize;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.TEXT_FONT_SIZE);
        }
    }

    public BingoActionListener getBingoActionListener() {
        return BingoActionListener;
    }

    public void setBingoActionListener(BingoActionListener bingoActionListener) {
        BingoActionListener = bingoActionListener;
    }

    public io.neilshirsat.ui.bingo.BingoStateWatcher getBingoStateWatcher() {
        return BingoStateWatcher;
    }

    public void setBingoStateWatcher(io.neilshirsat.ui.bingo.BingoStateWatcher bingoStateWatcher) {
        BingoStateWatcher = bingoStateWatcher;
    }

    public boolean isAnalise() {
        return Analise;
    }

    public void setAnalise(boolean Analise) {
        this.Analise = Analise;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.ANALISE);
        }
    }

    public boolean isTextAnalise() {
        return TextAnalise;
    }

    public void setTextAnalise(boolean textAnalise) {
        TextAnalise = textAnalise;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.TEXT_ANALISE);
        }
    }

    public boolean isFreeSpace() {
        return isFreeSpace;
    }

    public void setFreeSpace(boolean freeSpace) {
        isFreeSpace = freeSpace;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.IS_FREE_SPACE);
        }
    }

    public String getFreeSpaceText() {
        return FreeSpaceText;
    }

    public void setFreeSpaceText(String freeSpaceText) {
        FreeSpaceText = freeSpaceText;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.FREE_SPACE_TEXT);
        }
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.IS_TITLE);
        }
    }

    public String getTitleText() {
        return TitleText;
    }

    public void setTitleText(String titleText) {
        TitleText = titleText;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.TITLE_TEXT);
        }
    }

    public String getSquareNumber() {
        return SquareNumber;
    }

    public void setSquareNumber(String squareNumber) {
        SquareNumber = squareNumber;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.SQUARE_NUMBER);
        }
    }

    public Color getBaseBackgroundColor() {
        return BaseBackgroundColor;
    }

    public void setBaseBackgroundColor(Color baseBackgroundColor) {
        BaseBackgroundColor = baseBackgroundColor;
    }


}
