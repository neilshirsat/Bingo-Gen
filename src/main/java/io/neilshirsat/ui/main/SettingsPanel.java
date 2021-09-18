package io.neilshirsat.ui.main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;
import io.neilshirsat.components.select.Select;
import io.neilshirsat.ui.bingo.BingoState;
import io.neilshirsat.ui.customize.CustomizeTab;
import io.neilshirsat.ui.customize.CustomizeWindow;
import io.neilshirsat.util.ShapeType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class SettingsPanel extends JPanel {

    private ArrayList<String> WindowThemes;

    private Select<String> SetWindowTheme;

    private GroupLayout SettingsTabLayout;

    public SettingsPanel() {
        super();

        this.SettingsTabLayout = new GroupLayout(this);
        this.setLayout(SettingsTabLayout);
        super.setBorder(new EmptyBorder(20,20,20,20));

        WindowThemes = new ArrayList<>();
        WindowThemes.add("Light");
        WindowThemes.add("Dark");
        WindowThemes.add("Carbon");
        WindowThemes.add("Dracula");
        WindowThemes.add("Dracula Contrast");
        WindowThemes.add("Material Lighter");
        WindowThemes.add("Material Lighter Contrast");
        WindowThemes.add("Material Darker");
        WindowThemes.add("Material Darker Contrast");
        WindowThemes.add("Material Oceanic");
        WindowThemes.add("Material Oceanic Contrast");
        WindowThemes.add("Material Oceanic");
        WindowThemes.add("Material Oceanic Contrast");
        WindowThemes.add("Material Deep Ocean");
        WindowThemes.add("Material Deep Ocean Contrast");
        WindowThemes.add("Material Design Dark");
        WindowThemes.add("Material Palenight");
        WindowThemes.add("Material Palenight Contrast");
        WindowThemes.add("One Dark Theme");
        WindowThemes.add("Solarized Light");
        WindowThemes.add("Solarized Light Contrast");
        WindowThemes.add("Solarized Dark");
        WindowThemes.add("Solarized Dark Contrast");
        WindowThemes.add("Github Light");
        WindowThemes.add("Github Light Contrast");
        WindowThemes.add("Github Dark");
        WindowThemes.add("Github Dark Contrast");
        WindowThemes.add("Arc");
        WindowThemes.add("Arc Orange");
        WindowThemes.add("Arc Dark");
        WindowThemes.add("Cobalt 2");
        WindowThemes.add("Cyan Light");
        WindowThemes.add("Dark Purple");
        WindowThemes.add("Gradianto Dark Fuchsia");
        WindowThemes.add("Gradianto Deep Ocean");
        WindowThemes.add("Gradianto Midnight Blue");
        WindowThemes.add("Gradianto Nature Green");
        WindowThemes.add("OS Theme - NOT RECOMMENDED FOR USE");
        SetWindowTheme = new Select<>(setStringArray(WindowThemes));
        SetWindowTheme.setLabel("Bingo Theme: ");
        SetWindowTheme.getSelectList().addActionListener(e->{
            String value = (String) SetWindowTheme.getSelectList().getSelectedItem();

            assert value != null;
            switch (value) {
                case "Light":
                    FlatLightLaf.setup();
                    break;
                case "Dark":
                    FlatDarkLaf.setup();
                    break;
                case "Carbon":
                    FlatCarbonIJTheme.setup();
                    break;
                case "Dracula":
                    FlatDraculaIJTheme.setup();
                    break;
                case "Dracula Contrast":
                    FlatDraculaContrastIJTheme.setup();
                    break;
                case "Material Lighter":
                    FlatMaterialLighterIJTheme.setup();
                    break;
                case "Material Darker":
                    FlatMaterialDarkerIJTheme.setup();
                    break;
                case "Material Lighter Contrast":
                    FlatMaterialLighterContrastIJTheme.setup();
                    break;
                case "Material Darker Contrast":
                    FlatMaterialDarkerContrastIJTheme.setup();
                    break;
                case "Material Oceanic":
                    FlatMaterialOceanicIJTheme.setup();
                    break;
                case "Material Oceanic Contrast":
                    FlatMaterialOceanicContrastIJTheme.setup();
                    break;
                case "Material Deep Ocean":
                    FlatMaterialDeepOceanIJTheme.setup();
                    break;
                case "Material Deep Ocean Contrast":
                    FlatMaterialDeepOceanContrastIJTheme.setup();
                    break;
                case "Material Design Dark":
                    FlatMaterialDesignDarkIJTheme.setup();
                    break;
                case "Material Palenight":
                    FlatMaterialPalenightIJTheme.setup();
                    break;
                case "Material Palenight Contrast":
                    FlatMaterialPalenightContrastIJTheme.setup();
                    break;
                case "One Dark Theme":
                    FlatOneDarkIJTheme.setup();
                    break;
                case "Solarized Light":
                    FlatSolarizedLightIJTheme.setup();
                    break;
                case "Solarized Light Contrast":
                    FlatSolarizedLightContrastIJTheme.setup();
                    break;
                case "Solarized Dark":
                    FlatSolarizedDarkIJTheme.setup();
                    break;
                case "Solarized Dark Contrast":
                    FlatSolarizedDarkContrastIJTheme.setup();
                    break;
                case "Github Light":
                    FlatGitHubIJTheme.setup();
                    break;
                case "Github Light Contrast":
                    FlatGitHubContrastIJTheme.setup();
                    break;
                case "Github Dark":
                    FlatGitHubDarkIJTheme.setup();
                    break;
                case "Github Dark Contrast":
                    FlatGitHubDarkContrastIJTheme.setup();
                    break;
                case "Arc":
                    FlatArcIJTheme.setup();
                    break;
                case "Arc Orange":
                    FlatArcOrangeIJTheme.setup();
                    break;
                case "Arc Dark":
                    FlatArcDarkIJTheme.setup();
                    break;
                case "Cobalt 2":
                    FlatCobalt2IJTheme.setup();
                    break;
                case "Cyan Light":
                    FlatCyanLightIJTheme.setup();
                    break;
                case "Dark Purple":
                    FlatDarkPurpleIJTheme.setup();
                    break;
                case "Gradianto Dark Fuchsia":
                    FlatGradiantoDarkFuchsiaIJTheme.setup();
                    break;
                case "Gradianto Deep Ocean":
                    FlatGradiantoDeepOceanIJTheme.setup();
                    break;
                case "Gradianto Midnight Blue":
                    FlatGradiantoMidnightBlueIJTheme.setup();
                    break;
                case "Gradianto Nature Green":
                    FlatGradiantoNatureGreenIJTheme.setup();
                    break;
                case "OS Theme - NOT RECOMMENDED FOR USE":
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }
                    break;
            }
            SwingUtilities.updateComponentTreeUI(SwingUtilities.getRoot(this));

        });

        SettingsTabLayout.setHorizontalGroup(SettingsTabLayout.createParallelGroup()
                .addComponent(SetWindowTheme)
        );
        SettingsTabLayout.setVerticalGroup(SettingsTabLayout.createSequentialGroup()
                .addComponent(SetWindowTheme)
        );

    }

    public String[] setStringArray( ArrayList<String> al ) {
        String[] arr = new String[al.size()];
        for (int i = 0; i < al.size(); i++) {
            arr[i] = al.get(i);
        }
        return arr;
    }

}
