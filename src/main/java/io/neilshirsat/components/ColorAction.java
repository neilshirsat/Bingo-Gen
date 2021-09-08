package io.neilshirsat.components;

import java.awt.*;

public interface ColorAction {

    /**
     * Callback which is triggered when the Color is chosen
     * by the color picker
     *
     * @param event
     */
    void actionPerformed( Color event );

}
