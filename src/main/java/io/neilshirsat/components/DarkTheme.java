package io.neilshirsat.components;

import mdlaf.themes.AbstractMaterialTheme;
import mdlaf.utils.MaterialColors;

import javax.swing.plaf.ColorUIResource;

public class DarkTheme extends AbstractMaterialTheme {

    public ColorUIResource WindowBackgroundColor;

    public ColorUIResource WindowTitleBarBackground;

    @Override
    protected void installColor() {
        this.backgroundPrimary = MaterialColors.BLUE_400;
        this.textColor = MaterialColors.BLACK;

        this.WindowBackgroundColor = MaterialColors.WHITE;
        this.WindowTitleBarBackground = MaterialColors.GRAY_800;
    }

    @Override
    public String getName() {
        return null;
    }
}
