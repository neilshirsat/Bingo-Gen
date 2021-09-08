package io.neilshirsat.render;

import java.awt.*;

public class GridMetadata {

    /**
     * Does the Grid that is Being Rendered Have a Border
     *
     * if false the GridOutsideBorder Properties should be
     * Initialized to Null
     *
     */
    private boolean doesHaveBorder;

    /**
     * The Type of Border that the Grid Has
     *
     * This is stored as an Enum
     *
     * DO NOT DIRECTLY CHANGE THIS THIS IS SET BY THE PARSER
     */
    private BorderType GridOutsideBorderType;

    /**
     * Set the Outside Border Thickness of the Grid
     *
     * Measured in px
     */
    private int GridOutsideBorderThickness;

    /**
     * The Color of the Border
     *
     * DO NOT DIRECTLY CHANGE THIS THIS IS SET BY THE PARSER
     */
    private Color GridOutsideBorderColor;

    /**
     * Do all of the Bingo Squares have the same styling, etc?
     *
     * If not, we need to manually render and style each of the components
     */
    private boolean isUniformCustomizations;

    /**
     * The Background of the Bingo
     *
     * DO NOT DIRECTLY CHANGE THIS THIS IS SET BY THE PARSER
     */
    private Color BackgroundColor;

    /**
     * The Shape of the Background
     *
     * ex. Circular Background, Rounded Rectangle background, etc
     */
    private Shape BackgroundShape;

    /**
     * A Unique ID used to identify each Bingo Square
     */
    private long[] BingoSquareIds;

    /**
     * Event Listeners that are attached to a BingoSquare
     *
     * These Event Listeners Can trigger on Mouse Events, Reload Events, Simulation Events, etc
     *
     * These will probably not be available in the first release
     */
    private BingoSquareActionListeners[] BingoSquareActionListeners;

    /**
     * Contains the Metadata Used to Render Each Object of the Bingo Square
     *
     * DO NOT DIRECTLY CHANGE THIS THIS IS SET BY THE PARSER
     */
    private SquareMetadata[] BingoSquares;

    /**
     * Contains the Metadata if the Grid Squares are Uniform
     *
     * DO NOT DIRECTLY CHANGE THIS THIS IS SET BY THE PARSER
     */
    private UniformSquareMetadata UniformSquareMetadata;


    public boolean isDoesHaveBorder() {
        return doesHaveBorder;
    }

    public void setDoesHaveBorder(boolean doesHaveBorder) {
        this.doesHaveBorder = doesHaveBorder;
    }

    public BorderType getGridOutsideBorderType() {
        return GridOutsideBorderType;
    }

    public void setGridOutsideBorderType(BorderType gridOutsideBorderType) {
        GridOutsideBorderType = gridOutsideBorderType;
    }

    public int getGridOutsideBorderThickness() {
        return GridOutsideBorderThickness;
    }

    public void setGridOutsideBorderThickness(int gridOutsideBorderThickness) {
        GridOutsideBorderThickness = gridOutsideBorderThickness;
    }

    public Color getGridOutsideBorderColor() {
        return GridOutsideBorderColor;
    }

    public void setGridOutsideBorderColor(Color gridOutsideBorderColor) {
        GridOutsideBorderColor = gridOutsideBorderColor;
    }

    public boolean isUniformCustomizations() {
        return isUniformCustomizations;
    }

    public void setUniformCustomizations(boolean uniformCustomizations) {
        isUniformCustomizations = uniformCustomizations;
    }

    public Color getBackgroundColor() {
        return BackgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        BackgroundColor = backgroundColor;
    }

    public Shape getBackgroundShape() {
        return BackgroundShape;
    }

    public void setBackgroundShape(Shape backgroundShape) {
        BackgroundShape = backgroundShape;
    }

    public long[] getBingoSquareIds() {
        return BingoSquareIds;
    }

    public void setBingoSquareIds(long[] bingoSquareIds) {
        BingoSquareIds = bingoSquareIds;
    }

    public io.neilshirsat.render.BingoSquareActionListeners[] getBingoSquareActionListeners() {
        return BingoSquareActionListeners;
    }

    public void setBingoSquareActionListeners(io.neilshirsat.render.BingoSquareActionListeners[] bingoSquareActionListeners) {
        BingoSquareActionListeners = bingoSquareActionListeners;
    }

    public SquareMetadata[] getBingoSquares() {
        return BingoSquares;
    }

    public void setBingoSquares(SquareMetadata[] bingoSquares) {
        BingoSquares = bingoSquares;
    }

    public io.neilshirsat.render.UniformSquareMetadata getUniformSquareMetadata() {
        return UniformSquareMetadata;
    }

    public void setUniformSquareMetadata(io.neilshirsat.render.UniformSquareMetadata uniformSquareMetadata) {
        UniformSquareMetadata = uniformSquareMetadata;
    }

}
