package io.neilshirsat.ui.main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaContrastIJTheme;
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
        WindowThemes.add("One Dark Theme");
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
        WindowThemes.add("Custom");
        SetWindowTheme = new Select<String>(setStringArray(WindowThemes));
        SetWindowTheme.setLabel("Bingo Theme: ");
        SetWindowTheme.getSelectList().addActionListener(e->{
            String value = (String) SetWindowTheme.getSelectList().getSelectedItem();

            assert value != null;
            if (value.equals("Light")) {
                FlatLightLaf.setup();
            }
            else if (value.equals("Dark")) {
                FlatDarkLaf.setup();
            }
            else if (value.equals("Carbon")) {
                FlatCarbonIJTheme.setup();
            }
            else if (value.equals("Dracula")) {
                FlatDraculaIJTheme.setup();
            }
            else if (value.equals("Dracula Contrast")) {
                FlatDraculaContrastIJTheme.setup();
            }
            else if (value.equals("One Dark Theme")) {
                FlatOneDarkIJTheme.setup();
            }
            else if (value.equals("Arc")) {
                FlatArcIJTheme.setup();
            }
            else if (value.equals("Arc Orange")) {
                FlatArcOrangeIJTheme.setup();
            }
            else if (value.equals("Arc Dark")) {
                FlatArcDarkIJTheme.setup();
            }
            else if (value.equals("Cobalt 2")) {
                FlatCobalt2IJTheme.setup();
            }
            else if (value.equals("Cyan Light")) {
                FlatCyanLightIJTheme.setup();
            }
            else if (value.equals("Dark Purple")) {
                FlatDarkPurpleIJTheme.setup();
            }
            else if (value.equals("Gradianto Dark Fuchsia")) {
                FlatGradiantoDarkFuchsiaIJTheme.setup();
            }
            else if (value.equals("Gradianto Deep Ocean")) {
                FlatGradiantoDeepOceanIJTheme.setup();
            }
            else if (value.equals("Gradianto Midnight Blue")) {
                FlatGradiantoMidnightBlueIJTheme.setup();
            }
            else if (value.equals("Gradianto Nature Green")) {
                FlatGradiantoNatureGreenIJTheme.setup();
            }
            else if (value.equals("OS Theme - NOT RECOMMENDED FOR USE")) {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
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
