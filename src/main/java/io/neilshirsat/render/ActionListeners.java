package io.neilshirsat.render;

import java.util.ArrayList;

public interface ActionListeners {

    /**
     * When the Mouse is Pressed Down
     */
    public void onMouseDown();

    /**
     * When the Mouse is Released
     */
    public void onMouseUp();

    /**
     * When the Mouse is Hovered over the element
     */
    public void onMouseOver();

    /**
     * When the Mouse Enters an Element
     */
    public void onMouseEnter();

    /**
     * When the Mouse Leaves an Element
     */
    public void onMouseLeave();

    /**
     * When the Mouse Clicks
     */
    public void onMouseClick();

    /**
     * When the Action is Performed
     */
    public void onAction();

}
