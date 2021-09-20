package io.neilshirsat.ui.bingo;

import java.awt.*;
import java.util.ArrayList;

public class BingoState {

    private ArrayList<BingoStateWatcher> BingoStateWatcher = new ArrayList<>();

    private BingoSquareState[] TitleSquares;

    private BingoSquareState[][] BingoSquares;

    private Color BaseBackgroundColor;

    private String BingoBoardId = "0";

    private Color BingoIdColor;

    private Font BingoIdFont;

    public ArrayList<BingoStateWatcher> getBingoStateWatcher() {
        return BingoStateWatcher;
    }

    public void addBingoStateWatcher(BingoStateWatcher bingoStateWatcher) {
        BingoStateWatcher.add(bingoStateWatcher);
    }

    public BingoSquareState[] getTitleSquares() {
        return TitleSquares;
    }

    public void setTitleSquares(BingoSquareState[] titleSquares) {
        TitleSquares = titleSquares;
    }

    public BingoSquareState[][] getBingoSquares() {
        return BingoSquares;
    }

    public void setBingoSquares(BingoSquareState[][] bingoSquares) {
        BingoSquares = bingoSquares;
    }

    public Color getBaseBackgroundColor() {
        return BaseBackgroundColor;
    }

    public void setBaseBackgroundColor(Color baseBackgroundColor) {
        BaseBackgroundColor = baseBackgroundColor;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.BACKGROUND_COLOR);
        }
    }

    public String getBingoBoardId() {
        return BingoBoardId;
    }

    public void setBingoBoardId(String bingoBoardId) {
        BingoBoardId = bingoBoardId;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.BOARD_ID);
        }
    }

    public Color getBingoIdColor() {
        return BingoIdColor;
    }

    public void setBingoIdColor(Color bingoIdColor) {
        BingoIdColor = bingoIdColor;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.ID_COLOR);
        }
    }

    public Font getBingoIdFont() {
        return BingoIdFont;
    }

    public void setBingoIdFont(Font bingoIdFont) {
        BingoIdFont = bingoIdFont;
        for (int i = 0; i < getBingoStateWatcher().size(); i++){
            getBingoStateWatcher().get(i).stateChange(BingoProperties.ID_FONT);
        }
    }

    public BingoState cloneBingoState() {
        BingoState NewState = new BingoState();

        NewState.BingoBoardId = getBingoBoardId();
        NewState.BingoIdColor = getBingoIdColor();
        NewState.BaseBackgroundColor = getBaseBackgroundColor();
        NewState.BingoIdFont = getBingoIdFont();

        NewState.TitleSquares = new BingoSquareState[5];
        for (int i = 0; i < 5; i++) {
            NewState.TitleSquares[i] = getTitleSquares()[i].cloneBingoSquareState();
        }

        NewState.BingoSquares = new BingoSquareState[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                NewState.BingoSquares[i][j] = getBingoSquares()[i][j].cloneBingoSquareState();
            }
        }

        return NewState;
    }

}
