package io.neilshirsat.ui.bingo;

import io.neilshirsat.util.ShapeType;

import javax.swing.*;
import java.awt.*;

public class BingoSquare extends JPanel {

    static int inc = 0;

    private BingoSquareState State;

    public BingoSquare( BingoSquareState State ){
        this.State = State;
        super.setOpaque(false);
        super.setBackground(State.getBaseBackgroundColor());
        State.setBingoStateWatcher(e-> {
            System.out.println("Bingo Square" + " " + (inc++));
            System.out.println(State.isSelected());
            repaint();
        });
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;

        //Set Graphics Analise
        if (State.isAnalise()) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }

        //Set Graphics Text Analise
        if (State.isTextAnalise()){
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        }

        //Draw the Border for Rectangle Shape
        if (State.getShape() == ShapeType.RECTANGLE) {
            g2d.setPaint(State.isSelected() ? State.getSelectedColor() : State.getBackgroundColor());
            g2d.fillRect(0, 0, getWidth(), getHeight());

            //Set the Border Color
            g2d.setColor(State.getBorderColor());
            g2d.setStroke(new BasicStroke(State.getBorderThickness()));
            g2d.drawRect(0, 0, getWidth(), getHeight());
        }

        //Draw the Border for Circle Shape
        else if (State.getShape() == ShapeType.CIRCLE) {
            g2d.setPaint(State.isSelected() ? State.getSelectedColor() : State.getBackgroundColor());
            g2d.fillOval(0, 0, getWidth(), getHeight());

            //Set the Border Color
            g2d.setColor(State.getBorderColor());
            g2d.setStroke(new BasicStroke(State.getBorderThickness()));
            g2d.drawOval(0, 0, getWidth(), getHeight());
        }

        if (State.getFontStyle() == Font.PLAIN || State.getFontStyle() == Font.BOLD || State.getFontStyle() == Font.ITALIC) {
            //noinspection MagicConstant
            g2d.setFont( State.getTextFont().deriveFont(State.getFontStyle(), State.getFontSize()) );
        }
        else {
            g2d.setFont( State.getTextFont().deriveFont(State.getFontSize()) );
        }

        //Set the Text Color
        g2d.setColor(State.getTextColor());

        //Draw the Free Space Text to the Screen
        if (State.isFreeSpace()) {
            FontMetrics fm = g2d.getFontMetrics();

            int stringWidth = fm.stringWidth(State.getFreeSpaceText());
            int stringAccent = fm.getAscent();
            int xCoordinate = getWidth() / 2 - stringWidth / 2;
            int yCoordinate = getHeight() / 2 + stringAccent / 2;
            g2d.drawString(State.getFreeSpaceText(), xCoordinate, yCoordinate);
        }

        //Draw the Free Space Text to the Screen
        else if (State.isTitle()) {
            FontMetrics fm = g2d.getFontMetrics();

            int stringWidth = fm.stringWidth(State.getTitleText());
            int stringAccent = fm.getAscent();
            int xCoordinate = getWidth() / 2 - stringWidth / 2;
            int yCoordinate = getHeight() / 2 + stringAccent / 2;
            g2d.drawString(State.getTitleText(), xCoordinate, yCoordinate);
        }

        //Draw the Square Number Text to the Screen
        else {
            FontMetrics fm = g2d.getFontMetrics();

            int stringWidth = fm.stringWidth(State.getSquareNumber());
            int stringAccent = fm.getAscent();
            int xCoordinate = getWidth() / 2 - stringWidth / 2;
            int yCoordinate = getHeight() / 2 + stringAccent / 2;
            g2d.drawString(State.getSquareNumber(), xCoordinate, yCoordinate);
        }

    }

    public BingoSquareState getState() {
        return State;
    }

    public void setState(BingoSquareState state) {
        State = state;
    }

}
