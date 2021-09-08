package io.neilshirsat.render;

public class GraphicsRenderMeta {

    /**
     * X Coordinate that the Graphics Needs to be Rendered At
     */
    private int PositionX;

    /**
     * Y Coordinate that the Graphics Needs to be Rendered At
     */
    private int PositionY;

    /**
     * Length of the Object that will Be Rendered
     */
    private int Height;

    /**
     * Width of the Object that will be Rendered
     */
    private int Width;

    /**
     * The Type of Graphics that needs to be Rendered
     *
     * This Can Either Be a String or a Line or an Arc or a Circle
     */
    private RenderType GraphicsRenderType;

    /**
     * The String that Needs to Be Rendered
     *
     * This is Only Defined is the GraphicsRenderType is a String
     */
    private String StringToRender;

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

    public int getHeight() {
        return Height;
    }

    public void setHeight(int height) {
        Height = height;
    }

    public int getWidth() {
        return Width;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public RenderType getGraphicsRenderType() {
        return GraphicsRenderType;
    }

    public void setGraphicsRenderType(RenderType graphicsRenderType) {
        GraphicsRenderType = graphicsRenderType;
    }

    public String getStringToRender() {
        return StringToRender;
    }

    public void setStringToRender(String stringToRender) {
        StringToRender = stringToRender;
    }

}
