package io.neilshirsat.ui.bingo;

import io.neilshirsat.Application;
import io.neilshirsat.util.ShapeType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Objects;

/**
 * @author Neil Shirsat
 */
public class BingoPreview extends JFrame {

    private BingoState BingoState;

    private BingoState PreviewState;

    private BingoPanel BingoPanel;

    private io.neilshirsat.util.WindowCloseListener WindowCloseListener;

    public BingoPreview(BingoState BingoState) {
        super();
        this.BingoState = BingoState;
        this.PreviewState = BingoState.cloneBingoState();

        BingoState.addBingoStateWatcher(e->{
            switch (e) {
                case BACKGROUND_COLOR -> PreviewState.setBaseBackgroundColor(
                        BingoState.getBaseBackgroundColor()
                );
                case ID_COLOR -> PreviewState.setBingoIdColor(
                        BingoState.getBingoIdColor()
                );
                case ID_FONT -> PreviewState.setBingoIdFont(
                        BingoState.getBingoIdFont()
                );
            }
        });

        for (int i = 0; i < 5; i++) {
            int finalTitleI = i;
            BingoState.getTitleSquares()[i].setBingoStateWatcher(e->{
                switch (e) {
                    case POSITION_X -> PreviewState.getTitleSquares()[finalTitleI].setPositionX(
                            BingoState.getTitleSquares()[finalTitleI].getPositionX()
                    );
                    case POSITION_Y -> PreviewState.getTitleSquares()[finalTitleI].setPositionY(
                            BingoState.getTitleSquares()[finalTitleI].getPositionY()
                    );
                    case MAX_HEIGHT -> PreviewState.getTitleSquares()[finalTitleI].setMaxHeight(
                            BingoState.getTitleSquares()[finalTitleI].getMaxHeight()
                    );
                    case MAX_WIDTH -> PreviewState.getTitleSquares()[finalTitleI].setMaxWidth(
                            BingoState.getTitleSquares()[finalTitleI].getMaxWidth()
                    );
                    case BACKGROUND_COLOR -> PreviewState.getTitleSquares()[finalTitleI].setBackgroundColor(
                            BingoState.getTitleSquares()[finalTitleI].getBackgroundColor()
                    );
                    case TEXT_COLOR -> PreviewState.getTitleSquares()[finalTitleI].setTextColor(
                            BingoState.getTitleSquares()[finalTitleI].getTextColor()
                    );
                    case TEXT_FONT -> PreviewState.getTitleSquares()[finalTitleI].setTextFont(
                            BingoState.getTitleSquares()[finalTitleI].getTextFont()
                    );
                    case TEXT_FONT_STYLE -> PreviewState.getTitleSquares()[finalTitleI].setFontStyle(
                            BingoState.getTitleSquares()[finalTitleI].getFontStyle()
                    );
                    case TEXT_FONT_SIZE -> PreviewState.getTitleSquares()[finalTitleI].setFontSize(
                            BingoState.getTitleSquares()[finalTitleI].getFontSize()
                    );
                    case SHAPE -> PreviewState.getTitleSquares()[finalTitleI].setShape(
                            BingoState.getTitleSquares()[finalTitleI].getShape()
                    );
                    case BORDER_THICKNESS -> PreviewState.getTitleSquares()[finalTitleI].setBorderThickness(
                            BingoState.getTitleSquares()[finalTitleI].getBorderThickness()
                    );
                    case BORDER_COLOR -> PreviewState.getTitleSquares()[finalTitleI].setBorderColor(
                            BingoState.getTitleSquares()[finalTitleI].getBorderColor()
                    );
                    case TEXT_ANALISE -> PreviewState.getTitleSquares()[finalTitleI].setTextAnalise(
                            BingoState.getTitleSquares()[finalTitleI].isAnalise()
                    );
                    case ANALISE -> PreviewState.getTitleSquares()[finalTitleI].setAnalise(
                            BingoState.getTitleSquares()[finalTitleI].isAnalise()
                    );
                    case IS_FREE_SPACE -> PreviewState.getTitleSquares()[finalTitleI].setFreeSpace(
                            BingoState.getTitleSquares()[finalTitleI].isFreeSpace()
                    );
                    case FREE_SPACE_TEXT -> PreviewState.getTitleSquares()[finalTitleI].setFreeSpaceText(
                            BingoState.getTitleSquares()[finalTitleI].getFreeSpaceText()
                    );
                    case IS_TITLE -> PreviewState.getTitleSquares()[finalTitleI].setTitle(
                            BingoState.getTitleSquares()[finalTitleI].isTitle()
                    );
                    case TITLE_TEXT -> PreviewState.getTitleSquares()[finalTitleI].setTitleText(
                            BingoState.getTitleSquares()[finalTitleI].getTitleText()
                    );
                    case SELECTED_COLOR -> PreviewState.getTitleSquares()[finalTitleI].setSelectedColor(
                            BingoState.getTitleSquares()[finalTitleI].getSelectedColor()
                    );
                }
            });
            for (int j = 0; j < 5; j++) {
                int finalI = i;
                int finalJ = j;
                BingoState.getBingoSquares()[i][j].setBingoStateWatcher(e->{
                    switch (e) {
                        case POSITION_X -> PreviewState.getBingoSquares()[finalI][finalJ].setPositionX(
                                BingoState.getBingoSquares()[finalI][finalJ].getPositionX()
                        );
                        case POSITION_Y -> PreviewState.getBingoSquares()[finalI][finalJ].setPositionY(
                                BingoState.getBingoSquares()[finalI][finalJ].getPositionY()
                        );
                        case MAX_HEIGHT -> PreviewState.getBingoSquares()[finalI][finalJ].setMaxHeight(
                                BingoState.getBingoSquares()[finalI][finalJ].getMaxHeight()
                        );
                        case MAX_WIDTH -> PreviewState.getBingoSquares()[finalI][finalJ].setMaxWidth(
                                BingoState.getBingoSquares()[finalI][finalJ].getMaxWidth()
                        );
                        case BACKGROUND_COLOR -> PreviewState.getBingoSquares()[finalI][finalJ].setBackgroundColor(
                                BingoState.getBingoSquares()[finalI][finalJ].getBackgroundColor()
                        );
                        case TEXT_COLOR -> PreviewState.getBingoSquares()[finalI][finalJ].setTextColor(
                                BingoState.getBingoSquares()[finalI][finalJ].getTextColor()
                        );
                        case TEXT_FONT -> PreviewState.getBingoSquares()[finalI][finalJ].setTextFont(
                                BingoState.getBingoSquares()[finalI][finalJ].getTextFont()
                        );
                        case TEXT_FONT_STYLE -> PreviewState.getBingoSquares()[finalI][finalJ].setFontStyle(
                                BingoState.getBingoSquares()[finalI][finalJ].getFontStyle()
                        );
                        case TEXT_FONT_SIZE -> PreviewState.getBingoSquares()[finalI][finalJ].setFontSize(
                                BingoState.getBingoSquares()[finalI][finalJ].getFontSize()
                        );
                        case SHAPE -> PreviewState.getBingoSquares()[finalI][finalJ].setShape(
                                BingoState.getBingoSquares()[finalI][finalJ].getShape()
                        );
                        case BORDER_THICKNESS -> PreviewState.getBingoSquares()[finalI][finalJ].setBorderThickness(
                                BingoState.getBingoSquares()[finalI][finalJ].getBorderThickness()
                        );
                        case BORDER_COLOR -> PreviewState.getBingoSquares()[finalI][finalJ].setBorderColor(
                                BingoState.getBingoSquares()[finalI][finalJ].getBorderColor()
                        );
                        case TEXT_ANALISE -> PreviewState.getBingoSquares()[finalI][finalJ].setTextAnalise(
                                BingoState.getBingoSquares()[finalI][finalJ].isAnalise()
                        );
                        case ANALISE -> PreviewState.getBingoSquares()[finalI][finalJ].setAnalise(
                                BingoState.getBingoSquares()[finalI][finalJ].isAnalise()
                        );
                        case IS_FREE_SPACE -> PreviewState.getBingoSquares()[finalI][finalJ].setFreeSpace(
                                BingoState.getBingoSquares()[finalI][finalJ].isFreeSpace()
                        );
                        case FREE_SPACE_TEXT -> PreviewState.getBingoSquares()[finalI][finalJ].setFreeSpaceText(
                                BingoState.getBingoSquares()[finalI][finalJ].getFreeSpaceText()
                        );
                        case IS_TITLE -> PreviewState.getBingoSquares()[finalI][finalJ].setTitle(
                                BingoState.getBingoSquares()[finalI][finalJ].isTitle()
                        );
                        case TITLE_TEXT -> PreviewState.getBingoSquares()[finalI][finalJ].setTitleText(
                                BingoState.getBingoSquares()[finalI][finalJ].getTitleText()
                        );
                        case SELECTED_COLOR -> PreviewState.getBingoSquares()[finalI][finalJ].setSelectedColor(
                                BingoState.getBingoSquares()[finalI][finalJ].getSelectedColor()
                        );
                    }
                });
            }
        }

        super.setTitle("Bingo Board Preview");
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                if (getWindowCloseListener() != null) {
                    getWindowCloseListener().close();
                }
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        Dimension WindowDimension = Toolkit.getDefaultToolkit().getScreenSize();
        super.setSize(  (int)WindowDimension.getHeight() * 15/16 * 5/6 , (int)WindowDimension.getHeight() * 15/16);
        super.setLocation(WindowDimension.width/2-this.getSize().width/2,
                WindowDimension.height/2-this.getSize().height/2
        );

        BingoPanel = new BingoPanel(PreviewState);

        super.setContentPane(BingoPanel);
    }

    public io.neilshirsat.ui.bingo.BingoState getBingoState() {
        return BingoState;
    }

    public void setBingoState(io.neilshirsat.ui.bingo.BingoState bingoState) {
        BingoState = bingoState;
    }

    public io.neilshirsat.ui.bingo.BingoPanel getBingoPanel() {
        return BingoPanel;
    }

    public void setBingoPanel(io.neilshirsat.ui.bingo.BingoPanel bingoPanel) {
        BingoPanel = bingoPanel;
    }

    public io.neilshirsat.util.WindowCloseListener getWindowCloseListener() {
        return WindowCloseListener;
    }

    public void setWindowCloseListener(io.neilshirsat.util.WindowCloseListener windowCloseListener) {
        WindowCloseListener = windowCloseListener;
    }

}
