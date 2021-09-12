package io.neilshirsat.components.colorpicker;

import java.awt.*;

public class ColorEvent {

    private Color SelectedColor;

    public ColorEvent(Color SelectedColor) {
        this.SelectedColor = SelectedColor;
    }

    public Color getSelectedColor() {
        return SelectedColor;
    }

    public void setSelectedColor(Color selectedColor) {
        SelectedColor = selectedColor;
    }

}
