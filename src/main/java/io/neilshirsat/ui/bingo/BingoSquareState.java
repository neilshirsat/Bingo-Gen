package io.neilshirsat.ui.bingo;

import io.neilshirsat.util.ShapeType;

import java.awt.*;
import java.util.ArrayList;

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

    private ArrayList<BingoStateWatcher> BingoStateWatcher = new ArrayList<>();

    private Color SelectedColor;

    private boolean Selected;

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
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.POSITION_X);
        }
    }

    public int getPositionY() {
        return PositionY;
    }

    public void setPositionY(int positionY) {
        PositionY = positionY;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.POSITION_Y);
        }
    }

    public int getMaxHeight() {
        return MaxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        MaxHeight = maxHeight;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.MAX_HEIGHT);
        }
    }

    public int getMaxWidth() {
        return MaxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        MaxWidth = maxWidth;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.MAX_WIDTH);
        }
    }

    public ShapeType getShape() {
        return Shape;
    }

    public void setShape(ShapeType shape) {
        Shape = shape;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.SHAPE);
        }
    }

    public Color getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        BackgroundColor = backgroundColor;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.BACKGROUND_COLOR);
        }
    }

    public int getBorderThickness() {
        return BorderThickness;
    }

    public void setBorderThickness(int borderThickness) {
        BorderThickness = borderThickness;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.BORDER_THICKNESS);
        }
    }

    public Color getBorderColor() {
        return BorderColor;
    }

    public void setBorderColor(Color borderColor) {
        BorderColor = borderColor;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.BORDER_COLOR);
        }
    }

    public Color getTextColor() {
        return TextColor;
    }

    public void setTextColor(Color textColor) {
        TextColor = textColor;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.TEXT_COLOR);
        }
    }

    public Font getTextFont() {
        return TextFont;
    }

    public void setTextFont(Font textFont) {
        TextFont = textFont;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.TEXT_FONT);
        }
    }

    public int getFontStyle() {
        return FontStyle;
    }

    public void setFontStyle(int fontStyle) {
        FontStyle = fontStyle;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.TEXT_FONT_STYLE);
        }
    }

    public float getFontSize() {
        return FontSize;
    }

    public void setFontSize(float fontSize) {
        FontSize = fontSize;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.TEXT_FONT_SIZE);
        }
    }

    public BingoActionListener getBingoActionListener() {
        return BingoActionListener;
    }

    public void setBingoActionListener(BingoActionListener bingoActionListener) {
        BingoActionListener = bingoActionListener;
    }

    public ArrayList<BingoStateWatcher> getBingoStateWatcher() {
        return BingoStateWatcher;
    }

    public void setBingoStateWatcher(io.neilshirsat.ui.bingo.BingoStateWatcher bingoStateWatcher) {
        BingoStateWatcher.add(bingoStateWatcher);
    }

    public boolean isAnalise() {
        return Analise;
    }

    public void setAnalise(boolean Analise) {
        this.Analise = Analise;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.ANALISE);
        }
    }

    public boolean isTextAnalise() {
        return TextAnalise;
    }

    public void setTextAnalise(boolean textAnalise) {
        TextAnalise = textAnalise;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.TEXT_ANALISE);
        }
    }

    public boolean isFreeSpace() {
        return isFreeSpace;
    }

    public void setFreeSpace(boolean freeSpace) {
        isFreeSpace = freeSpace;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.IS_FREE_SPACE);
        }
    }

    public String getFreeSpaceText() {
        return FreeSpaceText;
    }

    public void setFreeSpaceText(String freeSpaceText) {
        FreeSpaceText = freeSpaceText;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.FREE_SPACE_TEXT);
        }
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.IS_TITLE);
        }
    }

    public String getTitleText() {
        return TitleText;
    }

    public void setTitleText(String titleText) {
        TitleText = titleText;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.TITLE_TEXT);
        }
    }

    public String getSquareNumber() {
        return SquareNumber;
    }

    public void setSquareNumber(String squareNumber) {
        SquareNumber = squareNumber;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.SQUARE_NUMBER);
        }
    }

    public Color getSelectedColor() {
        return SelectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        SelectedColor = selectedColor;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.SELECTED_COLOR);
        }
    }

    public boolean isSelected() {
        return Selected;
    }

    public void setSelected(boolean selected) {
        Selected = selected;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.IS_SELECTED);
        }
    }



    public Color getBaseBackgroundColor() {
        return BaseBackgroundColor;
    }

    public void setBaseBackgroundColor(Color baseBackgroundColor) {
        BaseBackgroundColor = baseBackgroundColor;
    }

    public BingoSquareState cloneBingoSquareState() {
        BingoSquareState NewState = new BingoSquareState();

        NewState.Analise = isAnalise();
        NewState.BackgroundColor = getBackgroundColor();
        NewState.BingoId = getBingoId();
        NewState.BorderColor = getBorderColor();
        NewState.BorderThickness = getBorderThickness();
        NewState.FontSize = getFontSize();
        NewState.FontStyle = getFontStyle();
        NewState.FreeSpaceText = getFreeSpaceText();
        NewState.isFreeSpace = isFreeSpace();
        NewState.MaxHeight = getMaxHeight();
        NewState.MaxWidth = getMaxWidth();
        NewState.PositionX = getPositionX();
        NewState.PositionY = getPositionY();
        NewState.isTitle = isTitle();
        NewState.TitleText = getTitleText();
        NewState.SelectedColor = getSelectedColor();
        NewState.Shape = getShape();
        NewState.SquareNumber = getSquareNumber();
        NewState.TextAnalise = isTextAnalise();
        NewState.TextColor = getTextColor();
        NewState.TextFont = getTextFont();

        return NewState;
    }

}
