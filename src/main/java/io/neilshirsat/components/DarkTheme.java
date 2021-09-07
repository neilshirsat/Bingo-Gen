package io.neilshirsat.components;

import mdlaf.themes.AbstractMaterialTheme;
import mdlaf.utils.MaterialColors;

import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class DarkTheme extends AbstractMaterialTheme {

    public ColorUIResource WindowBackgroundColor;

    public ColorUIResource WindowTitleBarBackground;

    @Override
    protected void installColor() {
        this.backgroundPrimary = new ColorUIResource(45, 48, 56);
        this.highlightBackgroundPrimary = new ColorUIResource(66, 179, 176);

        this.textColor = new ColorUIResource(255, 255, 255);
        this.disableTextColor = new ColorUIResource(170, 170, 170);

        this.buttonBackgroundColor = new ColorUIResource(45, 48, 56);
        this.buttonBackgroundColorMouseHover = new ColorUIResource(81, 86, 101);
        this.buttonDefaultBackgroundColorMouseHover = new ColorUIResource(23, 137, 134);
        this.buttonDefaultBackgroundColor = new ColorUIResource(66, 179, 176);
        this.buttonDisabledBackground = new ColorUIResource(66, 69, 76);

        this.buttonFocusColor = buttonDefaultBackgroundColor;
        this.buttonDefaultFocusColor = MaterialColors.WHITE;
        this.buttonBorderColor = MaterialColors.WHITE;
        this.buttonColorHighlight = buttonBackgroundColorMouseHover;

        this.selectedInDropDownBackgroundComboBox = new ColorUIResource(249, 192, 98);
        this.selectedForegroundComboBox = MaterialColors.BLACK;

        this.menuBackground = new ColorUIResource(59, 62, 69);
        this.menuBackgroundMouseHover = new ColorUIResource(249, 192, 98);

        this.trackColorScrollBar = new ColorUIResource(81, 86, 101);
        this.thumbColorScrollBar = new ColorUIResource(155, 155, 155);

        this.trackColorSlider = new ColorUIResource(119, 119, 119);
        this.haloColorSlider = MaterialColors.bleach(new Color(249, 192, 98), 0.2f);

        this.mouseHoverButtonColorSpinner = backgroundPrimary;

        this.highlightColorTabbedPane = new ColorUIResource(45, 48, 56);
        this.borderHighlightColorTabbedPane = new ColorUIResource(45, 48, 56);
        this.focusColorLineTabbedPane = new ColorUIResource(249, 192, 98);
        this.disableColorTabTabbedPane = new ColorUIResource(170, 170, 170);

        this.backgroundTable = new ColorUIResource(45, 48, 56);
        this.backgroundTableHeader = new ColorUIResource(66, 179, 176);
        this.selectionBackgroundTable = new ColorUIResource(126, 132, 153);
        this.gridColorTable = new ColorUIResource(151, 151, 151);
        this.alternateRowBackgroundTable = new ColorUIResource(59, 62, 69);

        this.backgroundTextField = new ColorUIResource(81, 86, 101);
        this.inactiveForegroundTextField = MaterialColors.WHITE;
        this.inactiveBackgroundTextField = new ColorUIResource(81, 86, 101);
        this.selectionBackgroundTextField = new ColorUIResource(249, 192, 98);
        super.disabledBackgroudnTextField = new ColorUIResource(94, 94, 94);
        super.disabledForegroundTextField = new ColorUIResource(170, 170, 170);
        this.selectionForegroundTextField = MaterialColors.BLACK;
        this.inactiveColorLineTextField = MaterialColors.WHITE;
        this.activeColorLineTextField = new ColorUIResource(249, 192, 98);

        this.titleBackgroundGradientStartTaskPane = MaterialColors.GRAY_300;
        this.titleBackgroundGradientEndTaskPane = MaterialColors.GRAY_500;
        this.titleOverTaskPane = new ColorUIResource(249, 192, 98);
        this.specialTitleOverTaskPane = MaterialColors.WHITE;

        this.selectionBackgroundList = new ColorUIResource(249, 192, 98);
        this.selectionForegroundList = MaterialColors.BLACK;

        this.backgroundProgressBar = new ColorUIResource(81, 86, 101);
        this.foregroundProgressBar = MaterialColors.WHITE;

        this.withoutIconSelectedForegoundToggleButton = MaterialColors.BLACK;
        this.withoutIconForegroundToggleButton = MaterialColors.WHITE;

        this.colorDividierSplitPane = MaterialColors.COSMO_DARK_GRAY;
        this.colorDividierFocusSplitPane = new ColorUIResource(249, 192, 98);

        super.backgroundSeparator = MaterialColors.GRAY_300;
        super.foregroundSeparator = MaterialColors.GRAY_300;

        super.backgroundToolTip = backgroundPrimary;

    }

    @Override
    public String getName() {
        return null;
    }
}
