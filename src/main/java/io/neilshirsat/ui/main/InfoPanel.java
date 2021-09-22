package io.neilshirsat.ui.main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDraculaIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;
import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;
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
        InfoText.setText("""
                **Remember to Give this Project a Star on Github at https://github.com/neilshirsat/Bingo-Gen
                
                Use the Style the Bingo Tab to customize the Colors of the Bingo. You can either select a Theme, customize the colors, shapes, text of the Board, or style each Bingo Square Individually. Use Customize Individual Bingo Square Styling to Customize each Individual Bingo Squares.
                
                The Preview Tab allows for Previewing the Bingo Style. (The Preview is not the Simulator, so all squares are Marked with Coordinates)
                
                The Start Simulation Tab Allows the User to Create a Simulation. When you create a simulation, a widget will popup asking for the Seed, Amount of Days, Amount of Cards, and Amount of Winners. Once the Simulation Window Pops Up the User can roll using the Roll Button, Change Cards using the Spinner, See a Visual of the Winners for Each Turn using the Winners Graph, and See the Results on the Table. After the Simulation Ends, the User will be able to see a Table of the Results, which can be exported, and Export the Bingo Board as a PNG, JPG(don't use JPG), or PDF. Remember, If you want to print out the PDF to a local printer, you need to set the print area of the printout.
                
                You can also Toggle the Application Theme in Settings.
                
                If You Enjoyed this, Please Share this With Your Friends.
                
                **If you want to build this project from source clone the repository at https://github.com/neilshirsat/Bingo-Gen and run the gradle commands you wish to to run the project, compile the java files to the classpath, and build the project
                
                Submit Issues at https://github.com/neilshirsat/Bingo-Gen
                
                """);

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
