package io.neilshirsat.ui.bingo;

import java.awt.*;

public class BingoState {

    private BingoStateWatcher BingoStateWatcher;

    private BingoSquareState[] TitleSquares;

    private BingoSquareState[][] BingoSquares;

    private Color BaseBackgroundColor;

    private String BingoBoardId = "0";

    private Color BingoIdColor;

    private Font BingoIdFont;

    public io.neilshirsat.ui.bingo.BingoStateWatcher getBingoStateWatcher() {
        return BingoStateWatcher;
    }

    public void setBingoStateWatcher(io.neilshirsat.ui.bingo.BingoStateWatcher bingoStateWatcher) {
        BingoStateWatcher = bingoStateWatcher;
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
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.BACKGROUND_COLOR);
        }
    }

    public String getBingoBoardId() {
        return BingoBoardId;
    }

    public void setBingoBoardId(String bingoBoardId) {
        BingoBoardId = bingoBoardId;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.BOARD_ID);
        }
    }

    public Color getBingoIdColor() {
        return BingoIdColor;
    }

    public void setBingoIdColor(Color bingoIdColor) {
        BingoIdColor = bingoIdColor;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.ID_COLOR);
        }
    }

    public Font getBingoIdFont() {
        return BingoIdFont;
    }

    public void setBingoIdFont(Font bingoIdFont) {
        BingoIdFont = bingoIdFont;
        if (getBingoStateWatcher() != null) {
            getBingoStateWatcher().stateChange(BingoProperties.ID_FONT);
        }
    }


}
