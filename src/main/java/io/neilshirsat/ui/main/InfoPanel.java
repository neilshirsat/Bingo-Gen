package io.neilshirsat.ui.main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import io.neilshirsat.components.select.Select;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class InfoPanel extends JPanel {

    private GroupLayout InfoPanelLayout;

    private JTextPane InfoText;

    public InfoPanel() {
        super();

        InfoPanelLayout = new GroupLayout(this);
        super.setLayout(InfoPanelLayout);
        super.setBorder(new EmptyBorder(20,20,20,20));

        InfoText = new JTextPane();
        InfoText.setEditable(false);

        InfoPanelLayout.setHorizontalGroup(InfoPanelLayout.createParallelGroup()
                .addComponent(InfoText)
        );
        InfoPanelLayout.setVerticalGroup(InfoPanelLayout.createSequentialGroup()
                .addComponent(InfoText)
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
