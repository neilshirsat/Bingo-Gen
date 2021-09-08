package io.neilshirsat.render;

/**
 * @author Neil Shirsat
 *
 * Parse the JSON File in order
 */
public class Parser {

    private String Name;

    private String Encoding;

    private String Version;

    private int Size;

    private int[] LowerBound;

    private int[] UpperBound;

    private int SquareSize;

    private int PositionX;

    private int PositionY;

    private String[] FontResources;

    private String[] ImageResources;

    private GridMetadata BingoGridMetadata;

    private GraphicContext[] GraphicContexts;

    public Parser() {

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEncoding() {
        return Encoding;
    }

    public void setEncoding(String encoding) {
        Encoding = encoding;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public int[] getLowerBound() {
        return LowerBound;
    }

    public void setLowerBound(int[] lowerBound) {
        LowerBound = lowerBound;
    }

    public int[] getUpperBound() {
        return UpperBound;
    }

    public void setUpperBound(int[] upperBound) {
        UpperBound = upperBound;
    }

    public int getSquareSize() {
        return SquareSize;
    }

    public void setSquareSize(int squareSize) {
        SquareSize = squareSize;
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

    public String[] getFontResources() {
        return FontResources;
    }

    public void setFontResources(String[] fontResources) {
        FontResources = fontResources;
    }

    public String[] getImageResources() {
        return ImageResources;
    }

    public void setImageResources(String[] imageResources) {
        ImageResources = imageResources;
    }

    public GridMetadata getBingoGridMetadata() {
        return BingoGridMetadata;
    }

    public void setBingoGridMetadata(GridMetadata bingoGridMetadata) {
        BingoGridMetadata = bingoGridMetadata;
    }

    public GraphicContext[] getGraphicContexts() {
        return GraphicContexts;
    }

    public void setGraphicContexts(GraphicContext[] graphicContexts) {
        GraphicContexts = graphicContexts;
    }

}
